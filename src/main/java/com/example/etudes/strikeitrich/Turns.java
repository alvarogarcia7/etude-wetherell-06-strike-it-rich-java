package com.example.etudes.strikeitrich;

import java.util.List;

public class Turns {
    private final List<Player> players;
    private final Bank bank;

    Turns(List<Player> players) {
        this(players, new Bank());
    }

    Turns(List<Player> players, Bank bank) {
        this.players = players;
        this.bank = bank;
    }

    public void newTurn() {
        players.forEach(Player::payFixedExpenses);
        players.forEach(x -> x.rawMaterialUnits(bank.rawMaterialUnitConditions()));
    }
}
