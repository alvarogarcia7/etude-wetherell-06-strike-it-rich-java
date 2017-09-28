package com.example.etudes.strikeitrich.fixedExpenses;

import com.example.etudes.strikeitrich.FixedExpensesShould;
import com.example.etudes.strikeitrich.MaterialsCalculator;
import com.example.etudes.strikeitrich.Player;

public class RawMaterialUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;
    private static final int PRICE_PER_UNIT = 300;

    @Override
    protected MaterialsCalculator getCalculator() {
        return MaterialsCalculator.defaultPricesAnd().rawMaterialCosts(PRICE_PER_UNIT).build();
    }

    @Override
    protected int priceUnit() {
        return PRICE_PER_UNIT;
    }

    @Override
    protected Player playerWith(int units, int cash) {
        return new Player(ANY, units, ANY, cash, 0);
    }

}
