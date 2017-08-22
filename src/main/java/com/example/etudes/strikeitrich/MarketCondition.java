package com.example.etudes.strikeitrich;

import java.util.function.Function;

class MarketCondition {
    private final Function<Player, Void> playerModifier;
    private final PriceLevel priceLevel;

    public MarketCondition (final Function<Player, Void> playerModifier, final PriceLevel priceLevel) {
        this.playerModifier = playerModifier;
        this.priceLevel = priceLevel;
    }

    public void apply (final Player player) {
        playerModifier.apply(player);
    }

    public PriceLevel priceLevel () {
        return priceLevel;
    }
}
