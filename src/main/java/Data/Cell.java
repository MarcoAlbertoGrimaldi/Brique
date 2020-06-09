package Data;

public class Cell {
    private final Coordinates coordinates;
    private PieceColor pieceColor;
    private State state = State.EMPTY;

    public Cell(int i, int j) {
        coordinates = new Coordinates(i, j);
        setColour(i, j);
    }

    private void setColour(int i, int j) {
        if ((i + j) % 2 == 1) pieceColor = PieceColor.BLACK;
        else pieceColor = PieceColor.WHITE;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) { this.state = state; }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}