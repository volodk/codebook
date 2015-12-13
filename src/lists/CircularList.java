package lists;

public class CircularList {

	class Node {
		Object value;
		Node next;

		public Node(Object value) {
			this.value = value;
		}
	}

	private int total;
	private Node current;

	public CircularList(int total) {
		this.total = total;
		Node prev = new Node(null);
		current = prev;
		for (int i = 1; i < total; i++) {
			Node p = new Node(null);
			prev.next = p;
			prev = p;
		}
		prev.next = current;
	}

	void add(Object o) {
		current.value = o;
		current = current.next;
	}

	void print() {
		for (int i = 0; i < total; i++) {
			System.out.print(current.value);
			System.out.print(" ");
			current = current.next;
		}
		System.out.println();
	}

	void shift(int step) {
		while (step-- > 0) {
			current = current.next;
		}
	}

	public static void main(String[] args) {

		CircularList ringBuff = new CircularList(10);
		for (int i = 0; i < 15; i++) {
			ringBuff.add(i);
		}

		ringBuff.print();

		ringBuff.shift(3);

		ringBuff.print();
	}

}
