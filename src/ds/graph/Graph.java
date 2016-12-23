package ds.graph;

import java.util.List;

public interface Graph {

	int vertices();

	boolean hasPath(int from, int to);

	List<Edge> edges(int from);

	List<Edge> edges();
}
