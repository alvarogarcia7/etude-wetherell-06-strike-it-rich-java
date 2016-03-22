package com.example.etudes.strikeitrich;

import javafx.util.Builder;

import java.util.Map;

import static com.example.etudes.strikeitrich.CostType.*;

class MaterialsCalculator {

    private final int standardFactoryPrice;
    private final int rawMaterialUnitPrice;
    private final int finishedInventoryUnitPrice;

    private MaterialsCalculator(Map<CostType, Cost> costs) {
        this.standardFactoryPrice = getOrDefaultOf(STANDARD_FACTORY, costs);
        this.rawMaterialUnitPrice = getOrDefaultOf(RAW_MATERIAL, costs);
        this.finishedInventoryUnitPrice = getOrDefaultOf(FINISHED_UNIT, costs);
    }

    private int getOrDefaultOf(CostType type, Map<CostType, Cost> costs) {
        return costs.getOrDefault(type, type.getCost()).value();
    }

    static MaterialsCalculator defaultPrices() {
        return new MaterialsCalculator(defaultValues());
    }

    void calculateRawMaterials(int units, Player player) {
        player.pay(rawMaterialUnitPrice * units);
    }

    void calculateFinishedInventoryUnits(int units, Player player) {
        player.pay(finishedInventoryUnitPrice * units);
    }

    static MaterialsCalculatorBuilder defaultPricesAnd() {
        return new MaterialsCalculatorBuilder(CostType.defaultValues());
    }

    void calculateStandardFactories(int units, Player player) {
        player.pay(units * standardFactoryPrice);
    }

    static class MaterialsCalculatorBuilder implements Builder<MaterialsCalculator> {

        private Map<CostType, Cost> values;

        MaterialsCalculatorBuilder(Map<CostType, Cost> costTypeCostMap) {
            this.values = costTypeCostMap;
        }

        @Override
        public MaterialsCalculator build() {
            return new MaterialsCalculator(values);
        }

        MaterialsCalculatorBuilder rawMaterialCosts(int pricePerUnit) {
            values.put(RAW_MATERIAL, Cost.of(pricePerUnit));
            return this;
        }

        MaterialsCalculatorBuilder finishedInventoryCosts(int pricePerUnit) {
            values.put(FINISHED_UNIT, Cost.of(pricePerUnit));
            return this;
        }

        MaterialsCalculatorBuilder standardFactoryCosts(int pricePerUnit) {
            values.put(STANDARD_FACTORY, Cost.of(pricePerUnit));
            return this;
        }
    }
}
