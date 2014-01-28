package trees.splay;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 6:48:13 PM 

public class Splay<K extends Comparable<K>, V> {
    
    class Node {
        K key;
        V value;
        Node left, right, parent;
        public Node(K key, V value) {  this.key = key;  this.value = value;  }
        @Override public String toString() { return String.format("%s:%s", key, value); }
    }
    
    Node root;
    
    // interface
    
    public void insert(K key, V value){
        root = splay(insert(root, null, key, value));
    }
    
    public void delete(K key){
        root = splay(delete(root, key));
    }
    
    public V find(K key){
        Node n = find(root, key);
        if( n == null )
            return null;
        else{
            root = splay(n);
            return root.value;
        }
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
    
    // helper BST stuff
    
    void inorderKeysDump( Node tree, List<K> buffer){
        if( buffer == null )
            throw new NullPointerException();
        if( tree != null ){
            inorderKeysDump(tree.left, buffer);
            buffer.add(tree.key);
            inorderKeysDump(tree.right, buffer);
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
    
    Node splay(Node curr){
        if(curr == null)
            return root;
        if( curr.parent == null )
            return curr;
        else {
            if( curr.parent.left == curr ){ // in the left sub-tree
                return splay(rotateRight(curr.parent));
            } else{  // in the right sub-tree 
                return splay(rotateLeft(curr.parent));
            }
        }
    }
    
    Node find(Node curr, K key){
        if(curr == null || curr.key.equals(key))
            return curr;
        if( curr.key.compareTo(key) < 0)
            return find(curr.right, key);
        else 
            return find(curr.left, key);
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
            Node n = new Node(key, value); n.parent = parent;
            return n; 
        } else {
            if( curr.key.compareTo(key) < 0){
                curr.right = insert(curr.right, curr, key, value);
            } else if( curr.key.compareTo(key) > 0){
                curr.left = insert(curr.left, curr, key, value);
            } else {
                curr.value = value; // replace old value
            }
            return curr;
        }
    }
    
    Node delete(Node curr, K key){
       if( curr != null )
           do {
               if( curr.key.compareTo(key) < 0)
                   curr = curr.right;
               else if( curr.key.compareTo(key) > 0)
                   curr = curr.left;
               else { 
                  return delete(curr);
               }
           } while(curr != null);
       return null;
    }
    
    Node delete(Node curr){
        if( curr.left == null && curr.right == null ){
            Node p = curr.parent;
            if(p.left == curr) p.left = null;
            if(p.right == curr) p.right = null;
            return p;
        } else {
            Node replacement = successor(curr);
            if(replacement == null) replacement = predecessor(curr);
            curr.key = replacement.key; curr.value = replacement.value;
            return delete(replacement);    // must be a leaf
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
    
    Node successor(Node node){
        if(node == null)
            return node;
        if(node.right != null)
            return min(node.right);
        else {
            Node p = node.parent;
            while( p != null && node.key.compareTo(p.key) > 0){
                p = p.parent;
            }
            return p;
        }
    }
    
    Node predecessor(Node node){
        if(node == null)
            return node;
        if(node.left != null)
            return max(node.left);
        else {
            Node p = node.parent;
            while( p != null && node.key.compareTo(p.key) < 0){
                p = p.parent;
            }
            return p;
        }
    }
}
