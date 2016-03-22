package com.example.etudes.strikeitrich;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

enum CostType {

    FINISHED_UNIT(Cost.of(0)),
    RAW_MATERIAL(Cost.of(500)),
    STANDARD_FACTORY(Cost.of(300));

    private final Cost cost;

    CostType(Cost cost) {
        this.cost = cost;
    }

    static Map<CostType, Cost> defaultValues() {
        Map<CostType, Cost> values = new HashMap<>();
        Arrays.stream(values()).forEach(x -> values.put(x, x.getCost()));
        return values;
    }

    public Cost getCost() {
        return cost;
    }
}
