package game;

import java.util.Scanner;

public class CheatingPlayer implements Player {
    int row, col, k;

    public CheatingPlayer(int row, int col, int k) {
        this.row = row;
        this.col = col;
        this.k = k;
    }

    @Override
    public Move makeMove(Position position) {
        final TicTacToeBoard board = (TicTacToeBoard) position;
        Move first = null;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    if (first == null) {
                        first = move;
                    } else {
                        board.makeMove(move);
                    }
                }
            }
        }
        return first;
    }
}
