package com.example.etudes.strikeitrich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

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

    @Test
    public void pay_fixed_expenses() throws Exception {
        Turns turns = Turns.aNew(Arrays.asList(player1, player2), bank);

        turns.newTurn();

        verify(player1).payFixedExpenses();
        verify(player2).payFixedExpenses();
    }

    @Test
    public void inform_players_about_market_conditions() throws Exception {
        given(bank.rawMaterialUnitConditions()).willReturn(condition);
        Turns turns = Turns.aNew(Arrays.asList(player1, player2), bank);

        turns.newTurn();

        verify(player1).rawMaterialUnits(condition);
        verify(player2).rawMaterialUnits(condition);
    }


}