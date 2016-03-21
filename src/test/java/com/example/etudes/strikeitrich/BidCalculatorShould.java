package com.example.etudes.strikeitrich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BidCalculatorShould {

    @Mock
    private Player player;

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

    private void distributeBids(Bid... bids) {
        new BidCalculator(3, 3_000, Arrays.asList(bids)).distribute();
    }


}
