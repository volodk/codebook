package graphs;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:18 PM 

public class AdjacencyListGF implements GraphFactory {

    @Override
    public AdjacencyListUndirectedGraph undirectedGraph(final int V) {
        return new AdjacencyListUndirectedGraph(V);
    }

    @Override
    public AdjacencyListWeightedGraph weightedGraph(final int V) {
        return new AdjacencyListWeightedGraph(V);
    }

    @Override
    public AdjacencyListDirectedGraph directedGraph(final int V) {
        return new AdjacencyListDirectedGraph(V);
    }

    @Override
    public AdjacencyListDirectedWeightedGraph directedWeightedGraph(int V) {
        return new AdjacencyListDirectedWeightedGraph(V);
    }

}
