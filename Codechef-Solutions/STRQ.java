import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rachit on 10/02/2015.
 */
class Reader1 {
    static StringTokenizer tokenizer;
    static BufferedReader reader;
    static void init(InputStream stream) {
        reader=new BufferedReader(new InputStreamReader(stream));
        tokenizer=new StringTokenizer("");
    }
    static String next() throws IOException {
        while(!tokenizer.hasMoreTokens())
            tokenizer=new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
class STRQ { //now if the required substring gets stuck 'inside' a reluctant match???- there may be many instances of the sunstring in there
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintStream p = new PrintStream(System.out);
        Scanner sc=new Scanner(System.in);
        Reader1.init(System.in);
        DataInputStream stream1=new DataInputStream(System.in);

        String str=sc.next();
        int t=sc.nextInt();

        int sum[]=new int[t];

        for(int i=0;i <t; i++) {
            //String in = sc.next();

            //String in1[]=new String[4];

            //in1 = in.split(" ");
            //char ch1=(char)stream1.readByte(); char ch=(char)stream1.readByte(); char ch2=(char)stream1.readByte(); ch=(char)stream1.readByte();
            //int st=sc.nextInt(); ch=(char)stream1.readByte(); int en=sc.nextInt();
            char ch1=sc.next(".").toCharArray()[0];
            char ch2=sc.next(".").toCharArray()[0];
            int st=sc.nextInt(); int en=sc.nextInt();
            int j=0;
           /* p.println(ch1);
            p.println(ch2);
            p.println(st);
            p.println(en);
            while(j!=4) {
                if(j==0) {
                    ch1 = (char) br.read();
                    ch=(char) br.read();
                }
                else if(j==1) {
                    ch2 = (char) br.read();
                    ch=(char) br.read();
                }
                else if(j==2)
                    st=sc.nextInt();
                else if(j==3)
                    en=sc.nextInt();
                j++;
            }*/


            int count = 0;
            sum[i]=0;
            int internalStrings=0;
            int lastIndex=0; //lastIndex denotes the last index of ch2 where reluctant match succeeded


            String substr = str.substring(st-1, en);

            Pattern pattern1 = Pattern.compile(ch1 + ".*?" + ch2);

            Matcher matcher1 = pattern1.matcher(substr);


            /*while (matcher1.find()) {
                count++;
                Matcher matcher2 = pattern1.matcher(matcher1.group().substring(1));
                if(matcher2.find()) internalStrings++;
                sum[i] = sum[i]+count+internalStrings;
                lastIndex=matcher1.end();
            }*/
            while(matcher1.find()) {
                count++;
                char ch76[]=matcher1.group().toCharArray();
                for(int r=1;r< matcher1.group().length();r++) {
                    if(ch76[r]==ch1) internalStrings++;
                }
                sum[i]=sum[i]+count+internalStrings;
                lastIndex=matcher1.end();
            }
            Pattern pattern2=Pattern.compile(ch2+"");
            Matcher matcher2=pattern2.matcher(substr.substring(lastIndex));
            while(matcher2.find())
                sum[i]=sum[i]+count+internalStrings;
        }

        for(int i=0; i<t; i++)
            p.println(sum[i]);

        p.close();
    }
}