package com.example.etudes.strikeitrich;

class MaterialsCalculator {

    private static final int RAW_MATERIAL_UNIT_PRICE = 300;
    private static final int FINISHED_INVENTORY_UNIT_PRICE = 500;

    private final int standardFactoryPrice;
    private final int rawMaterialUnitPrice;
    private final int finishedInventoryUnitPrice;

    MaterialsCalculator(int standardFactoryPrice, int rawMaterialUnitPrice, int finishedInventoryUnitPrice) {
        this.standardFactoryPrice = standardFactoryPrice;
        this.rawMaterialUnitPrice = rawMaterialUnitPrice;
        this.finishedInventoryUnitPrice = finishedInventoryUnitPrice;
    }

    static MaterialsCalculator defaultPrices() {
        return new MaterialsCalculator(0, RAW_MATERIAL_UNIT_PRICE, FINISHED_INVENTORY_UNIT_PRICE);
    }

    void calculateRawMaterials(int units, Player player) {
        player.pay(rawMaterialUnitPrice * units);
    }

    void calculateFinishedInventoryUnits(int units, Player player) {
        player.pay(finishedInventoryUnitPrice * units);
    }
}
