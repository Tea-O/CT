package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row, col, k, n;
        System.out.println("Введите параметры игры");
        row = sc.nextInt();
        col = sc.nextInt();
        k = sc.nextInt();
        n = sc.nextInt();
        int firstCount = 0;
        int secondCount = 0;

        System.out.println("Ведите тип игроков");
        Player firstPlayer = new RandomPlayer(row, col);
        Player secondPlayer = new RandomPlayer(row, col);
        String playerTip = sc.next();
        if (playerTip.equals("Random")) {
            firstPlayer = new RandomPlayer(row, col);
        } else if (playerTip.equals("Human")) {
            firstPlayer = new HumanPlayer(new Scanner(System.in));
        } else if (playerTip.equals("Sequential")) {
            firstPlayer = new SequentialPlayer(row, col);
        } else if (playerTip.equals("Cheating")) {
            firstPlayer = new CheatingPlayer(row, col, k);
        }
        playerTip = sc.next();
        if (playerTip.equals("Random")) {
            secondPlayer = new RandomPlayer(row, col);
        } else if (playerTip.equals("Human")) {
            secondPlayer = new HumanPlayer(new Scanner(System.in));
        } else if (playerTip.equals("Sequential")) {
            secondPlayer = new SequentialPlayer(row, col);
        } else if (playerTip.equals("Cheating")) {
            secondPlayer = new CheatingPlayer(row, col, k);
        }


        while (firstCount < n && secondCount < n) {
            final int result = new TwoPlayerGame(
                    new TicTacToeBoard(row, col, k),
                    firstPlayer,
                    secondPlayer,
                    firstCount, secondCount
                    //                new HumanPlayer(new Scanner(System.in))
            ).play(true);
            switch (result) {
                case 1:
                    firstCount++;
                    System.out.println("В этой игре выйграл 1 игрок");
                    break;
                case 2:
                    secondCount++;
                    System.out.println("В этой игре выйграл 2 игрок");
                    break;
                case 0:
                    System.out.println("Ничия");
                    break;
                default:
                    throw new AssertionError("Unknown result " + result);
            }
        }
        if (firstCount == n) {
            System.out.println("В матче выйграл 1 игрок");
        } else {
            System.out.println("В матче выйграл 2 игрок");
        }
    }
}
