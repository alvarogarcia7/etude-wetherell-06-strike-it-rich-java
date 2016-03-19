package com.example.etudes.strikeitrich;

import java.util.List;

public class Turns {
    private final List<Player> players;

    Turns(List<Player> players) {
        this.players = players;
    }

    public void newTurn() {
        players.forEach(Player::payFixedExpenses);
    }
}
