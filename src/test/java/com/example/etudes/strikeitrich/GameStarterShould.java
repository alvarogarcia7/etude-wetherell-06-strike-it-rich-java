package com.example.etudes.strikeitrich;

import com.example.etudes.strikeitrich.player.PlayerObjectMother;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameStarterShould {

    @Test
    public void deal_to_players() throws Exception {
        Player player1 = PlayerObjectMother.emptyWithCash(0);
        GameStarter gameStarter = new GameStarter();

        gameStarter.deal(player1);

        assertThat(player1, is(new Player(2, 4, 2, 10_000, 0)));
    }

}