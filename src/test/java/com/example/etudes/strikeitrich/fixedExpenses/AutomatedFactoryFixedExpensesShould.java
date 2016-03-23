package com.example.etudes.strikeitrich.fixedExpenses;

import com.example.etudes.strikeitrich.FixedExpensesShould;
import com.example.etudes.strikeitrich.MaterialsCalculator;
import com.example.etudes.strikeitrich.Player;

public class AutomatedFactoryFixedExpensesShould extends FixedExpensesShould {

    private static final int PRICE_PER_UNIT = 999;
    private static final int ANY = 0;

    @Override
    protected MaterialsCalculator getCalculator() {
        return MaterialsCalculator.defaultPricesAnd().automatedFactoryCosts(PRICE_PER_UNIT).build();
    }

    @Override
    protected int priceUnit() {
        return PRICE_PER_UNIT;
    }

    @Override
    protected Player playerWith(int units, int cash) {
        return new Player(ANY, ANY, ANY, cash, units);
    }
}
