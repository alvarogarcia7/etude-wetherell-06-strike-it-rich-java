package com.example.etudes.strikeitrich;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerShould {

    @Mock
    public Condition anyCondition;

    @Spy
    public Condition decreaseFinishedInventoryUnitsCondition = new Condition((Player p) -> {
        p.decreaseFinishedInventoryUnits(1);
        return null;
    });

    @Test
    public void cannot_exchange_any_items_without_having_received_a_condition() {
        Player player = new Player(0, 0, 2, 0, 0);

        player.sellInventory();

        verify(anyCondition, times(0)).apply(player);
    }

    @Test
    public void exchange_a_single_inventory_item_for_money () {
        Player player = new Player(0, 0, 1, 0, 0);
        player.finishedInventoryUnits(anyCondition);

        player.sellInventory();

        verify(anyCondition).apply(player);
    }

    @Test
    public void exchange_all_inventory_items_for_money () {
        Player player = new Player(0, 0, 2, 0, 0, Strategy.SELL_ALL);
        player.finishedInventoryUnits(decreaseFinishedInventoryUnitsCondition);

        player.sellInventory();

        verify(decreaseFinishedInventoryUnitsCondition, times(2)).apply(player);
    }

}
