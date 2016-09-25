package com.example.etudes.strikeitrich;

import com.example.etudes.strikeitrich.fixedExpenses.PayingStub;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class FixedExpensesShould {

    private static final int INITIAL_CASH = 10_000;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MANY = 3;

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
        Player player = playerWithInitialCashAnd(numberOfUnits);

        player.payFixedExpenses(getCalculator());

        assertThat(player, is(playerWithReducedCashAnd(numberOfUnits)));

        return new PayingStub();
    }

    private Player playerWithInitialCashAnd(int numberOfUnits) {
        return playerWith(numberOfUnits, INITIAL_CASH);
    }

    private Player playerWithReducedCashAnd(int numberOfUnits) {
        return playerWith(numberOfUnits, reducedCashBy(numberOfUnits));
    }

    private int reducedCashBy(int numberOfUnits) {
        return INITIAL_CASH - numberOfUnits * priceUnit();
    }

    protected abstract MaterialsCalculator getCalculator();

    protected abstract int priceUnit();

    protected abstract Player playerWith(int units, int cash);
}
