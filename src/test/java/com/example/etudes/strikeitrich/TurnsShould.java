package com.example.etudes.strikeitrich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TurnsShould {

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    @Test
    public void pay_fixed_expenses() throws Exception {
        Turns turns = new Turns(Arrays.asList(player1, player2));

        turns.newTurn();

        verify(player1).payFixedExpenses();
        verify(player2).payFixedExpenses();
    }


}