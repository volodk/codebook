package graphs;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 2:34:36 PM 

class Edge {

	protected int from, to;

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public static Edge of(int from, int to) {
		return new Edge(from, to);
	}

	public int either() {
		return from;
	}

	public int other() {
		return to;
	}

	public static final Edge reverse(Edge e) {
		return Edge.of(e.to, e.from);
	}

	@Override
	public String toString() {
		return from + "-" + to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + to;
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
		Edge other = (Edge) obj;
		if (from != other.from)
			return false;
		if (to != other.to)
			return false;
		return true;
	}

}
