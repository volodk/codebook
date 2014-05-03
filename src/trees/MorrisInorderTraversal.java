package trees;

public class MorrisInorderTraversal {
    
    static class Node {
        int value;
        Node left, right;
        public Node(int value, Node left, Node right) {
            this.value = value; this.left = left; this.right = right;
        }
    }
    
    public static void visitInorder(Node n){
        
        Node curr = n;
        while(curr != null){
            if(curr.left == null){
                visit(curr);
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while( pred.right != null && pred.right != curr )
                    pred = pred.right;
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    visit(curr);
                    curr = curr.right;
                }
            }
        }
        
    }
    
    static void visit(Node n){
        System.out.println(n.value);
    }
    
    
    public static void main(String[] args) {
        Node tree = new Node(1, new Node(2, new Node(4, null, null), new Node(5, null, null)), new Node(3, null, null));
        
        visitInorder(tree);
    }
}
