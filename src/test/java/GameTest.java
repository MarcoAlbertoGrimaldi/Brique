import Data.Game;
import Data.PieceColor;
import Data.Player;
import Logic.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {





    @Test
    public void Hum_vs_AI() {
        Player player_1 = new Player(PieceColor.BLACK, "Human");
        Player player_2 = new Player(PieceColor.WHITE);

        check_cell_init(player_1, player_2);
    }


    private void check_cell_init(Player player_1, Player player_2) {
        Game game = new Game(player_1,player_2);
        assertTrue(game.getPlayer_1().isHuman());
        assertFalse(game.getPlayer_2().isHuman());
        assertEquals(game.getPlayer_1().getControl(), PieceColor.BLACK);
        assertEquals(game.getPlayer_2().getControl(), PieceColor.WHITE);
        assertEquals(game.getPlayer_1().getName(), "Human");
        assertEquals(game.getPlayer_2().getName(), "AI");

    }
}
