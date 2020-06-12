package Data;

public class Player {

    private boolean human = false;
    private PieceColor control;
    private String name = "AI";
    private Graph graph;
    private boolean current = false;
    private final boolean resigned = false;

    public Player(PieceColor control){
        this.control = control;
        this.graph = new Graph(control);
        if (control == PieceColor.BLACK) this.current = true;
    }

    public Player(PieceColor control, String name) {
        this.human = true;
        this.control = control;
        this.name = name;
        this.graph = new Graph(control);
        if (control == PieceColor.BLACK) this.current = true;
    }

    public void switchPlayer(Player other){
        if(isCurrent()){
            setCurrent(false);
            other.setCurrent(true);
        } else {
            setCurrent(true);
            other.setCurrent(false);
        }
    }

    public void swapGraphs(Player other) {
        Graph temp = getGraph();
        setGraph(other.getGraph());
        other.setGraph(temp);
    }

    public void swapControl(Player other) {
        PieceColor temp = getControl();
        setControl(other.getControl());
        other.setControl(temp);
    }

    public boolean isHuman() {
        return human;
    }

    public boolean isCurrent() {
        return current;
    }

    public String getName() {
        return name;
    }

    public PieceColor getControl() {
        return control;
    }

    public Graph getGraph(){ return graph; }

    public void setGraph(Graph graph){ this.graph = graph; }

    public void setControl(PieceColor control) {
        this.control = control;
    }

    public void setCurrent(boolean bool) {
        this.current = bool;
    }

// --Commented out by Inspection START (11/06/2020 10:06):
//    public void setResigned() {
//        this.resigned = true;
//    }
// --Commented out by Inspection STOP (11/06/2020 10:06)

    public boolean isResigned() { return resigned; }
}
