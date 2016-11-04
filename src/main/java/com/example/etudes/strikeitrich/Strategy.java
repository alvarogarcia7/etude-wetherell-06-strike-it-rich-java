package com.example.etudes.strikeitrich;

public abstract class Strategy {
    public static Strategy SELL_ONE = new SellOneStrategy();
    public static Strategy SELL_ALL = new SellAllStrategy();

    public abstract void apply (final Player player, final Condition finishedInventoryUnitsCondition);

    private static class SellOneStrategy extends Strategy {
        @Override
        public void apply (final Player player, final Condition finishedInventoryUnitsCondition) {
            finishedInventoryUnitsCondition.apply(player);
        }
    }

    private static class SellAllStrategy extends Strategy {
        @Override
        public void apply (final Player player, final Condition finishedInventoryUnitsCondition) {
            while (player.finishedInventoryUnits() > 0) {
                finishedInventoryUnitsCondition.apply(player);
            }
        }

    }
}
