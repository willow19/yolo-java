/**
 * Created by rachit on 19/01/2015.
 */
class Node{
    Node p;
    Node left;
    Node right;
    int key;
}
class Tree{
    Node root;
}
class BST {
    static Node search(Node x, int k){
        while(x!=null && k!=x.key){
            if(k<x.key) x=x.left;
            else x=x.right;
        }
        return x;
    }
    static Node treeMinimum(Node x){
        while(x.left!=null)
            x=x.left;
        return x;
    }
    static Node treeMaximum(Node x){
        while(x.right!=null)
            x=x.right;
        return x;
    }
   static Node treeSuccessor(Node x){
        if(x.right!=null) return treeMinimum(x.right);
        Node y=x.p;
        while(y!=null && x==y.right){
            x=y;
            y=y.p;
        }
        return y;
    }
    static Node treeRoot(Tree T){
        return T.root;
    }
    static void treeInsert(Tree T ,Node z){
        Node y=null;
        Node x=T.root;
        while(x!=null){
            y=x;
            if(z.key<x.key) x=x.left;
            else x=x.right;
        }
            z.p=y;
            if(y==null) T.root=z;
            else if (z.key<y.key) y.left=z;
            else y.right=z;
    }
    public static void main(String args[]){
        Tree T=null;
        T.root=null;

        Node z;
        z.right=null;
        z.left=null;
        z.p=null;
        z.key=3;
        treeInsert(T,z);

        z.right=null;
        z.left=null;
        z.p=null;
        z.key=7;
        treeInsert(T,z);

        z.right=null;
        z.left=null;
        z.p=null;
        z.key=2;
        treeInsert(T,z);

        z.right=null;
        z.left=null;
        z.p=null;
        z.key=5;
        treeInsert(T,z);

        z.right=null;
        z.left=null;
        z.p=null;
        z.key=10;
        treeInsert(T,z);

        Node x=treeMinimum(treeRoot(T));
        System.out.println(x.key);
    }
}
