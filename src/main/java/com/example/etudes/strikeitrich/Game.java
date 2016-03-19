package com.example.etudes.strikeitrich;

import java.util.List;

public class Game {
    private final GameStarter gameStarter;
    private final List<Player> players;

    public Game(GameStarter gameStarter, List<Player> players) {
        this.gameStarter = gameStarter;
        this.players = players;
    }

    public void start() {
        players.forEach(gameStarter::deal);
    }
}
