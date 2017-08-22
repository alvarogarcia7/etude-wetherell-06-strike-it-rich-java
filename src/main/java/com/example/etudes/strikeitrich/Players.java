package com.example.etudes.strikeitrich;

import java.util.List;

public class Players {
    private final List<Player> values;

    private Players (final List<Player> values) {
        this.values = values;
    }

    public static Players of (final List<Player> values) {
        return new Players(values);
    }
}
