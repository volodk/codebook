package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:34:36 PM 

class WeightedEdge extends Edge implements Comparable<WeightedEdge> {

	private int weight;

	public WeightedEdge(int from, int to, int w) {
		super(from, to);
		this.weight = w;
	}

	public static final WeightedEdge of(int from, int to, int w) {
		return new WeightedEdge(from, to, w);
	}

	public int weight() {
		return weight;
	}

	public static WeightedEdge reverse(WeightedEdge e) {
		return WeightedEdge.of(e.to, e.from, e.weight);
	}

	@Override
	public String toString() {
		return from + "-" + to + "(" + weight + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + weight + either() + other();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedEdge we2 = (WeightedEdge) obj;
		if (either() != we2.either() || other() != we2.other() || weight != we2.weight)
			return false;
		return true;
	}

	@Override
	public int compareTo(WeightedEdge we) {
		return weight - we.weight;
	}

}
