package Data;

public enum PieceColor {
    BLACK {
        @Override
        public String toString() {
            return "Black";
        }

        public State toState() { return State.B_PIECE; }
    },
    WHITE{
        @Override
        public String toString() {
            return "White";
        }

        public State toState() { return State.W_PIECE; }
    };

    public abstract State toState();
}
