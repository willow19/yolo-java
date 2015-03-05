import java.util.*;
//Seperate find and Delete in findAndDelete, use BST instead of SortedSet in lca

/**
 * Created by rachit on 2/2/15.
 */
class NodeD {
    NodeD left;
    NodeD right;
    int key;

    NodeD(int elt) {
        this.left=null;
        this.right=null;
        this.key=elt;
    }
}
class BST_DAA {
    NodeD r;
    Queue<NodeD> q1=new ArrayDeque<NodeD>();
    Queue<NodeD> q2=new ArrayDeque<NodeD>();
    Queue<NodeD> q3=new ArrayDeque<NodeD>();

    public void addElt(int elt) {
        NodeD u=null;
        NodeD x=this.r;

        while(x!=null) {
            u=x;
            if(elt>x.key) x=x.right;
            else x=x.left;
        }

        x=new NodeD(elt);
        if(u==null) this.r=x;
        else if(u.key<x.key) u.right=x;
        else if (u.key>x.key) u.left=x; //'else' not used so that duplicates could be avoided
    }

    public void addRevElt(int elt) {
        NodeD u=null;
        NodeD x=this.r;

        while(x!=null) {
            u=x;
            if(elt>x.key) x=x.left;
            else x=x.right;
        }

        x=new NodeD(elt);
        if (u==null) this.r=x;
        else if (u.key>x.key) u.right=x;
        else u.left=x;
    }

    public void levelTraversal(NodeD t) {
        q1.add(t);
        while(!q1.isEmpty()) {
            NodeD u=q1.remove();
            System.out.print(u.key+" ");
            if(u.left!=null) q1.add(u.left);
            if(u.right!=null) q1.add(u.right);
        }
    }

    public boolean checkBST(NodeD t) {
        q2.add(t);
        while(!q2.isEmpty()) {
            NodeD u=q2.remove();
            if(u.left!=null) {
                q1.add(u.left);
                if(u.key<u.left.key) return false;
            }
            if(u.right!=null) {
                q1.add(u.right);
                if(u.key>u.right.key) return false;
            }
        }
        return true;
    }

    public void transplant(NodeD p, NodeD q) {
        NodeD u=this.r, z=null;

        if(p==this.r) this.r=q;
        else {
            while(u.key!=p.key) {
                z=u;
                if(p.key>u.key) u=u.right;
                else u=u.left;
            }
            if(z.left==u) z.left=q;
            else z.right=q;
        }
    }

    public NodeD treeMin(NodeD t) {
        NodeD u=t;
        while(u.left!=null) {
            u=u.left;
        }
        return u;
    }

    public boolean findAndDelete(int elt) {
        NodeD u=this.r,z=null;
        boolean flag=false;
        while(u!=null) {
            z=u;
            if(u.key<elt) u=u.right;
            else if(u.key>elt) u=u.left;
            else {
                flag=true;
                break;
            }
        }
        if(flag){
        if(z.right==null) transplant(z, z.left);
        else if(z.left==null) transplant(z, z.right);
        else {
            NodeD y=treeMin(z.right);
            if(y.left!=z && y.right!=z) {
                transplant(y,y.right);
                y.right=z.right;
            }
            transplant(z,y);
            y.left=z.left;
        }}
        return flag;
    }

    public boolean find(NodeD t, int elt) {
        NodeD u = t;
        boolean flag = false;
        while (u != null) {
            if (u.key < elt) u = u.right;
            else if (u.key > elt) u = u.left;
            else {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public int lca(int elt1, int elt2) {
        SortedSet<Integer> s = new TreeSet<Integer>();
        q3.add(this.r);
        while(!q3.isEmpty()) {
            NodeD u=q3.remove();
            if(find(u,elt1) && find(u,elt2)) s.add(u.key);
            if(u.left!=null) q3.add(u.left);
            if(u.right!=null) q3.add(u.right);
        }
        if(elt1 > this.r.key && elt2 > this.r.key)
            return s.last();
        else return s.first();
    }
}
class Ex1 {
    public static void main(String args[]) {
        BST_DAA b1=new BST_DAA();
        b1.addElt(15);
        b1.addElt(6);
        b1.addElt(18);
        b1.addElt(3);
        b1.addElt(2);
        b1.addElt(4);
        b1.addElt(7);
        b1.addElt(13);
        b1.addElt(9);
        b1.addElt(17);
        b1.addElt(20);
        b1.addElt(20);
        System.out.println(b1.r.key);
        //System.out.println(b1.findAndDelete(4));
        b1.levelTraversal(b1.r);
        System.out.println();
        BST_DAA b2=new BST_DAA();
        b2.addRevElt(15);
        b2.addRevElt(6);
        b2.addRevElt(18);
        b2.addRevElt(3);
        b2.addRevElt(2);
        b2.addRevElt(4);
        b2.addRevElt(7);
        b2.addRevElt(13);
        b2.addRevElt(9);
        b2.addRevElt(17);
        b2.addRevElt(20);
        System.out.println(b1.checkBST(b2.r));
        System.out.println(b1.lca(7,3));
    }
}
