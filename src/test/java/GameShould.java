import com.example.etudes.strikeitrich.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
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

    private List<Player> playersValues;
    private Players players;

    @Before
    public void setUp() throws Exception {
        playersValues = asList(player1, player2);
        players = new Players(playersValues);
    }

    @Test
    public void deal_initial_materials_to_each_player() throws Exception {
        Game game = new Game(gameStarter, turns, playersValues, players);

        game.start();

        playersValues.forEach(x -> verify(gameStarter).deal(x));
    }

    @Test
    public void start_a_new_turn_when_the_game_starts() throws Exception {
        Game game = new Game(gameStarter, turns, playersValues, players);

        game.start();

        verify(turns, atLeast(1)).newTurn();
    }
}
