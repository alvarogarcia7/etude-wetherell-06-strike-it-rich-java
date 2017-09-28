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
        System.out.println("[DEAL] Dealing players with initial amounts");
        players.forEach(gameStarter::deal);
        int i = 0;
        while (turns.canStartNew()) {
            System.out.println("[TURN] Starting a new turn: " + ++i);
            turns.newTurn();
        }
    }
}
