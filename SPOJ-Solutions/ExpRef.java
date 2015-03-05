import java.io.PrintStream;

/**
 * Created by rachit on 08/01/2015.
 */
public class ExpRef {
    public static void main(String args[]){
        int i=4;
        int j=i;
        i=5;
        PrintStream ps=new PrintStream(System.out);
        ps.println(j);
        ps.close();
    }
}
