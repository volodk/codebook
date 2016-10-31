package graphs.cycles;

import java.util.Arrays;

import graphs.AbstractGraphFactory;
import graphs.GraphFactory;
import graphs.UndirectedGraph;
import graphs.GraphFactory.StorageType;

public class EulerPath {

	private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory
			.getFactory(StorageType.ADJACENCY_MATRIX);
	private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory
			.getFactory(StorageType.ADJACENCY_LIST);
	private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);

	public static int[] findPath(final UndirectedGraph g) {
		return new int[] {};
	}

	public static void main(String... args) {
		// draw an envelop :)

		// *
		// / \
		// *---*
		// | X |
		// *---*

		UndirectedGraph ug = ADJACENCY_MATRIX_GRAPH_FACTORY.undirectedGraph(5);

		ug.addEdge(0, 1);
		ug.addEdge(0, 4);

		ug.addEdge(1, 0);
		ug.addEdge(1, 2);
		ug.addEdge(1, 3);
		ug.addEdge(1, 4);

		ug.addEdge(2, 1);
		ug.addEdge(2, 4);
		ug.addEdge(2, 3);

		ug.addEdge(3, 1);
		ug.addEdge(3, 2);
		ug.addEdge(3, 4);

		ug.addEdge(4, 0);
		ug.addEdge(4, 1);
		ug.addEdge(4, 2);
		ug.addEdge(4, 3);

		int[] path = findPath(ug);

		System.out.println(Arrays.toString(path));

	}
}
