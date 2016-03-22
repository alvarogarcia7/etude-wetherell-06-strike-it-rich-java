package com.example.etudes.strikeitrich;

class Cost {
    private final int cost;

    static Cost of(int cost) {
        return new Cost(cost);
    }

    private Cost(int cost) {
        this.cost = cost;
    }

    int value() {
        return cost;
    }
}
