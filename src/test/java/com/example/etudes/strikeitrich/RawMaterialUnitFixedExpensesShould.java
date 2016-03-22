package com.example.etudes.strikeitrich;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RawMaterialUnitFixedExpensesShould extends FixedExpensesShould {

    private static MaterialsCalculator calculator;

    @Before
    public void setUp() {
        calculator = MaterialsCalculator.defaultPrices();
    }

    private static final int EACH_UNIT_PRICE = 300;
    private static final int INITIAL_CASH = 10_000;

    @Override
    protected PayingStub assertThatPayingFor(int numberOfUnits) {
        Player player = buildSut(numberOfUnits, INITIAL_CASH);

        player.payFixedExpenses(calculator);

        assertThat(player, is(buildSutMinusUnits(numberOfUnits, INITIAL_CASH)));

        return new PayingStub();
    }

    private Player buildSutMinusUnits(int numberOfUnits, int cash) {
        return buildSut(numberOfUnits, cash - EACH_UNIT_PRICE * numberOfUnits);
    }

    private Player buildSut(int numberOfUnits, int initialCash) {
        return new Player(0, numberOfUnits, 0, initialCash);
    }
}
