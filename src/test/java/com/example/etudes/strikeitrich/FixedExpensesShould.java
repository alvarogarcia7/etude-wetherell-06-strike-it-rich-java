package com.example.etudes.strikeitrich;

import org.junit.Test;

public abstract class FixedExpensesShould {
    static final int INITIAL_CASH = 10_000;
    private static final int ZERO = 0;
    private static final int MANY = 3;

    @Test
    public void when_zero_units() throws Exception {
        assertThatPayingFor(ZERO).reducesTheCash();
    }

    @Test
    public void when_many_units() throws Exception {
        assertThatPayingFor(MANY).reducesTheCash();
    }

    protected abstract PayingStub assertThatPayingFor(int amount);
}
