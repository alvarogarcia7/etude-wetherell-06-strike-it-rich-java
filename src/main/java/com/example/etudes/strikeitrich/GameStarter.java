package com.example.etudes.strikeitrich;

public class GameStarter {
    public void deal(Player player1) {
        player1.receiveStandardFactories(2);
        player1.receiveRawMaterials(4);
        player1.receiveFinishedInventoryUnits(2);
        player1.receiveCash(10_000);
    }
}
