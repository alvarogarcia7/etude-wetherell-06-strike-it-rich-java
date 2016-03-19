package com.example.etudes.strikeitrich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TurnsShould {

    private Player player;

    @Test
    public void pay_fixed_expenses() throws Exception {
        Turns turns = new Turns(Arrays.asList(player));

        turns.newTurn();

        verify(player).payFixedExpenses();
    }


}