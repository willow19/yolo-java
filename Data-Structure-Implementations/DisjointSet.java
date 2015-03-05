import java.util.LinkedList;

/**
 * Created by rachit on 06/01/2015.
 */
class DisjointSet {
    LinkedList<DisjointSetNode> set;
    DisjointSetNode representative;
    int size;
    DisjointSetNode head;
    DisjointSetNode tail;
    DisjointSet(LinkedList<DisjointSetNode> l){
        set=l;
        representative=l.getFirst();
        size=l.size();
        head=l.getFirst();
        tail=l.getLast();
    }
    boolean contains(int x){
        return set.contains(x);
    }
}
