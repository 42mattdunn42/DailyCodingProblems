import java.util.ArrayList;

public class NodeP3 <T>{
    private T data;
    private NodeP3 <T> left, right;

    public NodeP3 (T data){
        this.data= data;
    }
    
    public T getData(){
        return data;
    }

    public NodeP3<T> getLeft(){
        return left;
    }
    public NodeP3<T> getRight(){
        return right;
    }

    public void setLeft(NodeP3<T> leftChild) {
        this.left = (NodeP3<T> ) leftChild;
    }

    public void setRight(NodeP3<T> rightChild) {
        this.right = (NodeP3<T>) rightChild;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public int getNumberOfNodes() {
        int n = 1;
        if (hasRight())
            n += right.getNumberOfNodes();
        if (hasLeft())
            n += left.getNumberOfNodes();
        return n;
    }

    public void __init__(NodeP3<T> self, T val, NodeP3<T> left, NodeP3<T> right){
        self.data = val;
        self.setLeft(left);
        self.setRight(right);
    }



    public String serialize(){
        ArrayList<T> arrRep = new ArrayList<T>();
        

        return "";
    }
}
