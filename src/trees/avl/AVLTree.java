package trees.avl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:48:23 PM 

public class AVLTree<K extends Comparable<K>, V> {

    class Node {
        K key;
        V value;
        Node left, right;
        public Node(K key, V value) { this.key = key; this.value = value; }
        @Override public String toString() { return String.format("%s:%s", key, value); }
    }

    Node root;
    
    public void insert(K key, V value) {
        root = balance( insert(root, key, value) );
    }
    
    public void delete(K key) {
        root = balance( delete(root, key) );
    }
    
    public V find(K key) {
        Node n = find(root, key);
        return n == null ? null : n.value;
    }
    
    public void print() {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int toPrint = 1, next = 0;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.left != null) {
                q.offer(n.left);
                next++;
            }
            if (n.right != null) {
                q.offer(n.right);
                next++;
            }
            System.out.format("%s ", n);
            if (--toPrint == 0) {
                System.out.println();
                toPrint = next;
                next = 0;
            }
        }
    }
    
    Node balance(Node tree){
        return tree;
    }

    Node insert(Node curr, K key, V value) {
        if (curr == null) {
            Node n = new Node(key, value);
            return n;
        } else {
            if (curr.key.compareTo(key) < 0) {
                curr.right = insert(curr.right, key, value);
            } else if (curr.key.compareTo(key) > 0) {
                curr.left = insert(curr.left, key, value);
            } else {
                curr.value = value; // replace old value
            }
            return curr;
        }
    }

    Node delete(Node curr, K key) {
        if (curr == null) return null;
        if( curr.key.compareTo(key) < 0)
            return curr.right = delete(curr.right, key);
        else if(curr.key.compareTo(key) > 0)
            return curr.left = delete(curr.left, key);
        else
            return delete(curr);
    }

    Node delete(Node curr) {
        if( curr.left == null && curr.right == null ) return null;
        else {
            Node replace = successor(curr);
            if( replace == null ) replace = predecessor(curr);
            
            curr.key = replace.key;
            curr.value = replace.value;
            
            delete(replace);    // <- must be a leaf
            return curr;
        }
    }

    Node find(Node curr, K key) {
        if (curr == null || curr.key.equals(key))
            return curr;
        if (curr.key.compareTo(key) < 0)
            return find(curr.right, key);
        else
            return find(curr.left, key);
    }

    void inorderKeysDump(Node tree, List<K> buffer) {
        if (buffer == null)
            throw new NullPointerException();
        if (tree != null) {
            inorderKeysDump(tree.left, buffer);
            buffer.add(tree.key);
            inorderKeysDump(tree.right, buffer);
        }
    }

    int size(Node tree) {
        if (tree == null) return 0;
        else return 1 + size(tree.left) + size(tree.right);
    }

    int height(Node tree) {
        if (tree == null) return 0;
        else return 1 + Math.max(height(tree.left), height(tree.right));
    }

    Node min(Node tree) {
        if (tree != null && tree.left != null)
            return min(tree.left);
        return tree;
    }

    Node max(Node tree) {
        if (tree != null && tree.right != null)
            return max(tree.right);
        return tree;
    }

    Node rotateLeft(Node oldRoot) {
        Node newRoot = oldRoot.right;
        oldRoot.right = newRoot.left;
        newRoot.left = oldRoot;
        return newRoot;
    }

    Node rotateRight(Node oldRoot) {
        Node newRoot = oldRoot.left;
        oldRoot.left = newRoot.right;
        newRoot.right = oldRoot;
        return newRoot;
    }

    Node successor(Node node) { // is not an in-order successor
        if (node == null) return null;
        return min(node.right);
    }

    Node predecessor(Node node) { // is not an in-order predecessor
        if (node == null) return null;
        return max(node.left);
    }
}
