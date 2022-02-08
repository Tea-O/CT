package md2html;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Md2Html {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(args[0]),
                            StandardCharsets.UTF_8
                    )
            );

            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(args[1]),
                            StandardCharsets.UTF_8
                    )
            );
            try {
                StringBuilder str = new StringBuilder();
                String st = in.readLine();
                while (st != null) {
                    while (st.isEmpty()) {
                        st = in.readLine();
                    }
                    while (st != null && !st.isEmpty()) {
                        if (!str.isEmpty()) {
                            str.append(System.lineSeparator());
                        }
                        str.append(st);
                        st = in.readLine();
                    }
                    if (str.length() > 0) {
                        Parser ans = new Parser(str.toString());
                        out.write(ans.out());
                        out.newLine();
                    }
                    str.delete(0, str.length());
                }
            } finally {
                in.close();
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find input.txt: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read input.txt: " + e.getMessage());
        }
    }
}
