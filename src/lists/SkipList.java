package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:39:15 PM 

public class SkipList {

	private static final int MAX_LEVEL = 16;

	class Node {
		Integer value;
		Node next;

		public Node(Integer value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private Node[] heads = new Node[MAX_LEVEL];

	private Random rnd = new Random();

	public SkipList(Integer... values) {
		this(Arrays.asList(values));
	}

	public SkipList(Collection<Integer> values) {
		List<Integer> copy = new ArrayList<>(values);
		Collections.sort(copy);

		for (Integer i : copy) {
			insert(i);
		}
	}

	public void insert(Integer i) {

	}

	public void remove(Integer i) {

	}

	public boolean contains(Integer i) {
		return false;
	}

	public void print() {

	}

}
