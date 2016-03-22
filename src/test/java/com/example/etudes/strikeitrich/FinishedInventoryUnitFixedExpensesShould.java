package com.example.etudes.strikeitrich;

import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FinishedInventoryUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;
    private static MaterialsCalculator calculator;

    @Before
    public void setUp() {
        calculator = MaterialsCalculator.defaultPrices();
    }

    private static final int EACH_UNIT_PRICE = 500;

    @Override
    protected PayingStub assertThatPayingFor(int numberOfUnits) {
        Player player = new Player(ANY, ANY, numberOfUnits, INITIAL_CASH);

        player.payFixedExpenses(calculator);

        assertThat(player, is(new Player(ANY, ANY, numberOfUnits, INITIAL_CASH - numberOfUnits * EACH_UNIT_PRICE)));

        return new PayingStub();
    }

}

