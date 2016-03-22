package com.example.etudes.strikeitrich;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FinishedInventoryUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;
    private static final int PRICE_PER_UNIT = 500;

    @Override
    protected MaterialsCalculator getCalculator() {
        final int standardFactoryPrice = 0;
        final int rawMaterialPrice = 0;
        final int finishedInventoryUnitPrice = PRICE_PER_UNIT;
        return new MaterialsCalculator(standardFactoryPrice, rawMaterialPrice, finishedInventoryUnitPrice);
    }

    @Override
    protected int priceUnit() {
        return PRICE_PER_UNIT;
    }

    @Override
    protected Player playerWith(int numberOfUnits, int cash) {
        return new Player(ANY, ANY, numberOfUnits, cash);
    }

}

