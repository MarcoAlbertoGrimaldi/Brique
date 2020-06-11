package GraphicalUserInterface;

import Data.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame {

    static JLabel version;
    static JButton singlePlayer, multiPlayer, settings, quit;
    static final JFrame mainMenu = new JFrame("Brique");

    public MainMenu() throws IOException {

        mainMenu.setSize(Settings.getResolution());
        mainMenu.setLocationRelativeTo(null);

        BufferedImage myImage = ImageIO.read(new File("src/main/resources/brique.jpg"));
        mainMenu.setContentPane(new ImagePanel(myImage));

        mainMenu.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        singlePlayer = new JButton("Single Player");
        multiPlayer= new JButton("Multiplayer");
        settings = new JButton("Settings");
        quit = new JButton("Quit");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0.8;

        c.gridx = 1;
        c.gridy = 1;
        mainMenu.add(singlePlayer,c);
        c.gridy = 2;
        mainMenu.add(multiPlayer, c);
        c.gridy = 3;
        mainMenu.add(settings, c);
        c.gridy = 4;
        mainMenu.add(quit, c);

        singlePlayer.addActionListener(actionEvent -> {
            mainMenu.setVisible(false);
            new BoardFrame(true);
        });

        multiPlayer.addActionListener(actionEvent -> {
            mainMenu.setVisible(false);
            new BoardFrame(false);
        });

        settings.addActionListener(actionEvent -> {
            new SettingsFrame();
            mainMenu.setEnabled(false);
        });

        quit.addActionListener(actionEvent -> {
            mainMenu.setVisible(false);
            System.exit(0);
        });

        version = new JLabel("Version: 0.1");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 5;
        c.anchor = GridBagConstraints.PAGE_END;
        mainMenu.add(version, c);

        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setVisible(true);
    }

}
