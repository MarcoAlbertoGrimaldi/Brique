package CommandLine;

import Data.Board;
import Data.Coordinates;
import Data.Player;
import Data.State;

public interface OutputInterface {



    default void printCurrentPlayer(Player player){
        System.out.println(player.getName()+"'s turn.\n");
    }

    default void printMove(String counter, String name, String control){
        System.out.print("Move #" + counter + " (" + name + "-" + control + ")");
        System.out.println();
    }

    default void printBoard(Board board) {
        System.out.print("   ");
        for (int i = 0; i < Board.dim; i = i + 1) {
            System.out.print(" " + (char) (i + 'a'));
        }
        System.out.println(" ");
        for (int i = 0; i < Board.dim; i = i + 1) {
            if (i > 5) System.out.print(" ");
            System.out.print(15 - i + " ");
            for (int j = 0; j < Board.dim; j = j + 1) {
                Coordinates temp = new Coordinates(i, j);
                if (board.getCell(temp).getState() == State.B_PIECE) {
                    System.out.print("|" + "B");
                } else if (board.getCell(temp).getState() == State.W_PIECE) {
                    System.out.print("|" + "W");
                } else if ((i * 15 + j) % 2 == 0) {
                    System.out.print("|#");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("| ");
            System.out.println(15 - i);
        }
        System.out.print("   ");
        for (int i = 0; i < Board.dim; i = i + 1) {
            System.out.print(" " + (char) (i + 'a'));
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------");
    }

    default void printResignedMessage(String name){
        System.out.println(name + " resigned!");
    }

    default void printVictoryMessage(String name){
        System.out.println(name + " WINS!");
    }
}
