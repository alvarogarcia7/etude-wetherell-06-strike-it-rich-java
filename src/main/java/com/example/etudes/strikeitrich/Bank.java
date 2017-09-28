package com.example.etudes.strikeitrich;

public class Bank {
    public MarketCondition rawMaterialUnitConditions() {
        return null;
    }

    public MarketCondition finishedInventoryUserConditions() {
        // TODO AGB dummy data
        return new MarketCondition(p->{
            p.finishedInventoryUnits();
            return null;
        }, new PriceLevel(1,2,1,1));
    }
}
