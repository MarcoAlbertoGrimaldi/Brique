package Data;

import java.util.stream.IntStream;

public class Board {

    public static final int dim = 15;
    private final Cell[][] grid = new Cell[dim][dim];

    public Board() {
        IntStream.range(0, dim).forEach(r-> IntStream.range(0, dim).forEach(c->grid[r][c]= new Cell(r,c)));
    }

    public Cell getCell(Coordinates coordinates) {
        return grid[coordinates.getRow()][coordinates.getCol()];
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean areEmpty(Coordinates coordinates) {
        return getCell(coordinates).getState() == State.EMPTY;
    }

}
