package CommandLine;

import Data.Coordinates;
import Data.Game;
import Data.Player;
import Logic.AI_Logic;

public class CLGame extends Game implements OutputInterface {

    private final PlayerInputHandler playerInputHandler;

    public CLGame(Player player_1, Player player_2) {
        super(player_1, player_2);
        playerInputHandler = new PlayerInputHandler();
    }

    @Override
    public void play() {
        super.play();
        if(getCurrent_player().isHuman()) printBoard(getBoard());
        boolean victory = false;
        Coordinates coordinates;

        while (!victory){
            if(getCurrent_player().isHuman()){
                printCurrentPlayer(getCurrent_player());
                String input_move = getPlayerMove(playerInputHandler);
                if(input_move.equals("res")){
                    printResignedMessage(getCurrent_player().getName());
                    break;
                } else {
                    coordinates = new Coordinates(15 - Integer.parseInt(input_move.substring(1)), input_move.charAt(0) - 'a');
                }
            }
            else {
                coordinates = AI_Logic.chooseRandomCoordinates(board);
            }
            increaseMoveCounter();
            make_move(board, coordinates, getCurrent_player(), getOther_player());

            if(move_counter==1 && getOther_player().isHuman()){
                printBoard(board);
                String pie_rule = playerInputHandler.getInput(playerInputHandler.pie_rule_request_msg, playerInputHandler.pie_rule_err_msg, playerInputHandler.pie_rule_pattern);
                if(pie_rule.equals("1")) {
                    pieRule = true;
                    apply_pie_rule(player_1, player_2);
                }
            }

            printMove(String.valueOf(move_counter), getCurrent_player().getName(), getCurrent_player().getControl().toString());
            printBoard(board);

            if(move_counter >= 28){
                victory = check_victory(getCurrent_player().getGraph());
            }

            getCurrent_player().switchPlayer(getOther_player());
        }
        getCurrent_player().switchPlayer(getOther_player());
        printVictoryMessage(getCurrent_player().getName());
    }
}
