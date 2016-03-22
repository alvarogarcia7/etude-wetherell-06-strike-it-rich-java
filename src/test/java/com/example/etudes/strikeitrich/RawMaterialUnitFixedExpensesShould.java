package com.example.etudes.strikeitrich;

public class RawMaterialUnitFixedExpensesShould extends FixedExpensesShould {

    private static final int ANY = 0;
    private static final int PRICE_PER_UNIT = 300;

    @Override
    protected MaterialsCalculator getCalculator() {
        int finishedInventoryUnits = ANY;
        int rawMaterialUnits = PRICE_PER_UNIT;
        int standardFactories = ANY;
        return new MaterialsCalculator(standardFactories, rawMaterialUnits, finishedInventoryUnits);
    }

    @Override
    protected int priceUnit() {
        return PRICE_PER_UNIT;
    }

    @Override
    protected Player playerWith(int units, int cash) {
        return new Player(ANY, units, ANY, cash);
    }

}
