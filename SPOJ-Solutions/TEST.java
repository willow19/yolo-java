import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * Created by rachit on 08/01/2015.
 */
class Reader{
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream stream){
        reader=new BufferedReader(new InputStreamReader(stream));
        tokenizer=new StringTokenizer("");
    }
    static String next() throws IOException{
        while(!tokenizer.hasMoreTokens())
            tokenizer=new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }
    static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
}
class TEST {
    public static void main(String args[]) throws IOException{
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int n;
        Reader.init(System.in);
        do {
            n = Reader.nextInt();
            deque.add(n);
        }while (n != 42);
        deque.removeLast();
        PrintStream p=new PrintStream(System.out);
        for(int a:deque)
            p.println(a);
        p.close();
    }
}