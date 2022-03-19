public class Problem3 {

    public static String serialize(NodeP3 root){
        return root.serialize();
    }
    
    public static NodeP3 deserialize(String s){



        return null;
    }

    public static boolean test1(){
        NodeP3 root = new NodeP3("root");
        NodeP3 left = new NodeP3("left");
        NodeP3 left2 = new NodeP3("left.left");
        NodeP3 right = new NodeP3("right");
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(left2);
        return deserialize(serialize(root)).getLeft().getLeft().getData().equals("left.left");
    }

    public static void main(String[] args) {
        //System.out.println(test1());
    }
}
