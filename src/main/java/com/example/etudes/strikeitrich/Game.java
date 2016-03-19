package com.example.etudes.strikeitrich;

import java.util.Arrays;
import java.util.List;

public class Game {
    private final Player player1;
    private final GameStarter gameStarter;

    public Game(Player player1) {
        this(new GameStarter(), Arrays.asList(player1));
    }

    public Game(GameStarter gameStarter, List<Player> players) {
        this.player1 = players.get(0);
        this.gameStarter = gameStarter;
    }

    public void start() {
        gameStarter.deal(player1);
    }
}
