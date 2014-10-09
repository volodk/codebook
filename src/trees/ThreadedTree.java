package trees;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:19:49 PM 

public class ThreadedTree {
    
    static class Tree{
        int value;
        boolean isLeaf = true;
        Tree left, right;
        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
            isLeaf = left != null || right != null;
        }
    }
    
    Tree threadedTree;
    
    public ThreadedTree(Tree tree) {
        threadedTree = turnIntoThreadedTree(tree);
    }

    private Tree turnIntoThreadedTree(Tree tree) {
        return null;
    }
    
    
    void printNoStackNorRecursion(){
        
    }

    public static void main(String[] args) {
        
        Tree t = new Tree(1, new Tree(2, null, null), new Tree(3, null,  null));
// 1
// |\
// 2 3  
        
        ThreadedTree tt = new ThreadedTree(t);
        
        tt.printNoStackNorRecursion();
    }

}
