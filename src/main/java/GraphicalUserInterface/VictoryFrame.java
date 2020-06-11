package GraphicalUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VictoryFrame {

    final JButton exitButton;

    public VictoryFrame(String name, JFrame board) {
        JFrame victory = new JFrame("Victory!");
        victory.setSize(256,128);
        victory.setLocationRelativeTo(null);
        victory.setResizable(false);
        victory.setAlwaysOnTop(true);

        exitButton = new JButton(name + " WINS!");
        exitButton.setFont(new Font("Arial", Font.BOLD, 32));
        victory.add(exitButton);

        exitButton.addActionListener(actionEvent -> {
            victory.dispose();
            board.dispose();
        });

        victory.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        victory.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
                board.dispose();
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                MainMenu.mainMenu.setVisible(true);
                board.dispose();
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
                MainMenu.mainMenu.setVisible(true);
            }
        });

        victory.setVisible(true);
    }
}
