package Data;

import java.util.Arrays;

public class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int r, int c) {
        row = r;
        col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean areValid() {
        int[] x = new int[]{this.row, this.col};
        return (Arrays.stream(x).filter(z -> z < 15).filter(z -> z >= 0).count() == 2);
    }

    public static boolean valid_coordinates(int i, int j) {
        return (new Coordinates(i, j)).areValid();
    }

    @Override
    public String toString() {
        return (char) (col + 97) + String.valueOf(15 - row);
    }
}