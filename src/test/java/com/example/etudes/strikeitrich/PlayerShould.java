package com.example.etudes.strikeitrich;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MANY = 3;
    private static final int ANY = 0;


    public static class Pay_for_each_RawMaterialUnit {

        private static final int EACH_UNIT_PRICE = 300;
        private static final int INITIAL_CASH = 10_000;

        @Test
        public void when_zero_units() throws Exception {
            assertThatPayingFor(ZERO).reducesTheCash();
        }

        @Test
        public void when_one_unit() throws Exception {
            assertThatPayingFor(ONE).reducesTheCash();
        }

        @Test
        public void when_many_units() throws Exception {
            assertThatPayingFor(MANY).reducesTheCash();
        }

        private PayingStub assertThatPayingFor(int numberOfUnits) {
            Player player = new Player(ANY, numberOfUnits, ANY, INITIAL_CASH);

            player.payFixedExpenses(MaterialsCalculator.defaultPrices());

            assertThat(player, is(new Player(ANY, numberOfUnits, ANY, INITIAL_CASH - numberOfUnits * EACH_UNIT_PRICE)));

            return new PayingStub();
        }
    }


    public static class Pay_for_each_FinishedInventoryUnit {

        private static final int EACH_UNIT_PRICE = 500;
        private static final int INITIAL_CASH = 10_000;

        @Test
        public void when_zero_units() throws Exception {
            assertThatPayingFor(ZERO).reducesTheCash();
        }

        @Test
        public void when_one_unit() throws Exception {
            assertThatPayingFor(ONE).reducesTheCash();
        }

        @Test
        public void when_many_units() throws Exception {
            assertThatPayingFor(MANY).reducesTheCash();
        }

        private PayingStub assertThatPayingFor(int numberOfUnits) {
            Player player = new Player(ANY, ANY, numberOfUnits, INITIAL_CASH);

            player.payFixedExpenses(MaterialsCalculator.defaultPrices());

            assertThat(player, is(new Player(ANY, ANY, numberOfUnits, INITIAL_CASH - numberOfUnits * EACH_UNIT_PRICE)));

            return new PayingStub();
        }
    }

    private static class PayingStub {
        void reducesTheCash() {
        }
    }
}