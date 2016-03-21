package com.example.etudes.strikeitrich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BidCalculatorShould {

    @Mock
    private Player player;
    @Mock
    private Player player2;

    @Test
    public void accept_the_bid_that_is_over_the_minimum() throws Exception {

        distributeBids(new Bid(3, 3_000, player));

        verify(player).acceptBid();
    }

    @Test
    public void do_not_accept_bid_below_the_minimum() throws Exception {

        distributeBids(new Bid(1, 2_000, player));

        verify(player, times(0)).acceptBid();
    }


    @Test
    public void only_accept_bids_with_positive_requested_units() throws Exception {

        distributeBids(new Bid(0, 4_000, player),
                new Bid(-1, 4_000, player));

        verify(player, times(0)).acceptBid();
    }

    @Test
    public void distribute_the_available_units_in_order() throws Exception {

        distributeBids(new Bid(3, 4_000, player),
                new Bid(3, 3_500, player2));

        verify(player).acceptBid();
        verify(player2, times(0)).acceptBid();
    }

    private void distributeBids(Bid... bids) {
        new BidCalculator(3, 3_000, Arrays.asList(bids)).distribute();
    }


}
