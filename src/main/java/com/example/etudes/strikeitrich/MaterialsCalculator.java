package com.example.etudes.strikeitrich;

import javafx.util.Builder;

import java.util.HashMap;
import java.util.Map;

class MaterialsCalculator {

    private static final int RAW_MATERIAL_UNIT_PRICE = 300;
    private static final int FINISHED_INVENTORY_UNIT_PRICE = 500;

    private final int standardFactoryPrice;
    private final int rawMaterialUnitPrice;
    private final int finishedInventoryUnitPrice;

    private MaterialsCalculator(int standardFactoryPrice, int rawMaterialUnitPrice, int finishedInventoryUnitPrice) {
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

    static MaterialsCalculatorBuilder defaultPricesAnd() {
        return new MaterialsCalculatorBuilder();
    }

    static class MaterialsCalculatorBuilder implements Builder<MaterialsCalculator> {

        private static final String RAW_MATERIAL_COSTS = "RAW_MATERIAL_COSTS";
        static final String FINISHED_INVENTORY_COSTS = "FINISHED_INVENTORY_COSTS";
        private Map<String, Integer> values;

        MaterialsCalculatorBuilder() {
            this.values = new HashMap<>();
        }

        @Override
        public MaterialsCalculator build() {
            return new MaterialsCalculator(0, values.getOrDefault(RAW_MATERIAL_COSTS, 0), values.getOrDefault(FINISHED_INVENTORY_COSTS, 0));
        }

        MaterialsCalculatorBuilder rawMaterialCosts(int pricePerUnit) {
            values.put(RAW_MATERIAL_COSTS, pricePerUnit);
            return this;
        }

        MaterialsCalculatorBuilder finishedInventoryCosts(int pricePerUnit) {
            values.put(FINISHED_INVENTORY_COSTS, pricePerUnit);
            return this;
        }
    }
}
