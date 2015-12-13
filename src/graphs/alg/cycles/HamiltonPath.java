package graphs.alg.cycles;

import java.util.Arrays;

import graphs.AbstractGraphFactory;
import graphs.GraphFactory;
import graphs.UndirectedGraph;
import graphs.GraphFactory.StorageType;

public class HamiltonPath {

	private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory
			.getFactory(StorageType.ADJACENCY_MATRIX);
	private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory
			.getFactory(StorageType.ADJACENCY_LIST);
	private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);

	public static int[] findPath(final UndirectedGraph g) {
		return new int[] {};
	}

	public static void main(String... args) {

		// (1)
		// *-----*
		// |\ /|
		// | *-* |
		// | | | |
		// | *-* |
		// |/ \|
		// *-----*
		// (0)

		UndirectedGraph ug = ADJACENCY_MATRIX_GRAPH_FACTORY.undirectedGraph(8);

		ug.addEdge(0, 1);
		ug.addEdge(0, 3);
		ug.addEdge(0, 7);

		ug.addEdge(1, 0);
		ug.addEdge(1, 2);
		ug.addEdge(1, 6);

		ug.addEdge(2, 1);
		ug.addEdge(2, 3);
		ug.addEdge(2, 5);

		ug.addEdge(3, 2);
		ug.addEdge(3, 0);
		ug.addEdge(3, 4);

		ug.addEdge(4, 3);
		ug.addEdge(4, 5);
		ug.addEdge(4, 7);

		ug.addEdge(5, 2);
		ug.addEdge(5, 4);
		ug.addEdge(5, 6);

		ug.addEdge(6, 1);
		ug.addEdge(6, 5);
		ug.addEdge(6, 7);

		ug.addEdge(7, 0);
		ug.addEdge(7, 4);
		ug.addEdge(7, 6);

		int[] path = findPath(ug);

		System.out.println(Arrays.toString(path));

	}
}
