package game;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random = new Random();

    int row, col;

    public RandomPlayer(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public RandomPlayer(TicTacToeBoard board, RandomPlayer randomPlayer, RandomPlayer randomPlayer1, int firstCount, int secondCount) {
    }

    @Override
    public Move makeMove(Position position) {
        while (true) {
            final Move move = new Move(
                    random.nextInt(row + 1),
                    random.nextInt(col + 1),
                    position.getTurn()
            );
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
