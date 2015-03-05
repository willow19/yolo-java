import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph {
    int n;
    List<Integer>[] adj;
    Graph(int n0){
        n=n0;
        adj=(List<Integer>[])new List[n];
        for(int i=0;i<n;i++)
            adj[i]=new Stack<Integer>();
    }

    void addEdge(int i,int j){
        adj[i].add(j);
        n++;
    }

    void removeEdge(int i,int j){
        adj[i].remove(adj[i].indexOf(j));
        n--;
    }

    boolean hasEdge(int i,int j){
        return adj[i].contains(j);
    }

    List<Integer> outEdges(int i){
        return adj[i];
    }

    List<Integer> inEdges(int i){
        List<Integer> result=new ArrayList<Integer>();
        for(int j=0;j<n;j++){
            if(adj[j].contains(i))
                result.add(j);
        }
        return result;
    }

    int nVertices(){
        return n;
    }
}
