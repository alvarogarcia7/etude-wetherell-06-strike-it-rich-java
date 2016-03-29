package com.example.etudes.strikeitrich;

import java.util.List;

public class Turns {
    private final List<Player> playersValues;
    private final Players players_;
    private final Bank bank;
    private final MaterialsCalculator calculator;
    private Players players;

    static Turns aNew(List<Player> players, Bank bank, MaterialsCalculator calculator) {
        return aNew(players, bank, calculator, new Players(players));
    }

    public static Turns aNew(List<Player> players, Bank bank, MaterialsCalculator materialCalculator, Players players1) {
        return new Turns(players, bank, materialCalculator, players1);
    }

    private Turns(List<Player> playersValues, Bank bank, MaterialsCalculator calculator, Players players1) {
        this.playersValues = playersValues;
        players_ = players1;
        players = new Players(playersValues);
        this.bank = bank;
        this.calculator = calculator;
    }

    public void newTurn() {
        final List<Player> playersValues = players.standing().values();
        playersValues.forEach(x -> x.payFixedExpenses(calculator));
        playersValues.forEach(x -> x.rawMaterialUnits(bank.rawMaterialUnitConditions()));
        playersValues.forEach(x -> x.finishedInventoryUnits(bank.finishedInventoryUserConditions()));
        playersValues.forEach(Player::obtainRawMaterialUnitBid);
        for (Player player : playersValues) {
            try {
                player.produceStock();
            } catch (BankruptException e) {
                players.bankrupted(player);
            }
        }
        playersValues.forEach(Player::sellInventory);
        playersValues.forEach(Player::payLoanInterest);
        playersValues.forEach(Player::payOutstandingLoans);
        playersValues.forEach(Player::takeOutLoans);
        playersValues.forEach(Player::orderConstruction);

    }
}
