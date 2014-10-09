package trees;

import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:11:30 PM 

public class RandomizedBinaryTree {

    private final static Random rnd = new Random();

    static class Tree {
        int key;
        Tree left, right;

        public Tree(int key, Tree left, Tree right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    Tree root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Tree insert(Tree t, int key) {
        float p = rnd.nextFloat();
        if (p < 1.0 / (size(t) + 1)) {
            return insertAsRoot(t, key);
        } else if (key < t.key) {
            return t.left = insert(t.left, key);
        } else {
            return t.right = insert(t.right, key);
        }
    }

    private Tree insertAsRoot(Tree t, int key) {
        if (t == null) {
            return new Tree(key, null, null);
        } else {
            Tree[] ts = split(t, key);
            Tree left = ts[0], right = ts[1];
            return merge(key, left, right);
        }
    }

    private boolean contains(Tree tree, int key) {
        if (tree != null) {
            if (key < tree.key)
                return contains(tree.left, key);
            else if (key > tree.key)
                return contains(tree.right, key);
            else
                return true;
        } else {
            return false;
        }
    }

    private Tree bstInsert(Tree tree, int key) {
        if (tree == null)
            return new Tree(key, null, null);
        else {
            if (key < tree.key)
                tree.left = bstInsert(tree.left, key);
            else if (key > tree.key)
                tree.right = bstInsert(tree.right, key);
            else {
                // already there, do nothing
            }
            return tree;
        }
    }

    private Tree splay(Tree tree, int key) {
        if( tree != null ){
            if( key < tree.key ){
                tree.left = splay(tree.left, key);
                return rotateRight(tree);
            } else if (key > tree.key){
                tree.right = splay(tree.right, key);
                return rotateLeft(tree);
            } else {
                return tree;
            }
        }
        return null;
    }

    private Tree[] split(Tree tree, int partition) {
        if (!contains(tree, partition)) {
            tree = bstInsert(tree, partition);
        }
        Tree root = splay(tree, partition);
        return new Tree[] { root.left, root.right };
    }

    private Tree merge(int key, Tree left, Tree right) {
        return new Tree(key, left, right);
    }

    private Tree rotateLeft(Tree t) {
        if (t.right != null) {
            Tree newRoot = t.right;
            t.right = newRoot.left;
            newRoot.left = t;
            return newRoot;
        }
        return t;
    }

    private Tree rotateRight(Tree t) {
        if (t.left != null) {
            Tree newRoot = t.left;
            t.left = newRoot.right;
            newRoot.right = t;
            return newRoot;
        }
        return t;
    }

    private int size(Tree t) {
        if (t != null) {
            return 1 + size(t.left) + size(t.right);
        }
        return 0;
    }

    private void printInorder() {
        print(root);
    }

    private void print(Tree t) {
        if (t != null) {
            print(t.left);
            System.out.println(t.key);
            print(t.right);
        }
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
