package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	Node root;

	public Node inorderSuccessor(Node node) {
		return null;
	}

	public Node inorderPredecesor(Node node) {
		return null;
	}

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
