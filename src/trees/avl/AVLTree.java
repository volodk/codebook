package trees.avl;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:48:23 PM 

public class AVLTree<K extends Comparable<? super K>, V> {

	class Node {
		int h = 1;
		K key;
		V value;
		Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("%s", key);
		}
	}

	Node root;

	public void insert(K key, V value) {
		root = insert(root, key, value);
	}

	public void delete(K key) {
		root = delete(root, key);
	}

	public V find(K key) {
		Node n = find(root, key);
		return n == null ? null : n.value;
	}

	Node balance(Node tree) {
		if (tree == null)
			return null;

		if (Math.abs(height(tree.left) - height(tree.right)) <= 1) {
			return tree;
		} else {
			if (height(tree.left) > height(tree.right)) {
				Node n = tree.left;
				if (height(n.left) < height(n.right)) {
					tree.left = rotateLeft(tree.left);
					updateHeight(tree.left);
				}
				return rotateRight(updateHeight(tree));
			} else {
				Node n = tree.right;
				if (height(n.left) > height(n.right)) {
					tree.right = rotateRight(tree.right);
					updateHeight(tree.right);
				}
				return rotateLeft(updateHeight(tree));
			}
		}
	}

	Node insert(Node curr, K key, V value) {
		if (curr == null) {
			return new Node(key, value);
		} else {
			if (lt(key, curr.key)) {
				curr.left = insert(curr.left, key, value);
				return balance(updateHeight(curr));
			} else if (gt(key, curr.key)) {
				curr.right = insert(curr.right, key, value);
				return balance(updateHeight(curr));
			} else {
				curr.value = value;
			}
			return curr;
		}
	}

	private Node updateHeight(Node curr) {
		curr.h = 1 + Math.max(height(curr.left), height(curr.right));
		return curr;
	}

	Node delete(Node curr, K key) {
		if (curr == null)
			return null;
		if (lt(key, curr.key)) {
			curr.left = delete(curr.left, key);
			return balance(updateHeight(curr));
		} else if (gt(key, curr.key)) {
			curr.right = delete(curr.right, key);
			return balance(updateHeight(curr));
		} else {
			if (curr.left == null && curr.right == null) {
				return null;
			} else {
				if (curr.left != null && curr.right != null) {
					Node replace = max(curr.left);
					curr.key = replace.key;
					curr.left = delete(curr.left, replace.key);
					return curr;
				} else if (curr.left != null) {
					return curr.left;
				} else /* if(curr.right != null) */
				{
					return curr.right;
				}
			}
		}
	}

	Node find(Node curr, K key) {
		if (curr == null || curr.key.equals(key))
			return curr;
		if (lt(key, curr.key))
			return find(curr.left, key);
		else
			return find(curr.right, key);
	}

	int size(Node tree) {
		if (tree == null)
			return 0;
		else
			return 1 + size(tree.left) + size(tree.right);
	}

	int height(Node tree) {
		if (tree == null)
			return 0;
		return tree.h;
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
		if (oldRoot == null)
			return null;
		if (oldRoot.right == null)
			return oldRoot;

		Node newRoot = oldRoot.right;
		oldRoot.right = newRoot.left;
		newRoot.left = oldRoot;

		updateHeight(oldRoot);

		return newRoot;
	}

	Node rotateRight(Node oldRoot) {
		if (oldRoot == null)
			return null;
		if (oldRoot.left == null)
			return oldRoot;

		Node newRoot = oldRoot.left;
		oldRoot.left = newRoot.right;
		newRoot.right = oldRoot;

		updateHeight(oldRoot);

		return newRoot;
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

	void inorderKeysDump(Node tree, List<? super K> buffer) {
		Objects.requireNonNull(buffer);
		if (tree != null) {
			inorderKeysDump(tree.left, buffer);
			buffer.add(tree.key);
			inorderKeysDump(tree.right, buffer);
		}
	}

	boolean isBST(Node curr) {
		if (curr == null)
			return true;
		return isBST(curr.left) && (gt(curr, curr.left) && le(curr, curr.right)) && isBST(curr.right);
	}

	boolean isBalanced(Node curr) {
		if (curr == null)
			return true;
		return isBalanced(curr.left) && (Math.abs(height(curr.left) - height(curr.right)) <= 1)
				&& isBalanced(curr.right);
	}

	public void print() {
		Queue<Node> q = new LinkedList<>();
		if (root != null)
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

}
