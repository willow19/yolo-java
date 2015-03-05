import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

/**
 * Created by rachit on 08/01/2015.
 */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input){
        reader=new BufferedReader(new InputStreamReader(input));
        tokenizer=new StringTokenizer("");
    }
    static String next() throws IOException{
        while(!tokenizer.hasMoreTokens())
            tokenizer=new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
}
class PALIN {
    public static void main(String args[]) throws IOException, NumberFormatException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Reader.init(System.in);
        int t=Reader.nextInt();
        String in[]=new String[t];

        for(int i=0;i<t;i++){
            in[i]=br.readLine();
        }

        for(int i=0;i<t;i++){
            BigInteger bi=new BigInteger(in[i]);
            bi=bi.add(BigInteger.ONE);
            for(BigInteger bii=bi;;bii= BigInteger.ONE.add(bii)){
                String str=bii.toString();
                StringBuffer strb=new StringBuffer(str);
                StringBuffer strbr=strb.reverse();
                String strbr1=new String(strbr);
                if(str.equals(strbr1)) {
                    in[i]=str;
                    break;
                }
            }
        }

        PrintStream p = new PrintStream(System.out);
        for(int i=0;i<t;i++)
            p.println(in[i]);
        p.close();
    }
}
