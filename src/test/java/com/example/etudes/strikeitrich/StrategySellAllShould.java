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
    public Condition decreaseFinishedInventoryUnitsCondition = new Condition((Player p) -> {
        p.decreaseFinishedInventoryUnits(1);
        return null;
    });

    @Test
    public void exchange_all_inventory_items_for_money_when_there_are_several () {
        Player player = new Player(0, 0, 2, 0, 0, SELL_ALL);
        player.finishedInventoryUnits(decreaseFinishedInventoryUnitsCondition);

        player.sellInventory();

        verify(decreaseFinishedInventoryUnitsCondition, times(2)).apply(player);
    }

    @Test
    public void exchange_all_inventory_items_for_money_when_there_is_one () {
        Player player = new Player(0, 0, 1, 0, 0, SELL_ALL);
        player.finishedInventoryUnits(decreaseFinishedInventoryUnitsCondition);

        player.sellInventory();

        verify(decreaseFinishedInventoryUnitsCondition, times(1)).apply(player);
    }

    @Test
    public void exchange_all_inventory_items_for_money_when_there_are_none () {
        Player player = new Player(0, 0, 0, 0, 0, SELL_ALL);
        player.finishedInventoryUnits(decreaseFinishedInventoryUnitsCondition);

        player.sellInventory();

        verify(decreaseFinishedInventoryUnitsCondition, times(0)).apply(player);
    }

}
