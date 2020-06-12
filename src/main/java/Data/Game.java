package Data;

import Logic.GameFlow;

public class Game implements GameFlow {

    protected final Player player_1;
    protected final Player player_2;
    protected final Board board;
    protected boolean pieRule = false;
    protected int move_counter = 0;

    public Game(Player player_1, Player player_2){
        this.player_1 = player_1;
        this.player_2 = player_2;
        board = new Board();
    }

    public void play() {
    }

    public void setPieRule(boolean pieRule) {
        this.pieRule = pieRule;
    }

    public Player getPlayer_1() {
        return player_1;
    }

    public Player getPlayer_2() {
        return player_2;
    }

    public Player getCurrent_player(){
        if (player_1.isCurrent()) return player_1;
        else return player_2;
    }

    public Player getOther_player(){
        if (!player_1.isCurrent()) return player_1;
        else return player_2;
    }

    public Board getBoard(){
        return this.board;
    }

    public int getMove_counter() { return move_counter; }

    public void increaseMoveCounter(){
        this.move_counter++;
    }
}



