package CommandLine;

import Data.Coordinates;
import Data.Game;
import Data.Player;
import Logic.AI_Logic;
import Logic.Controller;
import Logic.GameFlow;

public class CLGame extends Game implements OutputInterface {

    private final PlayerInputHandler playerInputHandler;

    public CLGame(Player player_1, Player player_2, boolean isSinglePlayer) {
        super(player_1, player_2, isSinglePlayer);
        playerInputHandler = new PlayerInputHandler();
    }

    @Override
    public void play() {
        super.play();
        if(getPlayer_1().isHuman()) printBoard(getBoard());
        boolean victory = false;
        Coordinates coordinates;

        while (!victory){
            if(getCurrent_player().isHuman()) coordinates = human_turn(playerInputHandler);
            else coordinates = AI_Logic.chooseRandomCoordinates(board);
            increaseMoveCounter();

            make_move(board, coordinates, getCurrent_player(), getOther_player());

            if(getCurrent_player().isResigned()){
                printResignedMessage(getCurrent_player().getName());
                break;
            }
            printMove(String.valueOf(move_counter), getCurrent_player().getName(), getCurrent_player().getControl().toString());
            printBoard(board);

            if(move_counter==1){
                getCurrent_player().switchPlayer(getOther_player());
                String pie_rule = playerInputHandler.getInput(playerInputHandler.pie_rule_request_msg, playerInputHandler.pie_rule_err_msg, playerInputHandler.pie_rule_pattern);
                if(pie_rule.equals("1"))  pieRule = true;
                apply_pie_rule(player_1, player_2);
            }

            if(move_counter >= 28){
                victory = Controller.check_victory(getCurrent_player().getGraph());
            }

            getCurrent_player().switchPlayer(getOther_player());
        }
        getCurrent_player().switchPlayer(getOther_player());
        printVictoryMessage(getCurrent_player().getName());
    }
}
