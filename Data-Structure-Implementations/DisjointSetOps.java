import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by rachit on 06/01/2015.
 */
public class DisjointSetOps {
    LinkedList<DisjointSetNode> makeSet(int x){
        DisjointSetNode n=new DisjointSetNode();
        n.val=x;
        n.next=null;
        LinkedList<DisjointSetNode> l=new LinkedList<DisjointSetNode>();
        l.add(n);

        return l;
    }
    int findSet(int x,LinkedList<DisjointSetNode>[] S){
        int flag=0;
        int rep=0;
        for (LinkedList<DisjointSetNode> l : S) {
            for(DisjointSetNode nodes : l) {
                if(nodes.val==x) {
                    flag = 1;
                    rep = l.getFirst().val;
                }
            }
        }
        if(flag==0) return 0;
        else return rep;
    }
    LinkedList<DisjointSetNode> union(int x, int y, LinkedList<DisjointSetNode>[] S){
        LinkedList<DisjointSetNode> set1=null;
        LinkedList<DisjointSetNode> set2=null;
        for(LinkedList<DisjointSetNode> l : S) {
            for(DisjointSetNode node : l){
                if(node.val==x) set1=l;
                if(node.val==y) set2=l;
            }
        }
        if(set1.size()>set2.size()){
            ListIterator<DisjointSetNode> it=set2.listIterator();
            while(it.hasNext()) it.next().SetObject=set1.getFirst();
            set1.addAll(set2);
            for(int i=0; i<S.length; i++){
                if(S[i]==set2) S[i]=null;
            }
            return set2;
        }
        else {
            ListIterator<DisjointSetNode> it=set1.listIterator();
            while(it.hasNext()) it.next().SetObject=set2.getFirst();
            set2.addAll(set1);
            for(int i=0; i<S.length; i++){
                if(S[i]==set1) S[i]=null;
            }
            return set2;
        }
    }
}
