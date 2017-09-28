package com.example.etudes.strikeitrich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.etudes.strikeitrich.Strategy.SELL_ALL;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class StrategySellAllShould {
    @Spy
    public MarketCondition decreaseFinishedInventoryUnitsMarketCondition = new MarketCondition((Player p) -> {
        p.decreaseFinishedInventoryUnits(1);
        return null;
    }, new PriceLevel(1, 800, 3, 6500));

    @Test
    public void exchange_all_inventory_items_for_money_when_there_are_none () {
        verifyInteractionBasedOnFinishedInventoryUnits(0);
    }

    @Test
    public void exchange_all_inventory_items_for_money_when_there_is_one () {
        verifyInteractionBasedOnFinishedInventoryUnits(1);
    }

    @Test
    public void exchange_all_inventory_items_for_money_when_there_are_several () {
        verifyInteractionBasedOnFinishedInventoryUnits(2);
    }

    private void verifyInteractionBasedOnFinishedInventoryUnits (final int finishedInventoryUnits) {
        Player player = new Player(0, 0, finishedInventoryUnits, 0, 0, SELL_ALL, "none");
        player.finishedInventoryUnits(decreaseFinishedInventoryUnitsMarketCondition);

        player.sellInventory();

        verify(decreaseFinishedInventoryUnitsMarketCondition, times(finishedInventoryUnits)).apply(player);
    }

}
