package trees;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class NaryTree {

	static class Node {
		int value;
		List<Node> children;

		public Node(int value) {
			this(value, new ArrayList<Node>());
		}

		public Node(int value, List<Node> children) {
			this.value = value;
			this.children = children;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((children == null) ? 0 : children.hashCode());
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (children == null) {
				if (other.children != null)
					return false;
			} else if (!children.equals(other.children))
				return false;
			if (value != other.value)
				return false;
			return true;
		}
	}

	static void serialize(Node tree, Writer w) throws IOException {
		if (tree != null) {
			w.append(String.format("%d[%d]", tree.value, tree.children.size()));
			for (Node child : tree.children) {
				serialize(child, w);
			}
		}
	}

	static Node deseriaize(Reader r) throws IOException {

		int[] pair = nextToken(r);

		int value = pair[0], count = pair[1];
		Node t = new Node(value);

		for (int i = 0; i < count; i++) {
			t.children.add(deseriaize(r));
		}

		return t;
	}

	private static int[] nextToken(Reader r) throws IOException {

		int value, childrenCount;

		// extract value
		StringBuilder sb = new StringBuilder();
		char ch;
		do {
			ch = (char) r.read();
			if (ch != '[')
				sb.append(ch);
		} while (ch != '[');
		value = Integer.parseInt(sb.toString());

		// extract children count
		sb = new StringBuilder();
		do {
			ch = (char) r.read();
			if (ch != ']')
				sb.append(ch);
		} while (ch != ']');
		childrenCount = Integer.parseInt(sb.toString());

		return new int[] { value, childrenCount };
	}

	public static void main(String[] args) throws IOException {

		Node tree = new Node(100, asList(new Node(21, asList(new Node(322), new Node(41), new Node(5))), new Node(65),
				new Node(77777, asList(new Node(8)))));

		// Node tree = new Node(100);

		StringWriter sw = new StringWriter();
		serialize(tree, sw);

		String str = sw.toString();
		System.out.println(str);

		StringReader sr = new StringReader(sw.toString());

		Node newTree = deseriaize(sr);

		System.out.println(tree.equals(newTree));

	}

}
