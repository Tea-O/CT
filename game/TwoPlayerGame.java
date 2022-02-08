package game;

public class TwoPlayerGame {
    private Board board;
    private Player player1;
    private Player player2;
    private int n;
    private int firstCount;
    private int secondCount;

    public TwoPlayerGame(TicTacToeBoard board, Player player1, Player player2, int firstCount, int secondCount) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.firstCount = firstCount;
        this.secondCount = secondCount;
        this.n = n;
    }




    public int play(boolean log) {
        while (true) {
            if ((firstCount + secondCount) % 2 == 0) {
                final int result1 = makeMove(player1, 1, log);
                if (result1 != -1) {
                    return result1;
                }
                final int result2 = makeMove(player2, 2, log);
                if (result2 != -1) {
                    return result2;
                }
            } else {
                final int result1 = makeMove(player1, 2, log);
                if (result1 != -1) {
                    return result1;
                }
                final int result2 = makeMove(player2, 1, log);
                if (result2 != -1) {

                    return result2;
                }
            }
        }
    }

    private int makeMove(Player player, int no, boolean log) {
        final Move move = player.makeMove(board.getPosition());
        final GameResult result = board.makeMove(move);
        if (log) {
            System.out.println();
            System.out.println("Player: " + no);
            System.out.println(move);
            System.out.println(board);
            System.out.println("Result: " + result);
        }
        switch (result) {
            case WIN:
                return no;
            case LOOSE:
                return 3 - no;
            case DRAW:
                return 0;
            case UNKNOWN:
                return -1;
            default:
                throw new AssertionError("Unknown makeMove result " + result);
        }
    }
}
