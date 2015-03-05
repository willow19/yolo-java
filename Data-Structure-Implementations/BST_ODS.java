interface IntBST {
    int size();
    boolean add(int x);
}

class Node {
    Node left;
    Node right;
    Node parent;
    int x;

    Node(int x) {
        this.left=null;
        this.right=null;
        this.parent=null;
        this.x=x;
    }
}

class BST implements IntBST {
    Node r;

    public int size() {
        Node u=r, prev=null, next;
        int n=0;
        while(u!=null) {
            if(prev==u.parent) {
                n++;
                if(u.left!=null) next=u.left;
                else if(u.right!=null) next=u.right;
                else next=u.parent;
            }
            else if(prev==u.left) {
                if(u.right!=null) next=u.right;
                else next=u.parent;
            }
            else next=u.parent;
            prev=u;
            u=next;
        }
        return n;
    }

    public boolean add(int x) {
        Node p=findLast(x);
        return addChild(p, new Node(x));
    }

    Node findLast(int x){
        Node w=r, prev=null;
        while(w!=null) {
            prev=w;
            int comp=Integer.compare(x, w.x);
            if(comp<0) w=w.left;
            else if(comp>0) w=w.right;
            else return w;
        }
        return prev;
    }

    boolean addChild(Node p, Node u) {
        if(p==null) r=u;
        else {
            int comp=Integer.compare(u.x, p.x);
            if(comp<0) p.left=u;
            else if(comp>0) p.right=u;
            else return false;
            u.parent=p;
        }
        return true;
    }
}

class Example {
    public static void main(String args[]){
        BST b1=new BST();
        b1.add(5);
        b1.add(3);
        b1.add(6);
        System.out.println(b1.size());
        System.out.println(b1.r.right.x);
    }
}