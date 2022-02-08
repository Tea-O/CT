import java.io.IOException;
import java.util.*;
import java.io.*;

public class Reverse {

    public static void main(String args[]) {
        try {
            int indexCol = -1;
            int indexStr = -1;
            FScanner sc = new FScanner(System.in);
            int[][] arr = new int[50][15];
            while (sc.hasNextLine()) {
                FScanner scStr = new FScanner(sc.nextLine());
                indexStr++;
                if (arr.length <= indexStr) {
                    arr = Arrays.copyOf(arr, arr.length * 2);
                }
                arr[indexStr] = new int[5];
                while (scStr.hasNext()) {
                    indexCol++;
                    if (arr[indexStr].length <= indexCol) {
                        arr[indexStr] = Arrays.copyOf(arr[indexStr], arr[indexStr].length * 2);
                    }
                    String digit = scStr.nextToken();
                    arr[indexStr][indexCol] = Integer.parseInt(digit);
                }
                arr[indexStr] = Arrays.copyOf(arr[indexStr], indexCol + 1);
                indexCol = -1;
                scStr.close();
            }
            sc.close();
            for (int i = indexStr; i >= 0; i--) {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.print("Input or Output error" + e.getMessage());
        }
    }
}
