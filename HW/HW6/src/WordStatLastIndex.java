import java.io.*;
import java.util.*;
public class WordStatLastIndex {

    public static final String UTF_8 = "utf8";

    public static void main(String[] args) {
        try {
            MyScannerFast scan = new MyScannerFast(new File(args[0]));
            Map<String, IntList> wordcur = new LinkedHashMap<>();
            int line = 0;
            while (scan.hasNextLine()) {
                line++;
                int count = 0;
                Map<String, Boolean> wordbe = new HashMap<>();
                while(scan.hasNextinLine()) {
                    String num = scan.readNextWord().toLowerCase();
                    if (num.length() > 0) {
                        ++count;
                        IntList wordlist = wordcur.getOrDefault(num, new IntList());
                        if (wordlist.size() == 0) {
                            wordlist.add(0);
                            wordlist.add(count);
                        }
                        else {
                            if (wordbe.containsKey(num)) {
                                wordlist.remove();
                                System.out.println();
                            }
                            wordlist.add(count);
                        }
                        wordlist.set(0, wordlist.get(0) + 1);
                        wordbe.put(num, true);
                        wordcur.put(num, wordlist);
                    }
                }
            }
            try {
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream(new File(args[1])),
                                        UTF_8
                                ),
                                1024
                        )
                );
                try {
                    for (Map.Entry<String, IntList> print : wordcur.entrySet()) {
                        out.print(print.getKey());
                        IntList io = print.getValue();
                        for (int j = 0; j < io.size(); ++j)
                            out.print(" " + io.get(j));
                        out.println();
                    }

                } finally {
                    out.close();
                }
            } finally {
                scan.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }

    }
}
 class MyScannerFast {
    public static final String UTF_8 = "utf8";
    static String buf;
    static Reader reader;
    static boolean isInt;
    static boolean isRead = false;
    static enum State {
        EOF, EOL, SPACE, SYMBOL;
    }
    static State state = State.SYMBOL;
    MyScannerFast(Reader s){
        reader = s;
        state = State.SYMBOL;
    }
    MyScannerFast(InputStream s){
        reader = new InputStreamReader(s);
        state = State.SYMBOL;
    }
    MyScannerFast(File u){
        try{
            reader = new InputStreamReader(new FileInputStream(u), UTF_8);
            state = State.SYMBOL;
        }	catch (FileNotFoundException e) {
            System.err.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
    public static void close(){
        try {
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
    public static boolean hasNextLine() {
        boolean f = (state != State.EOF);
        if (f) {
            state = State.SYMBOL;
        }
        return f;
    }
    public static boolean hasNextinLine() {
        return state != State.EOF && state != State.EOL;
    }
    public static String readNextLine() throws IOException{
        StringBuilder ans = new StringBuilder();
        state = State.SYMBOL;
        while(state == State.SYMBOL) {
            int h = reader.read();
            if (h != -1 && h != '\n') {
                ans.append((char)h);
            }
            else if (h == -1) {
                state = State.EOF;
            } else if (h == '\n')
            {
                state = State.EOL;
            }
        }
        return ans.toString();
    }
    public static void readNext() throws IOException{
        StringBuilder ans = new StringBuilder();
        state = State.SYMBOL;
        while(state == State.SYMBOL) {
            int h = reader.read();
            if (h != -1 && (Character.isDigit((char)h) || (char)h == '-')) {
                ans.append((char)h);
            }
            else if (h == -1) {
                state = State.EOF;
            } else if (h == '\n')
            {
                state = State.EOL;
            } else {
                state = State.SPACE;
            }
        }
        //System.out.println(ans.length());
        if (ans.length() > 0) {
            isInt = true;
            buf = ans.toString();
            isRead = true;
        } else {
            isInt = false;
            isRead = false;
        }
    }
    public static int readNextInt() throws IOException{
        if (!isRead) {
            readNext();
        }
        isRead = false;
        return Integer.parseInt(buf);
    }
    public static boolean hasNextInt() throws IOException{
        readNext();
        return isInt;
    }
    public static boolean isSymbol(char h) {
        return (Character.isAlphabetic(h) ||
                (h == '\'') ||
                (Character.DASH_PUNCTUATION == Character.getType(h)));
    }
    public static String readNextWord() throws IOException{
        StringBuilder ans = new StringBuilder();
        state = State.SYMBOL;
        while(state == State.SYMBOL) {
            int h = reader.read();
            if (h != -1 && isSymbol((char)h)) {
                ans.append((char)h);
            }
            else if (h == -1) {
                state = State.EOF;
            } else if (h == '\n')
            {
                state = State.EOL;
            } else {
                state = State.SPACE;
            }
        }
        return ans.toString();
    }
}
class IntList {
    int[] array;
    int size;
    public IntList() {
        array = new int[2];
        size = 0;
    }
    public void add(int x) {
        if (array.length == size) {
            array =  Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size] = x;
        size++;
    }
    public void set(int index, int x) {
        array[index] = x;
    }
    public int get(int index) {
        return array[index];
    }
    public void remove() {
        size--;
    }
    public int size() {
        return size;
    }
}
