package com.example.etudes.strikeitrich;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerShould {

    @Mock
    public MarketCondition anyMarketCondition;

    @Test
    public void cannot_exchange_any_items_without_having_received_a_condition () {
        Player player = new Player(0, 0, 0, 0, 0);

        player.sellInventory();

        verify(anyMarketCondition, times(0)).apply(player);
    }

    @Test
    public void exchange_a_single_inventory_item_for_money () {
        Player player = new Player(0, 0, 0, 0, 0);
        player.finishedInventoryUnits(anyMarketCondition);

        player.sellInventory();

        verify(anyMarketCondition).apply(player);
    }
}
