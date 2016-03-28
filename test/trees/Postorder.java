package trees;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:52:24 PM 

public class Postorder {

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
			printRec(node.left);
			printRec(node.right);
			visit(node);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
