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

    @Before
    public void setUp() throws Exception {
        players = Arrays.asList(player1, player2);
        turns = Turns.aNew(players, bank);
    }

    @Test
    public void pay_fixed_expenses() throws Exception {
        turns.newTurn();

        verify(player1).payFixedExpenses();
        verify(player2).payFixedExpenses();
    }

    @Test
    public void inform_players_about_market_rawMaterialUnit_conditions() throws Exception {
        given(bank.rawMaterialUnitConditions()).willReturn(condition);

        turns.newTurn();

        players.stream().forEach(x -> verify(x).rawMaterialUnits(condition));
    }


    @Test
    public void inform_players_about_market_finishedInventoryUnits_conditions() throws Exception {
        given(bank.finishedInventoryUserConditions()).willReturn(condition);

        turns.newTurn();

        verify(player1).finishedInventoryUnits(condition);
        verify(player2).finishedInventoryUnits(condition);
    }


}