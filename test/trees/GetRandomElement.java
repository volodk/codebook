package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:41:09 PM 

public class GetRandomElement {

	class Node {
		int value;
		Node left, right;

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

	private Random rnd = new Random(System.currentTimeMillis());

	public GetRandomElement() {
		root = new Node(0, new Node(1, new Node(3, null, null), new Node(4, null, null)),
				new Node(2, null, new Node(5, null, null)));
	}

	public void printSliceBySlice() {
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
	}

	public int randomlyGet() {

		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		int seen = 0;

		int rValue = root.value;

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n != null) {

				seen += 1;

				if (rnd.nextInt(seen) == 0) {
					rValue = n.value;
				}

				q.offer(n.left);
				q.offer(n.right);
			}
		}

		return rValue;
	}

	public static void main(String[] args) {
		GetRandomElement t = new GetRandomElement();

		t.printSliceBySlice();

		int[] arr = new int[6];
		for (int i = 0; i < 1000000; i++)
			arr[t.randomlyGet()]++;

		System.out.println(Arrays.toString(arr));

	}
}
