

import Data.PieceColor;
import Data.Player;
import Logic.*;
import org.junit.Test;
import org.junit.Assert;

public class PlayerTest {

    @Test
    public void AI_player() {
        Player AI_player = new Player(PieceColor.WHITE);
        Assert.assertFalse(AI_player.isHuman());
        Assert.assertEquals(PieceColor.WHITE, AI_player.getControl());
    }

    @Test
    public void check_name(){
        Player player = new Player(PieceColor.WHITE,"player_1");
        Assert.assertTrue(player.isHuman());
        Assert.assertEquals(player.getName(),"player_1");
    }


}
