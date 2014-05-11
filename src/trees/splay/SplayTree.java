package trees.splay;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 6:48:13 PM 

public class SplayTree<K extends Comparable<K>, V> {
    
    class Node {
        K key;
        V value;
        Node left, right, parent;
        public Node(K key, V value) {  this.key = key;  this.value = value;  }
        public Node(K key, V value, Node parent, Node left, Node right)
        {  
            this.key = key;  this.value = value;
            this.parent = parent; this.left = left; this.right = right;
        }
        @Override public String toString() { return String.format("%s:%s", key, value); }
    }
    
    Node root;
    
    // interface
    
    public void insert(K key, V value){
        root = insert(root, null, key, value);
    }
    
    public void delete(K key){
        root = delete(root, key);
    }
    
    public V find(K key){
        Node n = find(root, key);
        if( n == null ){
            return null;
        } else {
            root = splay(n);
            return n.value; 
        }
    }
    
    Node splay(Node curr){
        if( curr == null ) return null;
        
        if( curr.parent == null )
            return curr;
        else {
            if( curr.parent.left == curr ){ // in the left sub-tree
                return splay( rotateRight(curr.parent) );
            } else{  // in the right sub-tree 
                return splay( rotateLeft(curr.parent) );
            }
        }
    }
    
    int size(Node tree){
        if(tree == null) return 0;
        else return 1 + size(tree.left) + size(tree.right);
    }
    
    int height(Node tree){
        if(tree == null) return 0;
        else return 1 + Math.max(height(tree.left), height(tree.right));
    }
    
    Node find(Node curr, K key){
        if(curr == null || curr.key.equals(key))
            return curr;
        if( less(key, curr.key))
            return find(curr.left, key);
        else 
            return find(curr.right, key);
    }
    
    Node min(Node tree){
        if( tree != null && tree.left != null )
            return min(tree.left);
        return tree;
    }
    
    Node max(Node tree){
        if(tree != null && tree.right != null)
            return max(tree.right);
        return tree;
    }
    
    Node insert(Node curr, Node parent, K key, V value){
        if( curr == null ){
            return new Node(key, value, parent, null, null); 
        } else {
            if( less(key, curr.key) )
            {
                curr.left = insert(curr.left, curr, key, value);
                return splay(curr.left);
            } 
            else if( eq(key, curr.key) )
            {
                curr.value = value;
                return curr;                
            } 
            else 
            {
                curr.right = insert(curr.right, curr, key, value);
                return splay(curr.right);
            }
        }
    }
    
    Node delete(Node curr, K key){
       if( curr != null )
           do {
               if( less(key, curr.key) )
                   curr = curr.left;
               else if( greater(key, curr.key))
                   curr = curr.right;
               else { 
                  return delete( splay(curr) );
               }
           } while ( curr != null );
       return null;
    }
    
    Node delete(Node curr)
    {
        if( curr.left == null && curr.right == null )
        {
            Node p = curr.parent;
            if(p.left == curr) p.left = null;
            if(p.right == curr) p.right = null;
            return p;
        } 
        else if( curr.left == null && curr.right != null)
        {
            Node p = curr.parent;
            if(p.left == curr) p.left = curr.right;
            if(p.right == curr) p.right = curr.right;
            return p;
        } 
        else if(curr.left != null && curr.right == null)
        {
            Node p = curr.parent;
            if(p.left == curr) p.left = curr.left;
            if(p.right == curr) p.right = curr.left;
            return p;
        } 
        else
        {
            Node repl = max(curr.left);
            curr.key = repl.key;
            curr.value = repl.value;
            delete(repl);
            return curr;
        }
    }
    
    
    Node rotateLeft(Node oldRoot){
        Node newRoot = oldRoot.right;
        oldRoot.right = newRoot.left;
        if (oldRoot.right != null) oldRoot.right.parent = oldRoot;
        
        newRoot.parent = oldRoot.parent;
        if( oldRoot.parent != null ){
            if( oldRoot.parent.left == oldRoot ) oldRoot.parent.left = newRoot;
            if( oldRoot.parent.right == oldRoot ) oldRoot.parent.right = newRoot;
        }
        newRoot.left = oldRoot;
        newRoot.left.parent = newRoot;
        
        return newRoot;
    }
    
    Node rotateRight(Node oldRoot){
        Node newRoot = oldRoot.left;
        oldRoot.left = newRoot.right;
        if (oldRoot.left != null) oldRoot.left.parent = oldRoot;
        
        newRoot.parent = oldRoot.parent;
        if( oldRoot.parent != null ){
            if( oldRoot.parent.left == oldRoot ) oldRoot.parent.left = newRoot;
            if( oldRoot.parent.right == oldRoot ) oldRoot.parent.right = newRoot;
        }
        newRoot.right = oldRoot;
        newRoot.right.parent = newRoot;
        
        return newRoot;
    }
    
    private boolean less(K key1, K key2){
        return key1.compareTo(key2) < 0;
    }
    
    private boolean greater(K key1, K key2){
        return key1.compareTo(key2) > 0;
    }
    
    private boolean eq(K key1, K key2){
        return key1.compareTo(key2) == 0;
    }
    
    public void print(){
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
        System.out.print("\n");
    }
    
    void inorderKeysDump( Node tree, List<? super K> buffer){
        Objects.requireNonNull(buffer);
        if( tree != null ){
            inorderKeysDump(tree.left, buffer);
            buffer.add(tree.key);
            inorderKeysDump(tree.right, buffer);
        }
    }
}
