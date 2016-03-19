import com.example.etudes.strikeitrich.Game;
import com.example.etudes.strikeitrich.Player;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameShould {

    @Test
    public void deal_initial_materials_to_each_player() throws Exception {

        Player player1 = new Player(0, 0, 0, 0);
        Player expectedPlayer = new Player(2, 4, 2, 10_000);

        Game game = new Game(player1);
        game.start();

        assertThat(player1, is(expectedPlayer));
    }
}
