package Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private final PieceColor pieceColor;
    private  final int num_vertices = 227;
    public final ArrayList<LinkedList<Integer>> adjacencyList;

    public Graph(PieceColor col) {
        pieceColor = col;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < num_vertices; ++i)
            adjacencyList.add(new LinkedList<>());
        addBorders(this.pieceColor);
    }

    public void addEdge(Coordinates v, Coordinates w) {
        adjacencyList.get(v.getRow() * 15 + v.getCol()).add(w.getRow() * 15 + w.getCol());
        adjacencyList.get(w.getRow() * 15 + w.getCol()).add(v.getRow() * 15 + v.getCol());
    }

    void addBorders(PieceColor control){
        if(control == PieceColor.WHITE){
            for(int i = 0; i < 15; ++i){
                addEdge(new Coordinates(i, 0), new Coordinates(14,15));
                addEdge(new Coordinates(i, 14), new Coordinates(14,16));
            }
        }
        if(control == PieceColor.BLACK){
            for(int i = 0; i < 15; ++i){
                addEdge(new Coordinates(0, i), new Coordinates(14,15));
                addEdge(new Coordinates(14, i), new Coordinates(14,16));
            }
        }
    }

    public void rmvEdge(Coordinates v, Coordinates w) {
        adjacencyList.get(v.getRow() * 15 + v.getCol()).remove(adjacencyList.get(v.getRow() * 15 + v.getCol()).indexOf(w.getRow() * 15 + w.getCol()));
        adjacencyList.get(w.getRow() * 15 + w.getCol()).remove(adjacencyList.get(w.getRow() * 15 + w.getCol()).indexOf(v.getRow() * 15 + v.getCol()));
    }

    int coordsToInt(Coordinates coordinates){
        return coordinates.getRow() * 15 + coordinates.getCol();
    }

   public boolean pathFound(int s, int d) {

        boolean[] visited = new boolean[num_vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        Iterator<Integer> i;

        while (queue.size() != 0) {
            s = queue.poll();
            i = adjacencyList.get(s).listIterator();
            int next = 0;
            while (i.hasNext()) {
                next = i.next();
                if (next == d) {
                    return true;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }

    public void update_graph(Coordinates coordinates, Board board){
        ArrayList<Coordinates> neighbours = find_neighbours(coordinates, this.pieceColor, board);
        for(Coordinates x: neighbours){
            addEdge(coordinates,x);
        }
    }

    public void restore_graph(Coordinates coordinates, Board board){
        ArrayList<Coordinates> opponents = find_neighbours(coordinates, this.pieceColor, board);
        for(Coordinates x: opponents){
            if (pathFound(coordsToInt(coordinates), coordsToInt(x))){
                rmvEdge(coordinates,x);
            }
        }
    }

    public ArrayList<Coordinates> find_neighbours(Coordinates coordinates, PieceColor pieceColor, Board board) {

        State state = pieceColor.toState();

        ArrayList<Coordinates> neighbours = new ArrayList<Coordinates>();
        int row = coordinates.getRow();
        int col = coordinates.getCol();

        new ArrayList<>(Arrays.asList(-1, 1)).forEach(i->{if(new Coordinates(row + i, col).areValid() &&board.getCell(row + i, col).getState() == state){
            neighbours.add(new Coordinates(row + i, col));}});
        new ArrayList<>(Arrays.asList(-1, 1)).forEach(i->{if(new Coordinates(row , col+i).areValid() &&board.getCell(row , col+i).getState() == state){
            neighbours.add(new Coordinates(row, col+i));}});

        return neighbours;
    }

}