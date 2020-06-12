package GraphicalUserInterface;

import Data.Coordinates;
import Data.Player;
import Data.Settings;
import Logic.AI_Logic;
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

    final boolean isSingle_Player;
    final JFrame board;
    final String player1Name;
    final String player2Name;
    final Dimension dimension;
    final Game game;
    final ArrayList<CellPanel> CellPanels = new ArrayList<>();

    BoardFrame(boolean isSingle_Player){

        this.player1Name = Settings.getPlayer1Name();
        this.player2Name = Settings.getPlayer2Name();
        this.isSingle_Player = isSingle_Player;
        this.dimension = Settings.getResolution();

        if (isSingle_Player){
            board = new JFrame(player1Name + " VS. AI!");
            game = new Game(new Player(Settings.getPlayer1PieceColor(), player1Name), new Player(Settings.getPlayer2PieceColor()));

        } else {
            board = new JFrame(player1Name + " VS. " + player2Name + "!");
            game = new Game(new Player(PieceColor.BLACK, player1Name), new Player(PieceColor.WHITE, player2Name));
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
        if (game.getPlayer_1().getControl()==PieceColor.WHITE && isSingle_Player) {
            boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));

            new PieRuleFrame(board, game, this);
            board.setVisible(true);
        }
        board.addMouseListener(this);
        board.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        board.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {}

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {}

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {}

            @Override
            public void windowActivated(WindowEvent windowEvent) {}

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {}
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
        if (!isSingle_Player && game.getMove_counter()==1){
            board.setEnabled(false);
            new PieRuleFrame(board, game,this);
        }
        game.getCurrent_player().switchPlayer(game.getOther_player());
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int row = (mouseEvent.getY()-30)/(Settings.getResolution().height/15);
        int col = (mouseEvent.getX()-7)/(Settings.getResolution().width/15);
        Coordinates coordinates = new Coordinates(row, col);
        if(game.getBoard().areEmpty(coordinates)) {
            boardCellClick(coordinates);
            if(game.check_victory(game.getOther_player().getGraph())){
                board.setEnabled(false);
                new VictoryFrame(game.getOther_player().getName(), board);
            }
            if(isSingle_Player) {
                boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
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
