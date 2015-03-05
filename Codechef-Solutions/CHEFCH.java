import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by rachit on 9/2/15.
 */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream stream) {
        reader=new BufferedReader(new InputStreamReader(stream));
        tokenizer=new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

}
class CHEFCH {
    public static void main(String args[]) throws IOException {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        PrintStream p=new PrintStream(System.out);
        //Reader.init(System.in);
        //int t=Reader.nextInt();
        int t=sc.nextInt();

        String in[]=new String[t];
        int min[]=new int[t];

        for(int i=0;i<t;i++) {
            in[i]=sc.next();
            //in[i]=in[i].trim();
        }

        for(int j=0;j<t;j++) {
            int l = in[j].length();
            min[j] = 0;
            int temp = 0;

            if (l != 1) {
                char ch[] = in[j].toCharArray();

                boolean bo[] = new boolean[l];
                boolean bo1[] = new boolean[l];
                for (int i = 0; i < l; i++) {
                    if (ch[i] == '+') {bo[i] = true; bo1[i]=bo[i];}
                    else if (ch[i] == '-') {bo[i] = false; bo1[i]=bo[i];}
                }

                boolean b1 = false;
                if (bo1[0]) {
                    bo1[0] = !bo1[0];
                    min[j]++;
                }

                for (int i = 1; i < l; i++) {
                    if (bo1[i] == b1) {
                        bo1[i] = !b1;
                        min[j]++;
                    }
                    b1 = bo1[i];
                }

                //if first is '+'

                bo1 = bo;
                b1 = true;
                if (!bo1[0]) {
                    bo1[0] = !bo1[0];
                    temp++;
                }
                for (int i = 1; i < l; i++) {
                    if (bo1[i] == b1) {
                        bo1[i] = !b1;
                        temp++;
                    }
                    b1 = bo1[i];
                }

                if (temp < min[j])
                    min[j] = temp;
            }
            else min[j]=temp;
        }

        for(int j=0;j<t;j++) {
            p.println(min[j]);
        }

        p.close();
    }
}
