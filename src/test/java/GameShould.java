import com.example.etudes.strikeitrich.Game;
import com.example.etudes.strikeitrich.GameStarter;
import com.example.etudes.strikeitrich.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameShould {

    @Mock
    GameStarter gameStarter;

    @Mock
    Player player1;

    @Mock
    Player player2;

    @Test
    public void deal_initial_materials_to_each_player() throws Exception {
        Game game = new Game(gameStarter, Arrays.asList(player1, player2));

        game.start();

        verify(gameStarter).deal(player1);
        verify(gameStarter).deal(player2);
    }
}
