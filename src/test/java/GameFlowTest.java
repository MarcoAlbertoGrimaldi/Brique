import Data.*;
import Logic.GameFlow;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GameFlowTest implements GameFlow {

    @Test
    public void Check_check_victory() {
        Graph white_graph = new Graph(PieceColor.WHITE);
        Graph black_graph = new Graph(PieceColor.BLACK);
        Board white_board = new Board();
        Board black_board = new Board();
        for (int i = 0; i < 15; i = i + 1) {
            Coordinates horizontal_coordinates = new Coordinates(1, i);
            Coordinates vertical_coordinates = new Coordinates(i, 1);
            white_board.getCell(horizontal_coordinates).setState(State.W_PIECE);
            white_graph.update_graph(horizontal_coordinates, white_board);
            black_board.getCell(vertical_coordinates).setState(State.B_PIECE);
            black_graph.update_graph(vertical_coordinates, black_board);
        }
        Assert.assertTrue(check_victory(white_graph));
        Assert.assertTrue(check_victory(black_graph));
    }


    @Test
    public void check_makeMove(){
        Player player_1 = new Player(PieceColor.BLACK, "Human");
        Player player_2 = new Player(PieceColor.WHITE,"Human");
        Board board = new Board();
        Coordinates coordinates = new Coordinates(1,1);
        ArrayList<Coordinates> res = make_move(board,coordinates,player_1,player_2);
        Assert.assertEquals(board.getCell(coordinates).getState(), State.B_PIECE);
    }


}
