package com.example.etudes.strikeitrich;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Player {

    private int standardFactories;
    private int rawMaterialUnits;
    private int finishedInventoryUnits;
    private int cash;

    Player(int standardFactories, int rawMaterialUnits, int finishedInventoryUnits, int cash) {
        this.standardFactories = standardFactories;
        this.rawMaterialUnits = rawMaterialUnits;
        this.finishedInventoryUnits = finishedInventoryUnits;
        this.cash = cash;
    }

    void receiveStandardFactories(int amount) {
        this.standardFactories += amount;
    }

    void receiveRawMaterials(int amount) {
        this.rawMaterialUnits += amount;
    }

    void receiveFinishedInventoryUnits(int amount) {
        finishedInventoryUnits += amount;
    }

    void receiveCash(int amount) {
        cash += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return new EqualsBuilder()
                .append(standardFactories, player.standardFactories)
                .append(rawMaterialUnits, player.rawMaterialUnits)
                .append(finishedInventoryUnits, player.finishedInventoryUnits)
                .append(cash, player.cash)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(standardFactories)
                .append(rawMaterialUnits)
                .append(finishedInventoryUnits)
                .append(cash)
                .toHashCode();
    }

    void payFixedExpenses() {

    }

    void rawMaterialUnits(Condition rawMaterialUnitConditions) {
    }

    void finishedInventoryUnits(Condition condition) {

    }
}
