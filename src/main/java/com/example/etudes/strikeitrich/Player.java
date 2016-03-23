package com.example.etudes.strikeitrich;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Player {

    private int standardFactories;
    private int rawMaterialUnits;
    private int finishedInventoryUnits;
    private int cash;
    private int automatedFactoryUnits;

    public Player(int standardFactories, int rawMaterialUnits, int finishedInventoryUnits, int cash, int automatedFactoryUnits) {
        this.standardFactories = standardFactories;
        this.rawMaterialUnits = rawMaterialUnits;
        this.finishedInventoryUnits = finishedInventoryUnits;
        this.cash = cash;
        this.automatedFactoryUnits = automatedFactoryUnits;
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


    void payFixedExpenses(MaterialsCalculator calculator) {
        calculator.calculateRawMaterials(rawMaterialUnits, this);
        calculator.calculateFinishedInventoryUnits(finishedInventoryUnits, this);
        calculator.calculateStandardFactories(standardFactories, this);
        calculator.calculateAutomatedFactories(automatedFactoryUnits, this);
    }

    void pay(int amount) {
        cash -= amount;
    }

    void rawMaterialUnits(Condition rawMaterialUnitConditions) {
    }

    void finishedInventoryUnits(Condition condition) {

    }

    Bid obtainRawMaterialUnitBid() {
        return null;
    }

    void acceptBid() {

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("standardFactories", standardFactories)
                .append("rawMaterialUnits", rawMaterialUnits)
                .append("finishedInventoryUnits", finishedInventoryUnits)
                .append("cash", cash)
                .toString();
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
                .append(automatedFactoryUnits, player.automatedFactoryUnits)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(standardFactories)
                .append(rawMaterialUnits)
                .append(finishedInventoryUnits)
                .append(cash)
                .append(automatedFactoryUnits)
                .toHashCode();
    }
}
