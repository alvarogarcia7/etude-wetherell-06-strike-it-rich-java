package com.example.etudes.strikeitrich;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Optional;

import static com.example.etudes.strikeitrich.Strategy.SELL_ONE;

public class Player {

    private int standardFactories;
    private int rawMaterialUnits;
    private int finishedInventoryUnits;
    private int cash;
    private int automatedFactoryUnits;
    private final Strategy strategy;
    private Optional<MarketCondition> finishedInventoryUnitsCondition;

    public Player (
        int standardFactories,
        int rawMaterialUnits,
        int finishedInventoryUnits,
        int cash,
        int automatedFactoryUnits) {
        this(standardFactories, rawMaterialUnits, finishedInventoryUnits, cash, automatedFactoryUnits, SELL_ONE);
    }

    public Player (
            int standardFactories,
            int rawMaterialUnits,
            int finishedInventoryUnits,
            int cash,
            int automatedFactoryUnits,
            Strategy strategy) {

        this.standardFactories = standardFactories;
        this.rawMaterialUnits = rawMaterialUnits;
        this.finishedInventoryUnits = finishedInventoryUnits;
        this.cash = cash;
        this.automatedFactoryUnits = automatedFactoryUnits;
        this.strategy = strategy;
        this.finishedInventoryUnitsCondition = Optional.empty();
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

    void rawMaterialUnits(MarketCondition rawMaterialUnitConditions) {

    }

    void finishedInventoryUnits(MarketCondition marketCondition) {
        this.finishedInventoryUnitsCondition = Optional.of(marketCondition);
    }

    Bid obtainRawMaterialUnitBid() {
        return null;
    }

    void acceptBid() {

    }

    void sellInventory() {
        finishedInventoryUnitsCondition.ifPresent((MarketCondition marketCondition) -> strategy.applyFinishedInventoryUnits(this, marketCondition));
    }

    void payLoanInterest() {
    }

    void payOutstandingLoans() {
    }

    void takeOutLoans() {
    }

    public void produceStock() throws BankruptException {

    }

    public void orderConstruction() {
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

    public void decreaseFinishedInventoryUnits (final int amount) {
        this.finishedInventoryUnits -= amount;
    }

    public int finishedInventoryUnits () {
        return finishedInventoryUnits;
    }
}
