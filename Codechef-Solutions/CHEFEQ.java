import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by rachit on 10/02/2015.
 */
class Reader {
    static StringTokenizer tokenizer;
    static BufferedReader reader;
    static void init(InputStream stream) {
        reader=new BufferedReader(new InputStreamReader(stream));
        tokenizer=new StringTokenizer("");
    }
    static String next() throws IOException{
        while(!tokenizer.hasMoreTokens())
            tokenizer=new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
class CHEFEQ {
    public static void main(String args[]) throws IOException {
        Reader.init(System.in);
        PrintStream p=new PrintStream(System.out);

        int t=Reader.nextInt();
        int out[]=new int[t];
        for(int i=0;i<t;i++) {

            int n=Reader.nextInt();
            int A[] = new int[n];
            int min = 0;
            int max = 0;
            out[i] = 0;

            for (int j = 0; j < n; j++) {
                A[j]=Reader.nextInt();

                if (min == 0) min = A[j];
                else if (A[j] < min) min = A[j];

                if (A[j] > max) max = A[j];
            }

            for (int j = min; j <= max; j++) {
                int temp = 0;
                for (int k = 0; k < n; k++) {
                    if (A[k] != j) temp++;
                }
                if (out[i] == 0) out[i] = temp;
                else if (temp < out[i]) out[i] = temp;
            }
        }
        for(int i=0;i<t;i++) {
            p.println(out[i]);
        }
        p.close();
    }
}
