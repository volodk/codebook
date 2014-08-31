package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:53:38 PM 

public class Treap {
    
    static int TOP = 1000;
    
    Random rnd = new Random();
    
    class Node {
        int key;
        int priority;
        Node left, right;
        public Node(int key, int priority) {
            this.key = key;
            this.priority = priority;
        }
    }
    
    Node root;
    
    public void insert(int key){
        root = insert(root, key, rnd.nextInt(TOP));
    }
    
    /*
     * To insert a new key x into the treap, generate a random priority y for x.
     * Binary search for x in the tree, and create a new node at the leaf
     * position where the binary search determines a node for x should exist.
     * Then, as long as x is not the root of the tree and has a larger priority
     * number than its parent z, perform a tree rotation that reverses the
     * parent-child relation between x and z.
     */
    private Node insert(Node n, int key, int priority){
        if( n == null ) return new Node(key, priority);
        else {
            if( key < n.key ){
                n.left = insert(n.left, key, priority);
                if( n.priority < n.left.priority){
                    n = rotl(n);
                }
            }
            else { 
                n.right = insert(n.right, key, priority);
                if( n.priority < n.right.priority){
                    n = rotr(n);
                }
            }
            return n;
        }
    }
    
    private Node rotl(Node n) {
        if ( n == null ) return null;
        if ( n.right == null ) return n;
        Node r = n.right;
        n.right = r.left;
        r.left = n;
        return r;
    }
    
    private Node rotr(Node n) {
        if ( n == null ) return null;
        if ( n.left == null ) return n;
        Node l = n.left;
        n.left = l.right;
        l.right = n;
        return l;
    }

// ============================================================================
    
    public void delete(int key){
        
    }

    /*
     * To delete a node x from the treap, if x is a leaf of the tree, simply
     * remove it. If x has a single child z, remove x from the tree and make z
     * be the child of the parent of x (or make z the root of the tree if x had
     * no parent). Finally, if x has two children, swap its position in the tree
     * with the position of its immediate successor z in the sorted order,
     * resulting in one of the previous cases. In this final case, the swap may
     * violate the heap-ordering property for z, so additional rotations may
     * need to be performed to restore this property.
     */
    private Node delete(Node n, int key){
        return n;
    }
    
    private void printNode(Node n) {
        System.out.format("%d(%d)", n.key, n.priority);
    }
    
    /*
     * To search for a given key value, apply a standard binary search algorithm
     * in a binary search tree, ignoring the priorities.
     */
    
    public boolean contains(int key){
        return search(root, key) != null;
    }
    
    private Node search(Node n, int key) {
        if( n == null )
            return null;
        if( n.key == key)
            return n;
        if ( key < n.key )
            return search(n.left, key);
        else 
            return search(n.right, key);
    }
    
    /*
     * To split a treap into two smaller treaps, those smaller than key x, and
     * those larger than key x, insert x into the treap with maximum
     * priority—larger than the priority of any node in the treap. After this
     * insertion, x will be the root node of the treap, all values less than x
     * will be found in the left subtreap, and all values greater than x will be
     * found in the right subtreap. This costs as much as a single insertion
     * into the treap.
     */
    
    public static Treap[] split(Treap t, int priority){
        return null;
    }
    
    /*
     * Merging two treaps that are the product of a former split, one can safely
     * assume that the greatest value in the first treap is less than the
     * smallest value in the second treap. Insert a value x, such that x is
     * larger than this max-value in the first treap, and smaller than the
     * min-value in the second treap, and assign it the minimum priority. After
     * insertion it will be a leaf node, and can easily be deleted. The result
     * is one treap merged from the two original treaps. This is effectively
     * "undoing" a split, and costs the same.
     */
    public static Treap merge( Treap[] treaps ){
        return null;
    }
    
 // ============================================================================
    
    public void print(){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int inLayer = 1, next = 0;
        while( !q.isEmpty()){
            Node n = q.poll();
            inLayer -= 1;
            printNode(n);

            if(n.left != null) { q.offer(n.left); next +=1; }
            if(n.right != null) { q.offer(n.right); next +=1; }
            
            if( inLayer == 0) {
                System.out.println();
                inLayer = next; next = 0;
            }
        }
    }

    public static void main(String[] args) {
        Treap t = new Treap();
        
        t.insert(7);
        t.insert(4);
        t.insert(5);
        t.insert(3);
        t.insert(9);
        t.insert(8);
        
        t.print();
    }

}
