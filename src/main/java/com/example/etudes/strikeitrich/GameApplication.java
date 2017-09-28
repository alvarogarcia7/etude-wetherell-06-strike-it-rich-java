package com.example.etudes.strikeitrich;

import java.util.Arrays;
import java.util.List;

import static com.example.etudes.strikeitrich.Strategy.SELL_ONE;

public class GameApplication {
    public static void main(String[] args) {
        Player p1 = emptyPlayerWithName("P1");
        Player p2 = emptyPlayerWithName("P2");
        final List<Player> playerList = Arrays.asList(p1, p2);
        Game game = new Game(new GameStarter(), Turns.aNew(playerList, new Bank(), MaterialsCalculator.defaultPrices()), playerList);

        game.start();
    }

    private static Player emptyPlayerWithName(String p1) {
        return new Player(0, 0, 0, 0, 0, SELL_ONE, p1);
    }
}
