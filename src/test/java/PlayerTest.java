

import Data.Graph;
import Data.PieceColor;
import Data.Player;
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

    @Test
    public void check_swapGraphs(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");
        Graph player1_graph = player1.getGraph();
        player1.swapGraphs(player2);
        Assert.assertEquals(player1_graph,player2.getGraph());
    }


}
