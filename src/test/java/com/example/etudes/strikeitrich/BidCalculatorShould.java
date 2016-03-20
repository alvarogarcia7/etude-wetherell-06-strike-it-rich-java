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


}
