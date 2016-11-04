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
    private static final int HIGHER_THAN_THE_PRICE = 3_500;
    private static final int ANY_VALID_PRICE = HIGHER_THAN_THE_PRICE;
    private static final int HIGHEST_THAN_THE_PRICE = 4_000;

    @Mock
    private Player player1;
    @Mock
    private Player player2;

    @Before
    public void setUp() {
        checkConstantConfiguration();
    }

    @Test
    public void accept_the_bid_that_is_at_least_the_minimum() throws Exception {

        distributeBids(new Bid(3, EXACT_PRICE, player1));

        acceptBidFor(player1);
    }

    @Test
    public void do_not_accept_bid_below_the_minimum() throws Exception {

        distributeBids(new Bid(1, BELOW_THE_PRICE, player1));

        dontAcceptBidFor(player1);
    }

    @Test
    public void only_accept_bids_with_positive_requested_units() throws Exception {

        distributeBids(new Bid(0, ANY_VALID_PRICE, player1),
                new Bid(-1, ANY_VALID_PRICE, player2));

        dontAcceptBidFor(player1);
        dontAcceptBidFor(player2);
    }

    @Test
    public void distribute_the_available_units_while_they_last() throws Exception {

        distributeBids(new Bid(3, HIGHEST_THAN_THE_PRICE, player1),
                new Bid(3, HIGHER_THAN_THE_PRICE, player2));

        acceptBidFor(player1);
        dontAcceptBidFor(player2);
    }

    @Test
    public void first_units_go_to_highest_bidders() throws Exception {

        distributeBids(new Bid(3, HIGHER_THAN_THE_PRICE, player1),
                new Bid(3, HIGHEST_THAN_THE_PRICE, player2));

        dontAcceptBidFor(player1);
        acceptBidFor(player2);
    }


    private void distributeBids(Bid... bids) {
        final int units = 3;
        new BidCalculator(units, EXACT_PRICE, Arrays.asList(bids)).distribute();
    }

    private void acceptBidFor(Player player) {
        verify(player).acceptBid();
    }

    private void dontAcceptBidFor(Player player) {
        verify(player, times(0)).acceptBid();
    }

    private void checkConstantConfiguration() {
        assertTrue(BELOW_THE_PRICE < EXACT_PRICE);
        assertTrue(EXACT_PRICE < HIGHER_THAN_THE_PRICE);
        assertTrue(HIGHER_THAN_THE_PRICE < HIGHEST_THAN_THE_PRICE);
    }
}
