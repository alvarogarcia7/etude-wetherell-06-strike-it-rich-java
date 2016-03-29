package com.example.etudes.strikeitrich;

import java.util.List;

public class Game {
    private final GameStarter gameStarter;
    private List<Player> players;
    private final Turns turns;
    private final Players players1;

    public Game(GameStarter gameStarter, Turns turns, List<Player> players, Players players1) {
        this.gameStarter = gameStarter;
        this.turns = turns;
        this.players = players;
        this.players1 = players1;
    }

    public void start() {
        players.forEach(gameStarter::deal);
        if (players1.isSomeoneStanding()){
            turns.newTurn();
        }
        if (players1.isSomeoneStanding()) {
            turns.newTurn();
        }
    }
}
