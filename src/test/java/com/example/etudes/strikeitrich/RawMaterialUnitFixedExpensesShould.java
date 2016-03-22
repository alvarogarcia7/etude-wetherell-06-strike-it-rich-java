package com.example.etudes.strikeitrich;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RawMaterialUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;

    @Override
    protected int priceUnit() {
        return 300;
    }

    @Override
    protected Player playerWith(int units, int cash) {
        return new Player(ANY, units, ANY, cash);
    }

}
