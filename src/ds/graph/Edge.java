package ds.graph;

public class Edge {

	int from, to;

	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge edge = (Edge) o;
		if (from != edge.from) return false;
		return to == edge.to;
	}

	@Override
	public int hashCode() {
		int result = from;
		result = 31 * result + to;
		return result;
	}
}
