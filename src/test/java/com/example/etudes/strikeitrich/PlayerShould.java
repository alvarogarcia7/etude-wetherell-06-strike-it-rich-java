package com.example.etudes.strikeitrich;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PlayerShould {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MANY = 3;
    private static final int ANY = 0;


    public static class Pay_for_each_RawMaterialUnit {

        @Test
        public void when_zero_units() throws Exception {
            Player player = new Player(ANY, ZERO, ANY, 10_000);

            player.payFixedExpenses();

            assertThat(player, is(new Player(ANY, ZERO, ANY, 10_000)));
        }


        @Test
        public void when_one_unit() throws Exception {
            Player player = new Player(ANY, ONE, ANY, 10_000);

            player.payFixedExpenses();

            assertThat(player, is(new Player(ANY, ONE, ANY, 10_000 - ONE * 300)));
        }
    }
}