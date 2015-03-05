/**
 * Created by rachit on 2/2/15.
 */
interface IBST_Cor {
    int size();
    void addElt(int elt);
    void remElt(int elt);

}
class BST_Cor implements IBST_Cor {
    Node r;

    public int size() {
        int n=0;
        Node u=this.r, next, prev=null;
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

    public void addElt(int elt) {
        Node y=null;
        Node z=this.r;
        while(z!=null) {
            y=z;
            if(elt<z.x) z=z.left;
            else z=z.right;
        }
        z=new Node(elt);
        z.parent=y;
        if(y==null) this.r=z;
        else if(y.x<z.x) y.right=z;
        else y.left=z;
    }

    public void transplant(Node p, Node q) { //Add root case and check for q!=null
        if(p.parent==null)
            this.r=q;
        else if(p==p.parent.right)
            p.parent.right=q;
        else
            p.parent.left=q;
        if(q!=null)
            q.parent=p.parent;
    }

    public void remElt(int elt) {
        Node y=this.r;
        while(y.x!=elt) {
            if(y.x<elt) y=y.right;
            else y=y.left;
        }
        if(y.right==null) {
            transplant(y,y.left);
        }
        else if(y.left==null) {
            transplant(y,y.right);
        }
        else {
            Node z=Tree_Minimum(y.right);
            if(z.parent!=y) {
                transplant(z, z.right);
                z.right.parent=y;
                z.right=y.right;
            }
            transplant(y, z);
            z.left=y.left;
            z.left.parent=y;
        }
    }

    public Node Tree_Minimum(Node t) {
        while(t!=null && t.left!=null) {
            t=t.left;
        }
        return t;
    }

    public Node Tree_Maximum(Node t) {
        while(t!=null && t.right!=null) {
            t=t.right;
        }
        return t;
    }

    public Node Successor(Node t) {
        if(t.right!=null)
            return Tree_Minimum(t.right);

        Node y=t.parent;
        while(y.right==t) {
            t=y;
            y=y.parent;
        }
        return y;
    }
}
class Ex {
    public static void main(String args[]) {
        BST_Cor b1=new BST_Cor();
        b1.addElt(5);
        b1.addElt(3);
        b1.addElt(6);
        b1.addElt(7);
        System.out.println(b1.r.x);
        System.out.println(b1.r.left.x);
        System.out.println(b1.r.right.x);
        System.out.println(b1.r.right.right.x);
        System.out.println();
        System.out.println(b1.size());
        System.out.println();
        b1.remElt(6);
        System.out.println(b1.size());
        System.out.println();
        System.out.println(b1.r.x);
        System.out.println(b1.r.left.x);
        System.out.println(b1.r.right.x);
        System.out.println();
        System.out.println(b1.Tree_Maximum(b1.r).x);
        System.out.println(b1.Tree_Minimum(b1.r).x);
    }
}
