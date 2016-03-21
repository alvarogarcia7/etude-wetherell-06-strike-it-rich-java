package com.example.etudes.strikeitrich;

class MaterialsCalculator {

    private static final int RAW_MATERIAL_UNIT_PRICE = 300;
    private static final int FINISHED_INVENTORY_UNIT_PRICE = 500;

    static MaterialsCalculator defaultPrices() {
        return new MaterialsCalculator();
    }

    void calculateRawMaterials(int units, Player player) {
        player.pay(RAW_MATERIAL_UNIT_PRICE * units);
    }

    void calculateFinishedInventoryUnits(int units, Player player) {
        player.pay(FINISHED_INVENTORY_UNIT_PRICE * units);
    }
}
