package graphs;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:18 PM 

public class AdjacencyListGF implements GraphFactory {

    @Override
    public UndirectedGraph undirectedGraph(final int V) {
        return new AdjacencyListUndirectedGraph(V);
    }

    @Override
    public WeightedGraph weightedGraph(final int V) {
        return new AdjacencyListWeightedGraph(V);
    }

    @Override
    public DirectedGraph directedGraph(final int V) {
        return new AdjacencyListDirectedGraph(V);
    }

}
