package com.example.etudes.strikeitrich;

import java.util.List;

public class Turns {
    private final List<Player> players;
    private final Bank bank;
    private final MaterialsCalculator calculator;

    static Turns aNew(List<Player> players, Bank bank, MaterialsCalculator calculator) {
        return new Turns(players, bank, calculator);
    }

    private Turns(List<Player> players, Bank bank, MaterialsCalculator calculator) {
        this.players = players;
        this.bank = bank;
        this.calculator = calculator;
    }

    public void newTurn() {
        players.forEach(x -> x.payFixedExpenses(calculator));
        players.forEach(x -> x.rawMaterialUnits(bank.rawMaterialUnitConditions()));
        players.forEach(x -> x.finishedInventoryUnits(bank.finishedInventoryUserConditions()));
        players.forEach(Player::obtainRawMaterialUnitBid);
        players.forEach(Player::produceStock);
        players.forEach(Player::sellInventory);
        players.forEach(Player::payLoanInterest);
        players.forEach(Player::payOutstandingLoans);
    }
}
