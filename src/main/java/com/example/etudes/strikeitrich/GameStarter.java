package com.example.etudes.strikeitrich;

public class GameStarter {
    public void deal(Player player) {
        player.receiveStandardFactories(2);
        player.receiveRawMaterials(4);
        player.receiveFinishedInventoryUnits(2);
        player.receiveCash(10_000);
    }
}
