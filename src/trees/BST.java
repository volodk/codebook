package trees;

import java.util.LinkedList;
import java.util.Queue;


public class BST<K extends Comparable<K>, V> {
    
    class Node{
        K key;
        V value;
        Node left, right, parent;
        @Override
        public String toString() { return String.format("%s:%s", key, value); }
    }
    
    Node root;
    
    // interface
    public V insert(K key, V value){
        return null;
    }
    
    public boolean delete(K key){
        return false;
    }
    
    public V find(K key){
        return null;
    }
    
    public void print(){
        System.out.println("\n");
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        int toPrint = 1, next = 0;

        while(!q.isEmpty()){
            Node n = q.poll();
            
            if(n.left != null){ q.offer(n.left); next++; }
            if(n.right != null ){ q.offer(n.right); next++; }
            
            System.out.print(n);
            System.out.print(" ");
            if( --toPrint == 0){
                System.out.println();
                toPrint = next;
                next = 0;
            }
            
        }
        
        System.out.println("\n");
    }
}
