import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class Wspp {

    public static void main(String[] args) {
        int countWord = 0;
        int countLine = 0;
        Map<String, List<Integer>> map = new LinkedHashMap<String, List<Integer>>();
        try {
            FScanner in = new FScanner(args[0], "utf-8");
            try {
                while (in.hasNextWord()) {
                    countLine = in.linePosition();
                    String key = in.nextWord().toLowerCase();
                    countWord++;
                    //System.err.println(countLine);
                    boolean keycheck = map.containsKey(key);
                    if (keycheck) {
                        map.get(key).add(countWord);
                        //System.err.print(key);
                        //System.err.println(map.get(key));
                    } else {
                        List<Integer> newWord = new ArrayList<>();
                        newWord.add(countWord);
                        map.put(key, newWord);
                    }
                }
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(args[1]),
                                "utf8"
                        )
                );
                try {
                    for (String k : map.keySet()) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < map.get(k).size(); i++) {

                            int num = map.get(k).get(i);
                            sb.append(" ");
                            sb.append(num);
                        }
                        String result = sb.toString();
                        out.write(k + " " + map.get(k).size() + result);
                        out.write("\n");
                    }
                } finally {
                    out.close();
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find input.txt: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read input.txt: " + e.getMessage());
        }
    }
}