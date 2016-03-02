package trees;

import java.util.Stack;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:52:24 PM 

public class Inorder {

	static class Node {
		int value;
		Node left, right;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	void visit(Node n) {
		System.out.println(n.value);
	}

	void print(Node node) {
		if (node != null) {
			Stack<Node> st = new Stack<>();

		}
	}

	void printRec(Node node) {
		if (node != null) {
			printRec(node.left);
			visit(node);
			printRec(node.right);
		}
	}

	void printMorris(Node node) {
		Node curr = node;
		while (curr != null) {
			if (curr.left == null) {
				visit(curr);
				curr = curr.right;
			} else {
				Node pred = curr.left;
				while (pred.right != null && pred.right != curr)
					pred = pred.right;
				if (pred.right == null) {
					pred.right = curr;
					curr = curr.left;
				} else {
					pred.right = null;
					visit(curr);
					curr = curr.right;
				}
			}
		}
	}

	public static void main(String[] args) {

		// Node tree = new Node(1, new Node(2, new Node(4, null, null), new
		// Node(5, null, null)), new Node(3, null, null));

		Node tree = new Node(2, new Node(1, null, null), new Node(5, null, null));

		Inorder traversal = new Inorder();

		traversal.print(tree);
		System.out.println();
		traversal.printRec(tree);
		System.out.println();
		traversal.printMorris(tree);

	}

}
