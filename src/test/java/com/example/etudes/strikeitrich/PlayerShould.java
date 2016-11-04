package com.example.etudes.strikeitrich;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerShould {

    @Spy
    public Condition condition1FIU_Equals_300Cash = new Condition(
            (Player p) ->
            {
                p.decreaseFinishedInventoryUnits(1);
                p.receiveCash(300);
                return null;
            }
    );



    @Test
    public void exchange_a_single_inventory_item_for_money () {
        Player player = new Player(0, 0, 1, 0, 0);

        player.finishedInventoryUnits(condition1FIU_Equals_300Cash);

        player.sellInventory();

        verify(condition1FIU_Equals_300Cash).apply(player);
        assertThat(player, is(new Player(0, 0, 0, 300, 0)));
    }

    @Test
    public void exchange_all_inventory_items_for_money () {
        Player player = new Player(0, 0, 2, 0, 0, Strategy.SELL_ALL);

        player.finishedInventoryUnits(condition1FIU_Equals_300Cash);

        player.sellInventory();

        verify(condition1FIU_Equals_300Cash, times(2)).apply(player);
        assertThat(player, is(new Player(0, 0, 0, 600, 0)));
    }

    @Test
    public void cannot_exchange_any_items_without_having_received_a_condition() {
        Player player = new Player(0, 0, 2, 0, 0, Strategy.SELL_ALL);

        player.sellInventory();

        verify(condition1FIU_Equals_300Cash, times(0)).apply(player);
        assertThat(player, is(player));
    }

}
