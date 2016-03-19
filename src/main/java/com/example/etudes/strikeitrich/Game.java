package com.example.etudes.strikeitrich;

public class Game {
    private final Player player1;

    public Game(Player player1) {
        this.player1 = player1;
    }

    public void start() {
        player1.receiveStandardFactories(2);
        player1.receiveRawMaterials(4);
        player1.receiveFinishedInventoryUnits(2);
        player1.receiveCash(10_000);
    }
}
