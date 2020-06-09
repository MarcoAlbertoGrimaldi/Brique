package Logic;

import Data.Board;
import Data.Coordinates;
import Data.State;

import java.util.Random;

public class AI_Logic {
    public static Coordinates chooseRandomCoordinates(Board board){
        Random rand = new Random();
        Coordinates coord = null;
        boolean control = false;
        while(!control){
            int row = rand.nextInt(15);
            int col = rand.nextInt(15);
            coord = new Coordinates(row,col);
            control = board.getCell(coord).getState() == State.EMPTY;
        }
        return coord;
    }
}
