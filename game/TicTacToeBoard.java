package game;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class TicTacToeBoard implements Board, Position {
    int row, col, k;
    private int moveCounter = 0;

    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    private final Cell[][] field;
    private Cell turn;

    public TicTacToeBoard(int row, int col, int k) {
        this.row = row;
        this.col = col;
        this.k = k;
        field = new Cell[row][col];
        for (Cell[] rowy : field) {
            Arrays.fill(rowy, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.UNKNOWN;
        }
        field[move.getRow()][move.getCol()] = move.getValue();
        moveCounter++;
        if (checkWin(move)) {
            return GameResult.WIN;
        } else if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        if (moveCounter == row * col) {
            return true;
        } else {
            return false;
        }
    }

    private int counter(int c, int r, int stepCol, int stepRow) {
        int count = 0;
        while (c + stepCol < col && r + stepRow < row && c + stepCol >= 0 && r + stepRow >= 0) {
            if (field[r + stepRow][c + stepCol] == turn && count <= k) {
                c += stepCol;
                r += stepRow;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private boolean checkWin(Move move) {
        int c = move.getCol();
        int r = move.getRow();
        if (counter(c, r, 1, 0) + counter(c, r, -1, 0) + 1 >= k) {
            return true;
        }

        if (counter(c, r, 0, 1) + counter(c, r, 0, -1) + 1 >= k) {
            return true;
        }

        if (counter(c, r, 1, 1) + counter(c, r, -1, -1) + 1 >= k) {
            return true;
        }

        if (counter(c, r, -1, 1) + counter(c, r, 1, -1) + 1 >= k) {
            return true;
        }
        return false;
    }

    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < row
                && 0 <= move.getCol() && move.getCol() < col
                && field[move.getRow()][move.getCol()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < row; i++) {
            sb.append(i + 1);
            sb.append(" ");
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < row; r++) {
            sb.append(r + 1);
            for (Cell cell : field[r]) {
                sb.append(CELL_TO_STRING.get(cell) + " ");
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}
