package trees;

import java.util.Random;
import java.util.Stack;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:11:30 PM 

public class RandomizedBinaryTree {
    
    private final static Random rnd = new Random();
    
    static class Tree {
        int key;
        Tree left, right;
        public Tree(int key, Tree left, Tree right) {
            this.key = key; this.left = left; this.right = right;
        }
    }
    
    Tree root;
    
    public void insert(int key){
        root = insert(root, key);
    }
    
    public void printInorder(){
        if( root != null ){
            Stack<Tree> st = new Stack<>();
            st.push(root);
            while( !st.isEmpty() ){
                Tree p = st.peek();
            }
        }
    }
        
    private Tree insert(Tree t, int key) {
        float p = rnd.nextFloat(); 
        if( p < 1.0/(size(t) + 1) ){
            return insertAsRoot(t, key);
        } else if( key < t.key){
            return t.left = insert(t.left, key);
        } else {
            return t.right = insert(t.right, key);
        }
    }

    private Tree insertAsRoot(Tree t, int key) {
        if(t == null) return new Tree(key, null, null); 
        Tree[] ts = split(t, key);
        return merge(ts[0], ts[1], key);
    }

    private Tree[] split(Tree t, int partition) {
        // TODO Auto-generated method stub
        return new Tree[]{ null, null };
    }
    
    private Tree merge(Tree left, Tree right, int key){
        return new Tree(key, left, right);
    }
    
    private Tree rotateLeft(Tree t){
        if( t.right != null){
            Tree newRoot = t.right;
            t.right = newRoot.left;
            newRoot.left = t;
            return newRoot;
        }
        return t;
    }
    
    private Tree rotateRight(Tree t){
        if(t.left != null){
            Tree newRoot = t.left;
            t.left = newRoot.right;
            newRoot.right = t;
            return newRoot;
        }
        return t;
    }

    private int size(Tree t){
        if( t != null ){
            return 1 + size(t.left) + size(t.right);
        }
        return 0;
    }

    public static void main(String[] args) {
        RandomizedBinaryTree rbt = new RandomizedBinaryTree();
        
        rbt.insert(0);
        rbt.insert(1);
        rbt.insert(2);
        rbt.insert(3);
        rbt.insert(4);
        rbt.insert(5);
        rbt.insert(6);
        rbt.insert(7);
        rbt.insert(8);
        rbt.insert(9);
        
        rbt.printInorder();
    }
}
