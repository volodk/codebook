package alg.tree.traverse;

import java.util.LinkedList;
import java.util.Queue;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:52:24 PM 

public class LevelByLevel {

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
		System.out.print(" ");
		System.out.print(n.value);
		System.out.print(" ");
	}

	void print(Node node) {
		if (node != null) {
			int nextLevel = 0, print = 1;
			Queue<Node> q = new LinkedList<>();
			q.offer(node);
			while (!q.isEmpty()) {
				Node n = q.poll();
				if (n != null) {
					visit(n);
					q.offer(n.left);
					if (n.left != null)
						nextLevel += 1;
					q.offer(n.right);
					if (n.right != null)
						nextLevel += 1;
					if (--print == 0) {
						System.out.println();
						print = nextLevel;
						nextLevel = 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
	    Node tree = new Node(1, new Node(2, new Node(4, null, null), new Node(5, null, null)), new Node(3, null, null));

		LevelByLevel tr = new LevelByLevel();

		tr.print(tree);
	}

}
