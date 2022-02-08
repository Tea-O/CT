import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class WsppPosition {

    public static void main(String[] args) {
        int countWord = 0;
        int countWordLine = 0;
        int countLine = 0;
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        try {
            FScanner in = new FScanner(args[0], "utf-8");
            try {
                while (in.hasNextWord()) {
                    if (in.linePosition() > countLine) {
                        countWordLine = 0;
                    }
                    countWordLine++;
                    countLine = in.linePosition();
                    String key = in.nextWord().toLowerCase();
                    countWord++;
                    boolean keycheck = map.containsKey(key);
                    if (keycheck) {
                        map.get(key).add(Integer.toString(countLine) + ':' + Integer.toString(countWordLine));
                    } else {
                        List<String> newWord = new ArrayList<>();
                        newWord.add(Integer.toString(countLine) + ':' + Integer.toString(countWordLine));
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
                            String num = map.get(k).get(i);
                            //System.err.println(k);
                            //System.err.println(map.get(k));
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