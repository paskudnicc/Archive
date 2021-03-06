import java.io.*;
import java.util.*;

public class Reverse {
    public static void main(String[] args) throws IOException {
        CustomScanner in = new CustomScanner(System.in);
        StringBuilder r = new StringBuilder("");
        boolean first = true;
        while (in.hasNextLine()) {
            if (first) {
                first = false;
            } else {
                r.append(new StringBuilder("\n"));
            }
            CustomScanner lil_in = new CustomScanner(in.nextLine());
            while (true) {
                int t;
                try {
                    t = lil_in.nextInt();
                } catch (Exception e) {
                    break;
                }
                r.append(new StringBuilder(" " + t).reverse());
                // EZ EVEN MOD HERE
            }
        }
        System.out.println(r.reverse().toString());
    }

    static class CustomScanner {
        private BufferedReader reader;
        private int bufLen = 2048;
        private char[] buffer = new char[bufLen];
        private int len, pos;
        private boolean EOF = false;

        public CustomScanner(InputStream inputstream) {
            reader = new BufferedReader(new InputStreamReader(inputstream));
        }

        public CustomScanner(String string) {
            reader = new BufferedReader(new StringReader(string));
        }

        public CustomScanner(File file) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(file));
        }

        private void readBuffer() throws IOException {
            len = reader.read(buffer);
            while (len == 0) {
                len = reader.read(buffer);
            }
            if (len == -1) {
                EOF = true;
            }
            pos = 0;


        }

        public boolean hasNextLine() throws IOException {
            return hasNextChar();
        }

        public char nextChar() throws IOException {
            if (pos >= len) {
                readBuffer();
            }
            return buffer[pos++];
        }

        public boolean hasNextChar() throws IOException {
            nextChar();
            pos--;
            return !EOF;
        }

        public String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            char c;
            while (hasNextChar()) {
                c = nextChar();
                String l = System.lineSeparator();
                if (c == '\n' || c == '\r') {
                    break;
                }
                sb.append(c);
            }
            return sb.toString();
        }

        private void skipBlank() throws IOException {
            while (hasNextChar() && Character.isWhitespace(nextChar())) ;
            pos--;
        }

        public String next() throws IOException {
            skipBlank();
            StringBuilder sb = new StringBuilder();
            char c;
            while (hasNextChar()) {
                c = nextChar();
                if (!Character.isWhitespace(c)) {
                    sb.append(c);
                } else break;
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public byte nextByte() throws IOException {
            return Byte.parseByte(next());
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

        public float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }
    }
}

