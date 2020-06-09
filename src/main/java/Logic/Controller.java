package Logic;

import Data.*;

public class Controller {


    public static boolean check_victory(Graph graph) {
        return graph.pathFound(225, 226);
    }

    public static boolean areEmpty(Board board, Coordinates coordinates) {
        return board.getCell(coordinates).getState() == State.EMPTY;
    }


}
