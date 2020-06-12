import CommandLine.OutputInterface;
import Data.Board;
import Data.Coordinates;
import Data.State;
import org.junit.Test;

public class OutputInterfaceTest implements OutputInterface {
    @Test
    public void testDisplay() {
        Board board = new Board();
        board.getCell(new Coordinates(0,0)).setState(State.B_PIECE);
        board.getCell(new Coordinates(0,8)).setState(State.W_PIECE);
        board.getCell(new Coordinates(10,8)).setState(State.W_PIECE);
        board.getCell(new Coordinates(14,14)).setState(State.B_PIECE);

        printBoard(board);
    }


    @Test
    public void testprintMove(){
        printMove("1","giacomo","white");
    }





}
