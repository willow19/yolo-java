import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by rachit on 08/01/2015.
 */
class Reader{
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
class FACEFRND {
    public static void main(String args[]) throws IOException {
        Set<Integer> friendOfFriends = new HashSet<Integer>();
        Set<Integer> friends =new HashSet<Integer>();
        Reader.init(System.in);
        int t = Reader.nextInt();

        for(int i=0;i<t;i++){
            int friend=Reader.nextInt();
            friends.add(friend);
            int nFriendOfFriend=Reader.nextInt();
            for(int j=0;j<nFriendOfFriend;j++){
                int in=Reader.nextInt();
                friendOfFriends.add(in);
            }
        }

        for(int fr:friends)
            if(friendOfFriends.contains(fr))
                friendOfFriends.remove(fr);

        PrintStream p =new PrintStream(System.out);
        p.println(friendOfFriends.size());
        p.close();
    }
}
