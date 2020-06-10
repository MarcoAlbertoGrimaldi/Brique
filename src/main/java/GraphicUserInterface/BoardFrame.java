package GraphicUserInterface;

import Data.Coordinates;
import Data.Player;
import Data.Settings;
import Logic.AI_Logic;
import Logic.Controller;
import Data.Game;
import Data.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class BoardFrame extends JFrame implements MouseListener {

    boolean isSingle_Player;
    JFrame board;
    String player1Name, player2Name;
    Dimension dimension;
    Game game;
    ArrayList<CellPanel> CellPanels = new ArrayList<>();

    BoardFrame(boolean isSingle_Player){

        this.player1Name = Settings.getPlayer1Name();
        this.player2Name = Settings.getPlayer2Name();
        this.isSingle_Player = isSingle_Player;
        this.dimension = Settings.getResolution();

        if (isSingle_Player){
            board = new JFrame(player1Name + " VS. AI!");
            game = new Game(new Player(Settings.getPlayer1PieceColor(), player1Name), new Player(Settings.getPlayer2PieceColor()), true);

        } else {
            board = new JFrame(player1Name + " VS. " + player2Name + "!");
            game = new Game(new Player(PieceColor.BLACK, player1Name), new Player(PieceColor.WHITE, player2Name), false);
        }

        dimension.setSize(dimension.width + 14, dimension.height + 37);
        board.setSize(dimension);
        board.setResizable(false);
        board.setBackground(Color.BLACK);
        board.setLocationRelativeTo(null);

        board.setLayout(new GridLayout(15,15, 0,0));

        for(int i = 0; i < 15; i++){
            for (int j = 0; j < 15 ; j++) {
                this.CellPanels.add(new CellPanel(i,j));
                board.add(CellPanels.get(i * 15 + j));
            }
        }

        board.addMouseListener(this);
        board.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (game.getPlayer_1().getControl()==PieceColor.WHITE && isSingle_Player) {
            boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
            new PieRuleFrame(board, game, this);
        }

        board.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });

        board.setVisible(true);
    }

    void boardCellClick(Coordinates coordinates){

        game.increaseMoveCounter();
        ArrayList<Coordinates> toDraw = game.make_move(game.getBoard(), coordinates,game.getCurrent_player(), game.getOther_player());
        for(Coordinates coordinate : toDraw){
            CellPanels.get(coordinate.getRow() * 15 + coordinate.getCol()).setState(game.getCurrent_player().getControl());
            CellPanels.get(coordinate.getRow() * 15 + coordinate.getCol()).repaint();
        }
        if (isSingle_Player && game.getMove_counter()==1) new PieRuleFrame(board, game,this);
        game.getCurrent_player().swapControl(game.getOther_player());
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Coordinates coordinates = new Coordinates((mouseEvent.getY()-30)/(Settings.getResolution().height/15), (mouseEvent.getX()-7)/(Settings.getResolution().width/15));
        if(Controller.areEmpty(game.getBoard(), coordinates)) {
            boardCellClick(new Coordinates((mouseEvent.getY()-30)/(Settings.getResolution().height/15), (mouseEvent.getX()-7)/(Settings.getResolution().width/15)));
            if(!isSingle_Player && !Controller.check_victory(game.getOther_player().getGraph())) {
                boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
            }
            if(Controller.check_victory(game.getOther_player().getGraph())){
                new VictoryFrame(game.getOther_player().getName(), board);
                board.setEnabled(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
