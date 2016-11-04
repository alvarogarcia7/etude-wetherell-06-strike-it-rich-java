package com.example.etudes.strikeitrich;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayerShould {

    @Test
    public void exchange_a_single_inventory_item_for_money () {
        Player player = new Player(0, 0, 1, 0, 0);

        player.finishedInventoryUnits(new Condition(
                (Player p) ->
                {
                    p.decreaseFinishedInventoryUnits(1);
                    p.receiveCash(300);
                    return null;
                }
        ));

        player.sellInventory();

        assertThat(player, is(new Player(0, 0, 0, 300, 0)));
    }

    @Test
    public void exchange_all_inventory_items_for_money () {
        Player player = new Player(0, 0, 2, 0, 0, Strategy.SELL_ALL);

        player.finishedInventoryUnits(new Condition(
                (Player p) ->
                {
                    p.decreaseFinishedInventoryUnits(1);
                    p.receiveCash(300);
                    return null;
                }
        ));

        player.sellInventory();

        assertThat(player, is(new Player(0, 0, 0, 600, 0)));
    }

}
