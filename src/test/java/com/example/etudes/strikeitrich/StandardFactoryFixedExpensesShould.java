package com.example.etudes.strikeitrich;

public class StandardFactoryFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;
    private static final int PRICE_PER_UNIT = 100;

    @Override
    protected MaterialsCalculator getCalculator() {
        return MaterialsCalculator.defaultPricesAnd().standardFactoryCosts(PRICE_PER_UNIT).build();
    }

    @Override
    protected int priceUnit() {
        return PRICE_PER_UNIT;
    }

    @Override
    protected Player playerWith(int numberOfUnits, int cash) {
        return new Player(numberOfUnits, ANY, ANY, cash);
    }

}

