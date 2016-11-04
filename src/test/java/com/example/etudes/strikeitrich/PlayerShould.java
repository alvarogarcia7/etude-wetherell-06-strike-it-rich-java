package com.example.etudes.strikeitrich;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class PlayerShould {

    @Mock
    public Condition condition;
    final Condition condition1FIU_Equals_300Cash = new Condition(
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

        assertThat(player, is(new Player(0, 0, 0, 300, 0)));
    }

    @Test
    public void exchange_all_inventory_items_for_money () {
        Player player = new Player(0, 0, 2, 0, 0, Strategy.SELL_ALL);

        player.finishedInventoryUnits(condition1FIU_Equals_300Cash);

        player.sellInventory();

        assertThat(player, is(new Player(0, 0, 0, 600, 0)));
    }

    @Test
    public void cannot_exchange_any_items_without_having_received_a_condition() {
        Player player = new Player(0, 0, 2, 0, 0, Strategy.SELL_ALL);

        player.sellInventory();

        assertThat(player, is(player));
    }

}
