package com.example.etudes.strikeitrich;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PlayerShouldPayRawMaterialUnitsShould implements CashModifier {

    private static final int ZERO = 0;
    private static final int MANY = 3;
    private static final int ANY = 0;
    private static MaterialsCalculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = Mockito.mock(MaterialsCalculator.class);
    }

    private static final int EACH_UNIT_PRICE = 300;
    private static final int INITIAL_CASH = 10_000;

    @Test
    public void when_zero_units() throws Exception {
        assertThatPayingFor(ZERO).reducesTheCash();
    }

    @Test
    public void when_many_units() throws Exception {
        assertThatPayingFor(MANY).reducesTheCash();
    }

    private PayingStub assertThatPayingFor(int numberOfUnits) {
        Player player = buildSut(numberOfUnits, INITIAL_CASH);

        player.payFixedExpenses(calculator);

        assertThat(player, is(buildSutMinusUnits(numberOfUnits, INITIAL_CASH - numberOfUnits * EACH_UNIT_PRICE)));

        return new PayingStub();
    }

    private Player buildSutMinusUnits(int numberOfUnits, int cash) {
        return buildSut(numberOfUnits, cash - numberOfUnits * EACH_UNIT_PRICE);
    }


    @Override
    public Player buildSut(int numberOfUnits, int cash) {
        return new Player(ANY, numberOfUnits, ANY, cash);
    }
}