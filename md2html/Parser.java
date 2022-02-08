package md2html;

import java.io.*;
import java.util.*;

public class Parser {

    private int position;
    StringBuilder sb = new StringBuilder();;

    public Parser(String st) {
        position = 0;
        int headerСount = 0;
        while (st.charAt(headerСount) == '#' && headerСount < st.length()) {
            headerСount++;
            position++;
        }
        if (st.charAt(headerСount) == ' ' && headerСount > 0) {
            sb.append("<h").append(headerСount).append(">");
            position++;
        } else {
            headerСount = 0;
            position = 0;
        }
        if (headerСount == 0) {
            sb.append("<p>");
        }
        mapToHashMap(map);
        simbolsCounter(st, position);
        mainParser(st, position);
        if (headerСount == 0) {
            sb.append("</p>");
        } else {
            sb.append("</h").append(headerСount).append(">");
        }
    }

    private Map<String, String> simbols = Map.of("`", "code", "*", "em",
            "**", "strong", "__", "strong", "--", "s", "_", "em",
            "-", "d", "%", "var");

    private Map<String, String> htmlSimbols = Map.of("<", "&lt;", ">", "&gt;", "&", "&amp;");

    private Map<String, Integer> simbolsCount = Map.of("`", 0, "*", 0,
            "**", 0, "__", 0, "--", 0, "_", 0,
            "<", 0, ">", 0, "&", 0, "%", 0);

    private Map<String, Integer> map = new HashMap<String, Integer>();

    public void mapToHashMap(Map mp) {
        for (String key : simbolsCount.keySet()) {
            map.put(key, simbolsCount.get(key));
        }
    }

    public void simbolsCounter(String st, int position) {
        int locPosition = position;
        while (st.length() > locPosition) {
            if (st.charAt(locPosition) == '\\') {
                locPosition += 2;
            } else {
                String sub = st.substring(locPosition, locPosition + 1);
                if (map.containsKey(sub) || sub.equals("-")) {
                    if (locPosition + 1 < st.length() && st.charAt(locPosition + 1) == st.charAt(locPosition)) {
                        String sim = st.substring(locPosition, locPosition + 2);
                        map.put(sim, map.get(sim) + 1);
                        locPosition++;
                    } else {
                        if (!sub.equals("-")) {
                            map.put(sub, map.get(sub) + 1);
                        }
                    }
                }
                locPosition++;
            }
        }


        for (String key : map.keySet()) {
            if (map.get(key) % 2 == 1 && !htmlSimbols.containsKey(key)) {
                map.put(key, map.get(key) - 1);
            }
        }
    }

    public StringBuilder mainParser(String st, int position) {
        while (st.length() > position) {
            if (st.charAt(position) == '\\') {
                position++;
                sb.append(st.charAt(position));
                position++;
            } else {
                String sub = st.substring(position, position + 1);
                if (position + 1 < st.length() && st.charAt(position + 1) == st.charAt(position)
                        && (map.containsKey(sub) || sub.equals("-"))) {
                    String sim = st.substring(position, position + 2);
                    if (map.get(sim) > 0) {
                        if (map.get(sim) % 2 == 0) {
                            sb.append("<").append(simbols.get(sim)).append(">");
                            map.put(sim, map.get(sim) - 1);
                        } else {
                            sb.append("</").append(simbols.get(sim)).append(">");
                            map.put(sim, map.get(sim) - 1);
                        }
                        position++;
                    }
                } else if (htmlSimbols.containsKey(sub) || sub.equals("-")) {
                    if (htmlSimbols.containsKey(sub)) {
                        sb.append(htmlSimbols.get(sub));
                    } else {
                        sb.append("-");
                    }
                } else if (map.containsKey(sub) && map.get(sub) > 0) {
                    String sim = st.substring(position, position + 1);
                    if (map.get(sim) % 2 == 0) {
                        sb.append("<").append(simbols.get(sim)).append(">");
                        map.put(sim, map.get(sim) - 1);
                    } else {
                        sb.append("</").append(simbols.get(sim)).append(">");
                        map.put(sim, map.get(sim) - 1);
                    }

                } else {
                    sb.append(st.charAt(position));
                }
                position++;
            }
        }
        return sb;
    }

    public String out() {
        return sb.toString();
    }
}
