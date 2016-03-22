package com.example.etudes.strikeitrich;

import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FinishedInventoryUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;

    @Override
    protected int priceUnit() {
        return EACH_UNIT_PRICE;
    }

    private static final int EACH_UNIT_PRICE = 500;

    @Override
    protected Player playerWith(int numberOfUnits, int cash) {
        return new Player(ANY, ANY, numberOfUnits, cash);
    }

}

