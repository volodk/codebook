package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:03:11 PM 

public interface GraphFactory {

	enum StorageType {
		ADJACENCY_MATRIX, ADJACENCY_LIST, EDGE_LIST
	}

	UndirectedGraph undirectedGraph(final int V);

	WeightedGraph weightedGraph(final int V);

	DirectedGraph directedGraph(final int V);

	DirectedWeightedGraph directedWeightedGraph(final int V);
}
