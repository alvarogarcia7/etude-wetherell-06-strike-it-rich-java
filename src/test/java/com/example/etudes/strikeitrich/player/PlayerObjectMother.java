package com.example.etudes.strikeitrich.player;

import com.example.etudes.strikeitrich.Player;
import com.example.etudes.strikeitrich.Strategy;

import java.util.function.IntUnaryOperator;

public class PlayerObjectMother {
    public static Player sample () {
        return null;
    }

    public static Player emptyWithCash(int cash) {
        return new Player(0, 0, 0, cash, 0, Strategy.SELL_ONE, "none");
    }
}
