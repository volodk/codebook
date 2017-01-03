package alg.tree.traverse;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:52:24 PM 

public class Preorder {

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

	}

	void printRec(Node node) {
		if (node != null) {
			visit(node);
			printRec(node.left);
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
				while (pred.right != null && pred.right != curr) {
					pred = pred.right;
				}

				if (pred.right == null) {
					visit(curr);
					pred.right = curr;
					curr = curr.left;
				} else {
					pred.right = null;
					curr = curr.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
