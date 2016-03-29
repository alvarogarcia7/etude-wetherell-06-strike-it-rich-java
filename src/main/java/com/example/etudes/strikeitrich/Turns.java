package com.example.etudes.strikeitrich;

import java.util.ArrayList;
import java.util.List;

public class Turns {
    private final List<Player> players;
    private final Bank bank;
    private final MaterialsCalculator calculator;
    private List<Player> bankrupted;

    static Turns aNew(List<Player> players, Bank bank, MaterialsCalculator calculator) {
        return new Turns(players, bank, calculator);
    }

    private Turns(List<Player> players, Bank bank, MaterialsCalculator calculator) {
        this.players = players;
        this.bank = bank;
        this.calculator = calculator;
        bankrupted = new ArrayList<>();
    }

    public void newTurn() {
        final List<Player> players = validPlayers();
        players.forEach(x -> x.payFixedExpenses(calculator));
        players.forEach(x -> x.rawMaterialUnits(bank.rawMaterialUnitConditions()));
        players.forEach(x -> x.finishedInventoryUnits(bank.finishedInventoryUserConditions()));
        players.forEach(Player::obtainRawMaterialUnitBid);
        for (Player current : players) {
            try {
                current.produceStock();
            } catch (BankruptException e) {
                bankrupted.add(current);
            }
        }
        players.forEach(Player::sellInventory);
        players.forEach(Player::payLoanInterest);
        players.forEach(Player::payOutstandingLoans);
        players.forEach(Player::takeOutLoans);
        players.forEach(Player::orderConstruction);
    }

    private List<Player> validPlayers() {
        final List<Player> players = new ArrayList<>(this.players);
        players.removeAll(bankrupted);
        return players;
    }

    public boolean canStartNew() {
        return validPlayers().size() > 0;
    }
}
