package trees;

public class MorrisPostorderTraversal {
    
    static class Node {
        int value;
        Node left, right;
        public Node(int value, Node left, Node right) {
            this.value = value; this.left = left; this.right = right;
        }
    }
    
    public static void visitPostorder(Node n){
        
       
        
    }
    
    static void visit(Node n){
        System.out.println(n.value);
    }
    
    
    public static void main(String[] args) {
        
//        Node tree = new Node(1, new Node(2, new Node(4, null, null), new Node(5, null, null)), new Node(3, null, null));
        
        Node tree = new Node(2, new Node(1, null, null), new Node(5, null, null));
        
        visitPostorder(tree);
    }
}
