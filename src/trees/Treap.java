package trees;

import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:53:38 PM 

public class Treap {
    
    Random rnd = new Random();
    
    class Node {
        int key;
        int priority;
        Node left, right;
    }
    
    Node root;
    
// ============================================================================    
    
    public void insert(int key){
        
    }
    
    private Node insert(Node n, int key, int priority){
        return n;
    }
    
 // ============================================================================
    
    public void delete(int key){
        
    }
    
    private Node delete(Node n, int key){
        return n;
    }
    
 // ============================================================================
    
    public void contains(int key){
        
    }
    
    private Node search(Node n, int key) {
        return null;
    }
    
 // ============================================================================
    
    public static Treap[] split(Treap t, int priority){
        return null;
    }
    
 // ============================================================================
    
    public static Treap merge( Treap[] treaps ){
        return null;
    }
    
 // ============================================================================

    public static void main(String[] args) {

    }

}
