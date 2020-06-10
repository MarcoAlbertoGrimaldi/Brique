import Data.Cell;
import Data.PieceColor;
import Data.State;
import org.junit.Test;
import org.junit.Assert;

public class CellTest {


    @Test
    public void Cell_State_Empty(){
        Cell cell = new Cell(1,2);
        check_state(cell, State.EMPTY);
    }


    @Test
    public void Cell_Colour() {
        check_col();
    }

    @Test
    public void Cell_State_W() {
        Cell cell = new Cell(1,2);
        cell.setState(State.W_PIECE);
        check_state(cell, State.W_PIECE);
    }



    private void check_state(Cell cell, Enum<State> state){Assert.assertEquals(state, cell.getState()); }


    private void check_col() {
        Cell cell = new Cell(1,2);
        Assert.assertEquals(PieceColor.BLACK, cell.getPieceColor());
    }

}
