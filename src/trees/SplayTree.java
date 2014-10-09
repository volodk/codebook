package trees;

import java.util.LinkedList;
import java.util.Queue;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 6:48:13 PM 

public class SplayTree<K extends Comparable<K>, V> {

    class Node {
        K key;
        V value;
        Node left, right, parent;

        public Node(K key, V value, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("%s", key);
        }
    }

    Node root;

    // interface

    public void insert(K key, V value) {
        root = insert(root, null, key, value);
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public V find(K key) {
        Node n = find(root, key);
        if (n == null) {
            return null;
        } else {
            root = n;
            return n.value;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node tree) {
        if (tree == null)
            return 0;
        else
            return 1 + size(tree.left) + size(tree.right);
    }

    int height(Node tree) {
        if (tree == null)
            return 0;
        else
            return 1 + Math.max(height(tree.left), height(tree.right));
    }

    Node find(Node curr, K key) {
        if (curr == null)
            return null;

        if (eq(key, curr.key))
            return curr;

        if (lt(key, curr.key)) {
            curr.left = find(curr.left, key);
            return rotateRight(curr);
        } else {
            curr.right = find(curr.right, key);
            return rotateLeft(curr);
        }

    }

    boolean isBST(Node curr) {
        if (curr == null)
            return true;
        return isBST(curr.left) && (gt(curr, curr.left) && le(curr, curr.right)) && isBST(curr.right);
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

    Node insert(Node curr, Node parent, K key, V value) {
        if (curr == null) {
            return new Node(key, value, parent, null, null);
        } else {
            if (lt(key, curr.key)) {
                curr.left = insert(curr.left, curr, key, value);
                return rotateRight(curr); // splay up
            } else if (eq(key, curr.key)) {
                curr.value = value;
                return curr;
            } else {
                curr.right = insert(curr.right, curr, key, value);
                return rotateLeft(curr); // splay up
            }
        }
    }

    Node delete(Node curr, K key) {
        if (find(root, key) == null) {
            return null;
        } else {
            return root = delete(root);
        }
    }

    Node delete(Node curr) {
        if (curr.left == null && curr.right == null) {
            Node p = curr.parent;
            if (p.left == curr)
                p.left = null;
            if (p.right == curr)
                p.right = null;
            return p;
        } else if (curr.left == null && curr.right != null) {
            Node p = curr.parent;
            if (p.left == curr)
                p.left = curr.right;
            if (p.right == curr)
                p.right = curr.right;
            return p;
        } else if (curr.left != null && curr.right == null) {
            Node p = curr.parent;
            if (p.left == curr)
                p.left = curr.left;
            if (p.right == curr)
                p.right = curr.left;
            return p;
        } else {
            Node repl = max(curr.left);
            curr.key = repl.key;
            curr.value = repl.value;
            delete(repl);
            return curr;
        }
    }

    Node rotateLeft(Node old) {
        if (old.right != null) {
            Node newRoot = old.right;
            old.right = newRoot.left;
            if (old.right != null)
                old.right.parent = old;

            newRoot.parent = old.parent;
            if (old.parent != null) {
                if (old.parent.left == old)
                    old.parent.left = newRoot;
                if (old.parent.right == old)
                    old.parent.right = newRoot;
            }
            newRoot.left = old;
            old.parent = newRoot;

            return newRoot;
        }
        return null;
    }

    Node rotateRight(Node old) {
        if (old.left != null) {
            Node newRoot = old.left;
            old.left = newRoot.right;
            if (old.left != null)
                old.left.parent = old;

            newRoot.parent = old.parent;
            if (old.parent != null) {
                if (old.parent.left == old)
                    old.parent.left = newRoot;
                if (old.parent.right == old)
                    old.parent.right = newRoot;
            }
            newRoot.right = old;
            old.parent = newRoot;

            return newRoot;
        }
        return null;
    }

    boolean lt(Node n1, Node n2) {
        return n2 == null ? true : lt(n1.key, n2.key);
    }

    boolean lt(K key1, K key2) {
        return key1.compareTo(key2) < 0;
    }

    boolean le(Node n1, Node n2) {
        return n2 == null ? true : le(n1.key, n2.key);
    }

    boolean le(K key1, K key2) {
        return key1.compareTo(key2) <= 0;
    }

    boolean gt(Node n1, Node n2) {
        return n2 == null ? true : gt(n1.key, n2.key);
    }

    boolean gt(K key1, K key2) {
        return key1.compareTo(key2) > 0;
    }

    boolean ge(Node n1, Node n2) {
        return n2 == null ? true : ge(n1.key, n2.key);
    }

    boolean ge(K key1, K key2) {
        return key1.compareTo(key2) >= 0;
    }

    boolean eq(K key1, K key2) {
        return key1.compareTo(key2) == 0;
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
            System.out.print(n);
            System.out.print(" ");
            if (--toPrint == 0) {
                System.out.println();
                toPrint = next;
                next = 0;
            }
        }
        System.out.print("\n");
    }
}
