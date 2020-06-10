package Logic;

import CommandLine.PlayerInputHandler;
import Data.*;

import java.util.ArrayList;

public interface GameFlow {

    default boolean check_victory(Graph graph) {
        return graph.pathFound(225, 226);
    }

    default void apply_pie_rule(Player p1, Player p2) {
        p1.swapControl(p2);
        p1.swapGraphs(p2);
    }

    default Coordinates human_turn(PlayerInputHandler playerInputHandler){
        Coordinates coordinates;
        while(true) {
            String input = playerInputHandler.getInput(playerInputHandler.getCoordinate_request_msg(), playerInputHandler.getCoordinate_err_msg(), playerInputHandler.getCoordinate_pattern());
            coordinates = new Coordinates(input.charAt(0) - 'a', 15 - Integer.parseInt(input.substring(1)));
            if (!coordinates.areValid()) {
                System.out.println("Position already occupied, insert again");
            } else break;
        }
        return coordinates;
    }

    default ArrayList<Coordinates> make_move(Board board, Coordinates coordinates, Player current, Player other) {
        board.getCell(coordinates).setState(current.getControl().toState());
        ArrayList<Coordinates> escorts = Rules.escort_rules(board, coordinates, current.getControl().toState());
        current.getGraph().update_graph(coordinates, board);
        for (Coordinates escort : escorts) {
            current.getGraph().update_graph(escort, board);
            other.getGraph().restore_graph(escort, board);
        }
        escorts.add(coordinates);
        return escorts;
    }
}
