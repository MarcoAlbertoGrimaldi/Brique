import Data.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class GraphTest {

    @Test
    public void check_edge() {
        Graph graph = new Graph(PieceColor.WHITE);
        Coordinates c = new Coordinates(0, 0);
        Coordinates d = new Coordinates(0, 1);
        graph.addEdge(c, d);
        assertEquals(1, graph.adjacencyList.get(0).get(1).intValue());
    }

    @Test
    public void check_rmvEdge(){
        Graph graph = new Graph(PieceColor.WHITE);
        Coordinates c = new Coordinates(0, 0);
        Coordinates d = new Coordinates(0, 1);
        graph.addEdge(c, d);
        graph.rmvEdge(c,d);
        assertFalse(graph.pathFound(0, 1));
    }


    @Test
    public void check_pathFound(){
        Graph graph = new Graph(PieceColor.WHITE);
        for(int j = 0;j<14;j++){
            Coordinates start_row = new Coordinates(0,j);
            Coordinates end_row = new Coordinates(0,j+1);
            graph.addEdge(start_row, end_row);
            Coordinates start_col = new Coordinates(j,0);
            Coordinates end_col= new Coordinates(j+1,0);
            graph.addEdge(start_col, end_col);
        }
        graph.addEdge(new Coordinates(0,0), new Coordinates(14,15));
        graph.addEdge(new Coordinates(0,14), new Coordinates(14,16));
        assertTrue(graph.pathFound(15*15,15*15+1));

    }

    @Test
    public void check_find_neighbours(){
        Graph graph = new Graph(PieceColor.WHITE);
        Board board = new Board();
        board.getCell(new Coordinates(1,1)).setState(State.W_PIECE);
        board.getCell(new Coordinates(0,1)).setState(State.W_PIECE);
        ArrayList<Coordinates> neighbours = graph.find_neighbours(new Coordinates(1,1),PieceColor.WHITE,board);
        assertEquals(0, neighbours.get(0).getRow());
        assertEquals(1, neighbours.get(0).getCol());


    }


}
