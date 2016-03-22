package com.example.etudes.strikeitrich;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FinishedInventoryUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;

    @Override
    protected int priceUnit() {
        return 500;
    }

    @Override
    protected Player playerWith(int numberOfUnits, int cash) {
        return new Player(ANY, ANY, numberOfUnits, cash);
    }

}

