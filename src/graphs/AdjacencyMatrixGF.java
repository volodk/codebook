package graphs;



// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:26:55 PM 

public class AdjacencyMatrixGF implements GraphFactory {
    
    @Override
    public UndirectedGraph undirectedGraph(final int V) {
        return new AdjacencyMatrixUndirectedGraph(V);
    }

    @Override
    public WeightedGraph weightedGraph(final int V) {
        return new AdjacencyMatrixWeightedGraph(V);
    }

    @Override
    public DirectedGraph directedGraph(final int V) {
        return new AdjacencyMatrixDirectedGraph(V);
    }

}
