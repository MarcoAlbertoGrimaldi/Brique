

import Data.Board;
import Data.Coordinates;
import org.junit.Test;
import org.junit.Assert;

public class BoardTest {

    @Test
    public void Board_Size() {
        check_dim();
    }

    private void check_dim() { Assert.assertEquals(15, Board.dim); }

    @Test
    public void check_areEmpty(){
        Board board = new Board();
        Coordinates coordinates = new Coordinates(1, 2);
        Assert.assertTrue(board.areEmpty(coordinates));
    }


}

