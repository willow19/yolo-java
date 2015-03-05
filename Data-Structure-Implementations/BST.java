/**
 * Created by rachit on 29/1/15.
 */
interface IBST {
    IBST addElt(int elt);
    int size();
    boolean hasElt(int elt);
}

class MtBST implements IBST{
    MtBST() {}

    public IBST addElt(int elt) {
        return new DataBST(elt, new MtBST(), new MtBST());
    }

    public int size() {
        return 0;
    }

    public boolean hasElt(int elt) {
        return false;
    }
}

class DataBST implements IBST{
    int data;
    IBST left;
    IBST right;

    DataBST(int elt, IBST left, IBST right){
        this.left=left;
        this.right=right;
        this.data=elt;
    }

    public int size(){
        return 1 + this.left.size() + this.right.size();
    }

    public boolean hasElt(int elt){
        if(elt==this.data)   return true;
        else if(elt<this.data) return this.left.hasElt(elt);
        else return this.right.hasElt(elt);
    }

    public IBST addElt(int elt) {
        if(elt==this.data)
            return this;
        else if(elt<this.data)
            return new DataBST(this.data, this.left.addElt(elt), this.right);
        else return new DataBST(this.data, this.left, this.right.addElt(elt));
    }

}

class Examples {
    public static void main(String args[]){
        IBST b1=new DataBST(5, new MtBST(), new MtBST());
        IBST b2=b1.addElt(3).addElt(4).addElt(8).addElt(7);
        System.out.println(b2.size());
        System.out.println(b2.addElt(6).size());
    }
}
