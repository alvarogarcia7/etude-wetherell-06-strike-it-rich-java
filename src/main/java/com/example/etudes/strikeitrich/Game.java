package com.example.etudes.strikeitrich;

import java.util.List;

public class Game {
    private final GameStarter gameStarter;
    private final List<Player> players;
    private final Turns turns;

    public Game(GameStarter gameStarter, Turns turns, List<Player> players) {
        this.gameStarter = gameStarter;
        this.turns = turns;
        this.players = players;
    }

    public void start() {
        players.forEach(gameStarter::deal);
        turns.newTurn();
    }
}
