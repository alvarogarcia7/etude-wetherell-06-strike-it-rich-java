package com.example.etudes.strikeitrich;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RawMaterialUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;

    private static final int EACH_UNIT_PRICE = 300;

    @Override
    protected int priceUnit() {
        return EACH_UNIT_PRICE;
    }

    @Override
    protected Player playerWith(int units, int cash) {
        return new Player(ANY, units, ANY, cash);
    }

}
