package com.example.etudes.strikeitrich;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BidCalculatorShould {

    @Mock
    private Player player;
    private Bid bid;

    @Before
    public void setUp() throws Exception {
        bid = new Bid(3, 3_000, player);
    }


    @Test
    public void accept_the_bid_that_is_over_the_minimum() throws Exception {
        List<Bid> bids = Arrays.asList(bid);

        new BidCalculator(3, 3_000, bids).distribute();

        verify(player).acceptBid();
    }

    @Test
    public void do_not_accept_bid_below_the_minimum() throws Exception {
        List<Bid> bids = Arrays.asList(new Bid(1, 2_000, player));

        new BidCalculator(3, 3_000, bids).distribute();

        verify(player, times(0)).acceptBid();
    }


    @Test
    public void do_not_accept_bid_with_zero_or_negative_requested_units() throws Exception {
        List<Bid> bids = Arrays.asList(
                new Bid(0, 4_000, player),
                new Bid(-1, 4_000, player));

        new BidCalculator(3, 3_000, bids).distribute();

        verify(player, times(0)).acceptBid();
    }


}
