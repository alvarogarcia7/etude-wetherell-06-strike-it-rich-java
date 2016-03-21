package com.example.etudes.strikeitrich;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BidCalculatorShould {

    private static final int BELOW_THE_PRICE = 2_000;
    private static final int EXACT_PRICE = 3_000;
    private static final int HIGHEST_THAN_THE_PRICE = 4_000;
    private static final int HIGHER_THAN_THE_PRICE = 3_500;

    @Mock
    private Player player;
    @Mock
    private Player player2;

    @Before
    public void setUp() {
        checkConstantConfiguration();
    }

    @Test
    public void accept_the_bid_that_is_at_least_the_minimum() throws Exception {

        distributeBids(new Bid(3, EXACT_PRICE, player));

        verify(player).acceptBid();
    }

    @Test
    public void do_not_accept_bid_below_the_minimum() throws Exception {

        distributeBids(new Bid(1, BELOW_THE_PRICE, player));

        verify(player, times(0)).acceptBid();
    }

    @Test
    public void only_accept_bids_with_positive_requested_units() throws Exception {

        distributeBids(new Bid(0, HIGHEST_THAN_THE_PRICE, player),
                new Bid(-1, HIGHEST_THAN_THE_PRICE, player));

        verify(player, times(0)).acceptBid();
    }


    @Test
    public void distribute_the_available_units_while_they_last() throws Exception {

        distributeBids(new Bid(3, HIGHEST_THAN_THE_PRICE, player),
                new Bid(3, HIGHER_THAN_THE_PRICE, player2));

        verify(player).acceptBid();
        verify(player2, times(0)).acceptBid();
    }

    private void distributeBids(Bid... bids) {
        new BidCalculator(3, EXACT_PRICE, Arrays.asList(bids)).distribute();
    }

    private void checkConstantConfiguration() {
        assertTrue(BELOW_THE_PRICE < EXACT_PRICE);
        assertTrue(EXACT_PRICE < HIGHER_THAN_THE_PRICE);
        assertTrue(HIGHER_THAN_THE_PRICE < HIGHEST_THAN_THE_PRICE);
    }


}
