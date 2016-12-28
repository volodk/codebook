package ds.tree.random;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 2:11:30 PM 

public class RandomizedBinaryTree {

	private final static Random rnd = new Random();

	static class Tree {
		int key;
		int size;
		Tree left, right;

		public Tree(int key, Tree left, Tree right) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.size = 1 + (left != null ? left.size : 0) + (right != null ? right.size : 0);
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
			t.left = insert(t.left, key);
			return t;
		} else {
			t.right = insert(t.right, key);
			return t;
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

	public boolean contains(int key) {
		return contains(root, key);
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
			if (key < tree.key) {
				tree.left = bstInsert(tree.left, key);
				tree.size += 1;
			} else if (key > tree.key) {
				tree.right = bstInsert(tree.right, key);
				tree.size += 1;
			} else {
				// already there, do nothing
			}
			return tree;
		}
	}

	private Tree splay(Tree tree, int key) {
		if (tree != null) {
			if (key < tree.key) {
				tree.left = splay(tree.left, key);
				return rotateRight(tree);
			} else if (key > tree.key) {
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

			int temp = newRoot.size;
			newRoot.size = t.size;
			t.size = temp;

			return newRoot;
		}
		return t;
	}

	private Tree rotateRight(Tree t) {
		if (t.left != null) {
			Tree newRoot = t.left;
			t.left = newRoot.right;
			newRoot.right = t;

			int temp = newRoot.size;
			newRoot.size = t.size;
			t.size = temp;

			return newRoot;
		}
		return t;
	}

	private int size(Tree t) {
		return t == null ? 0 : t.size;
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

	void printLevelorder() {
		printLevelorder(root);
	}

	void printLevelorder(Tree t) {
		if (t != null) {
			Queue<Tree> q = new LinkedList<>();
			q.offer(t);
			int next = 0, print = 1;
			while (!q.isEmpty()) {
				Tree tr = q.poll();
				System.out.print(tr.key + " ");
				if (tr.left != null) {
					q.offer(tr.left);
					next += 1;
				}
				if (tr.right != null) {
					q.offer(tr.right);
					next += 1;
				}
				if (--print == 0) {
					System.out.println();
					print = next;
					next = 0;
				}
			}
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

		// rbt.printInorder();

		rbt.printLevelorder();
	}
}
