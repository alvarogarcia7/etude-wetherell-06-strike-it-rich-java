package com.example.etudes.strikeitrich;

import java.util.function.Function;

class Condition {
    private final Function<Player, Void> playerModifier;

    public Condition (final Function<Player, Void> playerModifier) {

        this.playerModifier = playerModifier;
    }

    public void apply (final Player player) {
        playerModifier.apply(player);
    }
}
