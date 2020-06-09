package Logic;

import Data.Player;
import Data.Game;

public interface LaunchGame {
    default void launchGame(Player player1, Player player2, boolean isSingle_player){
        Game game = new Game(player1, player2, isSingle_player);
        game.play();
    }
}
