import com.example.etudes.strikeitrich.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    @Mock
    GameStarter gameStarter;

    @Mock
    Player player1;

    @Mock
    Player player2;

    @Mock
    private Turns turns;

    @Mock
    private Bank bank;

    private List<Player> players;

    @Before
    public void setUp() throws Exception {
        players = asList(player1, player2);
    }

    @Test
    public void deal_initial_materials_to_each_player() throws Exception {
        Game game = new Game(gameStarter, turns, players);

        game.start();

        players.forEach(x -> verify(gameStarter).deal(x));
    }

    @Test
    public void start_a_new_turn_when_the_game_starts() throws Exception {
        Game game = new Game(gameStarter, turns, Collections.emptyList());
        when(turns.canStartNew()).thenReturn(true, false);

        game.start();

        verify(turns, times(1)).newTurn();
    }

    @Test
    public void do_not_start_a_turn_while_players_are_bankrupt() throws Exception {
        Game game = new Game(gameStarter, turns, players);
        when(turns.canStartNew()).thenReturn(false);

        game.start();

        verify(turns, times(0)).newTurn();
    }


    @Test
    public void only_start_a_turn_while_players_are_standing() throws Exception {
        Game game = new Game(gameStarter, turns, players);
        when(turns.canStartNew()).thenReturn(true, true, true, false);

        game.start();

        verify(turns, times(3)).newTurn();
    }
}
