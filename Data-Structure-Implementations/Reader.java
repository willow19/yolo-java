import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by rachit on 06/01/2015.
 */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input){
        reader=new BufferedReader(new InputStreamReader(input));
        tokenizer=new StringTokenizer("");
    }

    static String next() throws IOException {
        while(!tokenizer.hasMoreTokens()){
            tokenizer=new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}
