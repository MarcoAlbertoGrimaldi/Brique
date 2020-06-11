package GraphicalUserInterface;

import Logic.AI_Logic;
import Data.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PieRuleFrame {

    final JButton yes;
    final JButton no;

    public PieRuleFrame(JFrame board, Game game, BoardFrame boardFrame) {
        JFrame pieRule = new JFrame("Pie Rule");
        pieRule.setLayout(new FlowLayout());
        pieRule.setSize(260,120);
        pieRule.setLocationRelativeTo(null);
        pieRule.setResizable(false);
        pieRule.setAlwaysOnTop(true);

        pieRule.add(new JLabel("Do you want to apply the Pie Rule?"));
        yes = new JButton("Yes");
        pieRule.add(yes);

        yes.addActionListener(actionEvent -> {
            game.apply_pie_rule(game.getCurrent_player(), game.getOther_player());
            game.setPieRule(true);

            if(boardFrame.isSingle_Player) boardFrame.boardCellClick(AI_Logic.chooseRandomCoordinates(game.getBoard()));
            boardFrame.setEnabled(true);
            pieRule.dispose();
        });

        no = new JButton("No");
        pieRule.add(no);

        no.addActionListener(actionEvent -> {
            boardFrame.setEnabled(true);
            pieRule.dispose();
        });


        pieRule.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pieRule.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                board.setEnabled(true);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                board.setEnabled(true);
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
                board.setEnabled(true);
            }
        });

        pieRule.setVisible(true);
    }
}
