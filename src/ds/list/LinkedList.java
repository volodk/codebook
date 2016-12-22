package ds.list;

public class LinkedList {

	static class Node {
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public static void main(String[] args) {

		Node list = new Node(0, new Node(1, new Node(2, new Node(3, null))));

		print(list);
		System.out.println();

		reversePrint(list);
		System.out.println();

		Node r = reverse(list);
		print(r);

	}

	private static Node reverse(Node n) {
		if (n == null)
			return null;
		if (n.next == null)
			return n;

		Node head = n, tail = n.next;
		head.next = null;

		Node _head = reverse(tail);
		tail.next = head;

		return _head;
	}

	private static void print(Node n) {
		if (n != null) {
			System.out.println(n.value);
			print(n.next);
		}
	}

	private static void reversePrint(Node n) {
		if (n != null) {
			reversePrint(n.next);
			System.out.println(n.value);
		}
	}

}
