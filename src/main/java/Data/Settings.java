package Data;

import java.awt.*;

public class Settings {

    static String player1Name = "p1", player2Name = "p2";
    static PieceColor Player1PieceColor = PieceColor.BLACK, Player2PieceColor = PieceColor.WHITE;
    static int resolution = 1;
    static final String[] dimensions = {"480x480", "720x720", "960x960"};
    static final Double ratio = 2.0/3;


    public static Dimension getResolution() {
        return toDimension(dimensions[resolution]);
    }

    public static void setResolution(int idx) {
        Settings.resolution = idx;
    }

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static void setPlayer1Name(String player1Name) {
        Settings.player1Name = player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public static void setPlayer2Name(String player2Name) {
        Settings.player2Name = player2Name;
    }

    public static String[] getDimensions() {
        return dimensions;
    }

    public static Dimension toDimension(String str){
        return new Dimension(Integer.parseInt(str.split("x")[0]), Integer.parseInt(str.split("x")[1]));
    }

    public static int getIndex() {
        return resolution;
    }

    public static double getRatio() {
        return ratio;
    }

    public static PieceColor getPlayer1PieceColor() {
        return Player1PieceColor;
    }

    public static void setPlayer1PieceColor(PieceColor player1PieceColor) {
        Settings.Player1PieceColor = player1PieceColor;
    }

    public static PieceColor getPlayer2PieceColor() {
        return Player2PieceColor;
    }

    public static void setPlayer2PieceColor(PieceColor player2PieceColor) {
        Settings.Player2PieceColor = player2PieceColor;
    }
}


