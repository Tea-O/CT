package game;

public class SequentialPlayer implements Player {

    int row, col;

    public SequentialPlayer(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public Move makeMove(Position position) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new AssertionError("No valid moves");
    }
}
