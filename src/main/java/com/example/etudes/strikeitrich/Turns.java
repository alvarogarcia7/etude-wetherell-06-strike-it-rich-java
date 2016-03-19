package com.example.etudes.strikeitrich;

import java.util.List;
import java.util.stream.Collectors;

public class Turns {
    private final List<Player> players;
    private final Bank bank;

    static Turns aNew(List<Player> players, Bank bank) {
        return new Turns(players, bank);
    }

    private Turns(List<Player> players, Bank bank) {
        this.players = players;
        this.bank = bank;
    }

    public void newTurn() {
        players.forEach(Player::payFixedExpenses);
        players.forEach(x -> x.rawMaterialUnits(bank.rawMaterialUnitConditions()));
        players.forEach(x -> x.finishedInventoryUnits(bank.finishedInventoryUserConditions()));
        players.forEach(Player::obtainBids);
    }
}
