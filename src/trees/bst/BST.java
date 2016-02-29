package trees.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST<K extends Comparable<? super K>, V> {

	class Node {
		K key;
		V value;
		Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("%s:%s", key, value);
		}
	}

	Node root;

	// interface
	public void insert(K key, V value) {
		insert(root, new Node(key, value));
	}

	public boolean delete(K key) {
		Node delete = find(root, key);
		if (delete != null) {

			return true;
		}
		return false;
	}

	public V find(K key) {
		Node n = find(root, key);
		return n == null ? null : n.value;
	}

	// implementation

	Node find(Node root, K key) {
		if (root == null)
			return null;
		else if (root.key.compareTo(key) < 0)
			return find(root.left, key);
		else if (root.key.compareTo(key) > 0)
			return find(root.right, key);
		else
			return root;
	}

	Node insert(Node root, Node insert) {
		if (root == null)
			return insert;
		if (root.key.compareTo(insert.key) < 0) {
			return root.left = insert(root.left, insert);
		} else if (root.key.compareTo(insert.key) > 0) {
			return root.right = insert(root.right, insert);
		} else {
			root.value = insert.value;
			return root;
		}
	}

	Node predecessor(Node n) {
		return null;
	}

	Node successor(Node n) {
		return null;
	}

	// utility method

	public void print() {
		System.out.println("\n");

		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		int leftover = 1, next = 0;

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
			if (--leftover == 0) {
				System.out.println();
				leftover = next;
				next = 0;
			}

		}

		System.out.println("\n");
	}
}
