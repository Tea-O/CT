import java.io.*;
import java.lang.Character;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.lang.NumberFormatException;
import java.nio.charset.StandardCharsets;

public class FScanner {

    private BufferedReader in = null;
    public char[] buffer = new char[4092];
    private int countLines = 1;
    String str = "";
    int bufferlen = 0;
    int index;
    StringBuilder line = new StringBuilder();

    public FScanner(InputStream in) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.bufferlen = this.in.read(buffer);
    }

    public FScanner(String str) throws IOException {
        this.bufferlen = str.length();
        this.buffer = str.toCharArray();
    }

    public FScanner(String fileName, String encoding)
            throws UnsupportedEncodingException, FileNotFoundException, IOException {
        this.in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), encoding));
        this.bufferlen = this.in.read(buffer);
    }

    private boolean isWord(Character ch) {
        return (Character.isLetter(ch) || Character.getType(ch) == Character.DASH_PUNCTUATION || ch == '\'');
    }

    private void bufferReplenishment() throws IOException {
        this.bufferlen = this.in.read(buffer);
        index = 0;
    }

    public boolean hasNextWord() throws IOException {
        while (true) {
            if (bufferlen == -1) {
                return false;
            }
            for (; index < bufferlen; index++) {
                if (buffer[index] == '\n') {
                    countLines++;
                }
                if (isWord(buffer[index])) {
                    return true;
                }
            }
            if (in == null) {
                return false;
            }
            bufferReplenishment();
        }
    }

    public boolean hasNext() throws IOException {
        while (true) {
            if (bufferlen == -1) {
                return false;
            }
            for (; index < bufferlen; index++) {
                if (buffer[index] == '\n') {
                }
                if (isWord(buffer[index]) || !Character.isWhitespace(buffer[index])) {
                    return true;
                }
            }
            if (in == null) {
                return false;
            }
            bufferReplenishment();
        }
    }

    public boolean hasNextLine() throws IOException {
        if (index >= bufferlen) {
            if (in == null) {
                return false;
            }
            bufferReplenishment();
        }
        if (bufferlen == -1) {
            return false;
        } else {
            return true;
        }
    }

    private String next(String lastToken) throws IOException {
        StringBuilder token = new StringBuilder(lastToken);
        for (; index < bufferlen; index++) {
            if (isWord(buffer[index]) || !"".equals(lastToken)) {
                break;
            }
        }
        for (; index < bufferlen; index++) {
            if (!isWord(buffer[index])) {
                return token.toString();
            }
            token.append(buffer[index]);
        }
        if (in != null && bufferlen != -1) {
            bufferReplenishment();
            return next(token.toString());
        } else {
            return token.toString();
        }
    }

    public String nextWord() throws IOException {
        return next("");
    }

    public String nextLine() throws IOException {
        while (true) {
            if (index >= bufferlen) {
                index = 0;
                this.bufferlen = this.in.read(buffer);
            }
            for (; index < bufferlen; index++) {
                if (buffer[index] == '\n') {
                    index++;
                    str = line.toString();
                    line = new StringBuilder("");
                    return str;
                }
                line.append(buffer[index]);
            }
            bufferReplenishment();
        }
    }

    public String nextToken() throws IOException {

        StringBuilder token = new StringBuilder("");
        for (; index < bufferlen; index++) {
            if (Character.isWhitespace(buffer[index])) {
                return token.toString();
            }
            token.append(buffer[index]);
        }
        return token.toString();
    }

    public Integer linePosition() throws IOException {
        return countLines;
    }

    public void close() throws IOException {
        if (in != null) {
            in.close();
        }
    }
}
