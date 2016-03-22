package com.example.etudes.strikeitrich;

import javafx.util.Builder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MaterialsCalculator {

    private final int standardFactoryPrice;
    private final int rawMaterialUnitPrice;
    private final int finishedInventoryUnitPrice;

    private MaterialsCalculator(Map<CostType, Cost> costs) {
        this.standardFactoryPrice = getOrDefaultOf(CostType.STANDARD_FACTORY, costs);
        this.rawMaterialUnitPrice = getOrDefaultOf(CostType.RAW_MATERIAL, costs);
        this.finishedInventoryUnitPrice = getOrDefaultOf(CostType.FINISHED_UNIT, costs);
    }

    private int getOrDefaultOf(CostType type, Map<CostType, Cost> costs) {
        return costs.getOrDefault(type, type.getCost()).value();
    }

    static MaterialsCalculator defaultPrices() {
        //TODO move to CostType
        Map<CostType, Cost> values = new HashMap<>();
        Arrays.stream(CostType.values()).forEach(x -> values.put(x, x.getCost()));
        return new MaterialsCalculator(values);
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

        private Map<CostType, Cost> values;

        MaterialsCalculatorBuilder() {
            this.values = new HashMap<>();
        }

        @Override
        public MaterialsCalculator build() {
            return new MaterialsCalculator(values);
        }

        MaterialsCalculatorBuilder rawMaterialCosts(int pricePerUnit) {
            values.put(CostType.RAW_MATERIAL, Cost.of(pricePerUnit));
            return this;
        }

        MaterialsCalculatorBuilder finishedInventoryCosts(int pricePerUnit) {
            values.put(CostType.FINISHED_UNIT, Cost.of(pricePerUnit));
            return this;
        }
    }
}
