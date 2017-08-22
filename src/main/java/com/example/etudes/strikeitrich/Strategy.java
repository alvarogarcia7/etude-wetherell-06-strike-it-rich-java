package com.example.etudes.strikeitrich;

public abstract class Strategy {
    public static Strategy SELL_ONE = new SellOneStrategy();
    public static Strategy SELL_ALL = new SellAllStrategy();

    public abstract void applyFinishedInventoryUnits (final Player player, final MarketCondition marketCondition);

    private static class SellOneStrategy extends Strategy {
        @Override
        public void applyFinishedInventoryUnits (final Player player, final MarketCondition marketCondition) {
            marketCondition.apply(player);
        }
    }

    private static class SellAllStrategy extends Strategy {
        @Override
        public void applyFinishedInventoryUnits (final Player player, final MarketCondition marketCondition) {
            while (player.finishedInventoryUnits() > 0) {
                marketCondition.apply(player);
            }
        }

    }
}
