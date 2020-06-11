package GraphicalUserInterface;

import Data.PieceColor;
import Data.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SettingsFrame extends JFrame {

    final JFrame settingsFrame;
    final JTextField player1TextField;
    final JTextField player2TextField;
    final JComboBox<String> resolutionBox;
    final JButton cancel;
    final JButton def;
    final JButton confirm;
    final JRadioButton black;
    final JRadioButton white;
    final ButtonGroup humColour;

    SettingsFrame(){
        settingsFrame = new JFrame("Settings");
        settingsFrame.setResizable(false);
        settingsFrame.setSize(480, 480);
        settingsFrame.setLayout(new GridBagLayout());
        settingsFrame.setAlwaysOnTop(true);
        settingsFrame.setLocationRelativeTo(null);
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 8;
        c.ipady = 8;
        c.weightx = 0;
        c.weighty = 0.5;
        c.insets = new Insets(8, 8, 8, 8);

        c.gridx = 0;
        c.gridy = 1;
        settingsFrame.add(new JLabel("Player 1 name:"), c);

        player1TextField = new JTextField();
        settingsFrame.add(player1TextField);
        player1TextField.setText(Settings.getPlayer1Name());
        c.gridx = 1;
        c.gridy = 1;
        settingsFrame.add(player1TextField, c);

        c.gridx = 0;
        c.gridy = 2;
        settingsFrame.add(new JLabel("Single Player Colour:"),c);

        humColour = new ButtonGroup();
        black = new JRadioButton("Black", Settings.getPlayer1PieceColor()== PieceColor.BLACK);
        humColour.add(black);

        c.gridx = 1;
        c.gridy = 2;
        settingsFrame.add(black,c);

        white = new JRadioButton("White",Settings.getPlayer1PieceColor()== PieceColor.WHITE);
        humColour.add(white);

        c.gridx = 2;
        c.gridy = 2;
        settingsFrame.add(white,c);

        c.gridx = 0;
        c.gridy = 3;
        settingsFrame.add(new JLabel("Player 2 name:"),c);

        player2TextField = new JTextField();
        settingsFrame.add(player2TextField);
        player2TextField.setText(Settings.getPlayer2Name());

        c.gridx = 1;
        c.gridy = 3;
        settingsFrame.add(player2TextField, c);

        c.gridy = 5;
        c.gridx = 0;
        settingsFrame.add(new JLabel("Resolution:"), c);

        c.gridx = 1;
        c.gridy = 5;
        resolutionBox = new JComboBox<>(Settings.getDimensions());
        resolutionBox.setSelectedIndex(Settings.getIndex());
        settingsFrame.add(resolutionBox, c);

        c.gridy = 7;
        c.gridx = 0;
        cancel = new JButton("Cancel");
        settingsFrame.add(cancel,c);

        c.gridx = 1;
        def = new JButton("Default");
        settingsFrame.add(def,c);

        c.gridx = 2;
        confirm = new JButton("Confirm");
        settingsFrame.add(confirm,c);

        cancel.addActionListener(actionEvent -> {
            MainMenu.mainMenu.setEnabled(true);
            settingsFrame.dispose();
        });

        def.addActionListener(actionEvent -> {
            Settings.setPlayer1Name("P1");
            Settings.setPlayer1PieceColor(PieceColor.BLACK);
            Settings.setPlayer2PieceColor(PieceColor.WHITE);
            Settings.setPlayer2Name("P2");
            Settings.setResolution(1);
            MainMenu.mainMenu.setEnabled(true);
            settingsFrame.dispose();
        });

        confirm.addActionListener(actionEvent -> {
            Settings.setPlayer1Name(player1TextField.getText());
            Settings.setPlayer1PieceColor(black.isSelected() ? PieceColor.BLACK : PieceColor.WHITE);
            Settings.setPlayer2PieceColor(!black.isSelected() ? PieceColor.BLACK : PieceColor.WHITE);
            Settings.setPlayer2Name(player2TextField.getText());
            Settings.setResolution(resolutionBox.getSelectedIndex());
            MainMenu.mainMenu.setEnabled(true);
            MainMenu.mainMenu.setEnabled(true);
            settingsFrame.dispose();
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        settingsFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                MainMenu.mainMenu.setEnabled(true);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                MainMenu.mainMenu.setEnabled(true);
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
                MainMenu.mainMenu.setEnabled(true);
            }
        });
        settingsFrame.setVisible(true);
    }
}
