package com.example.etudes.strikeitrich;


import com.example.etudes.strikeitrich.player.PlayerObjectMother;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerShould {

    @Mock
    public MarketCondition anyMarketCondition;

    @Test
    public void cannot_exchange_any_items_without_having_received_a_condition () {
        Player player = getEmptyPlayerHavingCash(0);

        player.sellInventory();

        verify(anyMarketCondition, times(0)).apply(player);
    }

    @Test
    public void exchange_a_single_inventory_item_for_money () {
        Player player = getEmptyPlayerHavingCash(0);
        player.finishedInventoryUnits(anyMarketCondition);

        player.sellInventory();

        verify(anyMarketCondition).apply(player);
    }

    @Test(expected = BankruptException.class)
    public void going_to_cash_negative_makes_a_player_bankrupt() {
        final Player player = getEmptyPlayerHavingCash(10);
        
        player.pay(11);
    }

    @Test
    public void not_be_bankrupt_when_has_money() {
        final Player player = getEmptyPlayerHavingCash(10);

        assertThat(player.isNotBankrupt(), is(true));
    }

    @Test
    public void be_bankrupt_when_has_no_money() {
        final Player player = getEmptyPlayerHavingCash(-1);

        assertThat(player.isNotBankrupt(), is(false));
    }

    private Player getEmptyPlayerHavingCash(int cash) {
        return PlayerObjectMother.emptyWithCash(cash);
    }
}
