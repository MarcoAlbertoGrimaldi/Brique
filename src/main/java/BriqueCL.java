import CommandLine.*;
import Data.PieceColor;
import Data.Player;

public class BriqueCL{

    boolean exit = false;

    public static void main(String[] args) {

        BriqueCL briqueCL = new BriqueCL();
        Menu menu = new Menu();
        PlayerInputHandler playerInputHandler = new PlayerInputHandler();

        while (!briqueCL.exit){
            menu.printMenu();
            String input = playerInputHandler.getInput(menu.getReq_msg(), menu.getErr_message(), menu.getPattern());
            String p1_name, p2_name;
            CLGame game;

            switch(input) {
                case "0":
                    p1_name = getName(playerInputHandler);
                    game = new CLGame(new Player(PieceColor.BLACK, p1_name), new Player(PieceColor.WHITE));
                    game.play();
                    break;
                case "1":
                    p1_name = getName(playerInputHandler);
                    game = new CLGame(new Player(PieceColor.BLACK), new Player(PieceColor.WHITE, p1_name));
                    game.play();
                    break;
                case "2":
                    p1_name = getName(playerInputHandler);
                    p2_name = getName(playerInputHandler);
                    game = new CLGame(new Player(PieceColor.BLACK, p1_name), new Player(PieceColor.WHITE, p2_name));
                    game.play();
                    break;
                case  "3":
                    briqueCL.exit = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        System.out.println("Bye!");

    }

    static String getName(PlayerInputHandler playerInputHandler){
        return playerInputHandler.getInput(playerInputHandler.getPlayer_request_msg(), playerInputHandler.getPlayer_err_msg(), playerInputHandler.getPlayer_pattern());
    }
}
