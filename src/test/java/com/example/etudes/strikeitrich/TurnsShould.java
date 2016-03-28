package com.example.etudes.strikeitrich;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TurnsShould {

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    @Mock
    private Bank bank;

    @Mock
    Condition condition;
    private Turns turns;
    private List<Player> players;
    @Mock
    private MaterialsCalculator materialCalculator;

    @Before
    public void setUp() throws Exception {
        players = Arrays.asList(player1, player2);
        turns = Turns.aNew(players, bank, materialCalculator);
    }

    @Test
    public void pay_fixed_expenses() throws Exception {
        newTurn();

        players.stream().forEach(x -> verify(x).payFixedExpenses(materialCalculator));
    }

    private void newTurn() {
        turns.newTurn();
    }

    @Test
    public void inform_players_about_market_rawMaterialUnit_conditions() throws Exception {
        given(bank.rawMaterialUnitConditions()).willReturn(condition);

        newTurn();

        players.stream().forEach(x -> verify(x).rawMaterialUnits(condition));
    }


    @Test
    public void ask_players_about_their_bids() throws Exception {
        newTurn();

        players.stream().forEach(x -> verify(x).obtainRawMaterialUnitBid());
    }

    @Test
    public void ask_players_to_produce_stock() throws Exception {
        newTurn();

        players.stream().forEach(x -> verify(x).produceStock());
    }


    @Test
    public void inform_players_about_market_finishedInventoryUnits_conditions() throws Exception {
        given(bank.finishedInventoryUserConditions()).willReturn(condition);

        newTurn();

        players.stream().forEach(x -> verify(x).finishedInventoryUnits(condition));
    }

    @Test
    public void ask_players_to_sell_inventory() throws Exception {
        newTurn();

        players.stream().forEach(x -> verify(x).sellInventory());
    }

    @Test
    public void ask_players_pay_loan_interest() throws Exception {
        newTurn();

        players.stream().forEach(x -> verify(x).payLoanInterest());
    }

}