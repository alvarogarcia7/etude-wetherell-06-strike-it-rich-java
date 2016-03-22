package com.example.etudes.strikeitrich;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RawMaterialUnitFixedExpensesShould extends FixedExpensesShould {

    private static MaterialsCalculator calculator;

    private static final int EACH_UNIT_PRICE = 300;
    private static final int INITIAL_CASH = 10_000;

    @Override
    protected int priceUnit() {
        return EACH_UNIT_PRICE;
    }

    @Override
    protected Player playerWith(int units, int cash) {
        return new Player(0, units, 0, cash);
    }

    private Player buildSutMinusUnits(int numberOfUnits, int cash) {
        return new Player(0, numberOfUnits, 0, cash - EACH_UNIT_PRICE * numberOfUnits);
    }

}
