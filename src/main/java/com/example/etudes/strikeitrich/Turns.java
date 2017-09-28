package com.example.etudes.strikeitrich;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        for (Player current : players) {
            try {
                current.payFixedExpenses(calculator);
            } catch (BankruptException e) {
                playerIsBankrupt(current);
            }
        }
        players.stream().filter(Player::isNotBankrupt).forEach(player -> player.rawMaterialUnits(bank.rawMaterialUnitConditions()));
        players.stream().filter(Player::isNotBankrupt).forEach(player -> player.finishedInventoryUnits(bank.finishedInventoryUserConditions()));
        players.stream().filter(Player::isNotBankrupt).forEach(Player::obtainRawMaterialUnitBid);
        for (Player current : players.stream().filter(Player::isNotBankrupt).collect(Collectors.toList())) {
            try {
                current.produceStock();
            } catch (BankruptException e) {
                playerIsBankrupt(current);
            }
        }
        players.stream().filter(Player::isNotBankrupt).forEach(Player::sellInventory);
        players.stream().filter(Player::isNotBankrupt).forEach(Player::payLoanInterest);
        players.stream().filter(Player::isNotBankrupt).forEach(Player::payOutstandingLoans);
        players.stream().filter(Player::isNotBankrupt).forEach(Player::takeOutLoans);
        players.stream().filter(Player::isNotBankrupt).forEach(Player::orderConstruction);
    }

    private void playerIsBankrupt(Player current) {
        System.out.println("Player " + current.name() + " is bankrupt: " + current.cash());
        bankrupted.add(current);
    }

    private List<Player> validPlayers() {
        final List<Player> players = new ArrayList<>(this.players);
        players.removeAll(bankrupted);
        return players;
    }

    public boolean canStartNew() {
        return !validPlayers().isEmpty();
    }
}
