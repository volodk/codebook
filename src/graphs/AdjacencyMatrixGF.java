package graphs;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 6:26:55 PM 

public class AdjacencyMatrixGF implements GraphFactory {

	@Override
	public AdjacencyMatrixUndirectedGraph undirectedGraph(final int V) {
		return new AdjacencyMatrixUndirectedGraph(V);
	}

	@Override
	public AdjacencyMatrixWeightedGraph weightedGraph(final int V) {
		return new AdjacencyMatrixWeightedGraph(V);
	}

	@Override
	public AdjacencyMatrixDirectedGraph directedGraph(final int V) {
		return new AdjacencyMatrixDirectedGraph(V);
	}

	@Override
	public AdjacencyMatrixDirectedWeightedGraph directedWeightedGraph(int V) {
		return new AdjacencyMatrixDirectedWeightedGraph(V);
	}

}
