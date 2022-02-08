import java.io.IOException;
import java.util.*;
import java.io.*;

public class ReverseAbc2 {

    public static void main(String args[]) {
        try {
            int indexCol = -1;
            int indexStr = -1;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int indexAscii = 97;
            for (int i = 0; i < 10; i++) {
                map.put((char) indexAscii, i);
                indexAscii++;
            }
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
                    int count = 0;
                    String subStr = "";
                    String digit = scStr.nextWord();
                    while (count < digit.length()) {
                        if ((int) digit.charAt(count) == 45) {
                            count++;
                            subStr += (char) 45;
                        } else {
                            subStr += Integer.toString(map.get(digit.charAt(count)));
                            count++;
                        }
                    }
                    arr[indexStr][indexCol] = Integer.parseInt(subStr);
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
/*
import java.io.IOException;
import java.util.*;
import java.io.*;

public class ReverseAbc2 {

    public static void main(String args[]) {
        try {
            int indexCol = -1;
            int indexStr = -1;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int indexAscii = 97;
            for (int i = 0; i < 10; i++) {
                map.put((char) indexAscii, i);
                indexAscii++;
            }
            FScanner sc = new FScanner(System.in);
            int[][] arr = new int[50000][50000];
            while (sc.hasNextLine()) {
                FScanner scStr = new FScanner(sc.nextLine());
                indexStr++;
                if (arr.length <= indexStr) {
                    arr = Arrays.copyOf(arr, arr.length * 2);
                }
                arr[indexStr] = new int[50000];
                while (scStr.hasNext()) {
                    indexCol++;
                    if (arr[indexStr].length <= indexCol) {
                        arr[indexStr] = Arrays.copyOf(arr[indexStr], arr[indexStr].length * 2);
                    }
                    int count = 0;
                    String subStr = "";
                    String digit = scStr.nextWord();
                    while (count < digit.length()) {
                        if ((int) digit.charAt(count) == 45) {
                            count++;
                            subStr += (char) 45;
                        } else {
                            subStr += Integer.toString(map.get(digit.charAt(count)));
                            count++;
                        }
                    }
                    arr[indexStr][indexCol] = Integer.parseInt(subStr);
                }
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

 */