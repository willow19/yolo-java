import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
//import java.util.Scanner;

/**
 * Created by rachit on 6/2/15.
 */
class JULKA {
    public static void main(String args[]) throws IOException {
        //Scanner in = new Scanner(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintStream p = new PrintStream(System.out);

        /*BigInteger a[],b[];
        a=new BigInteger[10];
        b=new BigInteger[10];*/
        String a[]=new String[10];
        String b[]=new String[10];

        for(int i=0;i<10;i++) {
            a[i] = br.readLine();
            b[i] = br.readLine();
        }

        for(int i=0;i<10;i++) {
            BigInteger x,y;
            x=new BigInteger(a[i]);
            y=new BigInteger(b[i]);
            p.println(x.add(y).divide(new BigInteger("2")));
            p.println(x.subtract(y).divide(new BigInteger("2")));
        }
        p.close();
    }
}
