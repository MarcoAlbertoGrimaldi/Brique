

import Data.Board;
import org.junit.Test;
import org.junit.Assert;

public class BoardTest {

    @Test
    public void Board_Size() {
        check_dim();
    }

    private void check_dim() { Assert.assertEquals(15, Board.dim); }
}
