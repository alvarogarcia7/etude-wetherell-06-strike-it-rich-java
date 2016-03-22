package com.example.etudes.strikeitrich;

enum CostType {

    FINISHED_UNIT(Cost.of(0)),
    RAW_MATERIAL(Cost.of(500)),
    STANDARD_FACTORY(Cost.of(300));

    private final Cost cost;

    CostType(Cost cost) {
        this.cost = cost;
    }

    public Cost getCost() {
        return cost;
    }
}
