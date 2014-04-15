package graphs;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:37 PM 

public class EdgeListGF implements GraphFactory {

    @Override
    public UndirectedGraph undirectedGraph(final int V) {
        return new EdgeListUndirectedGraph(V);
    }

    @Override
    public WeightedGraph weightedGraph(final int V) {
        return new EdgeListWeightedGraph(V);
    }

    @Override
    public DirectedGraph directedGraph(final int V) {
        return new EdgeListDirectedGraph(V);
    }

    @Override
    public DirectedWeightedGraph directedWeightedGraph(int V) {
        return new EdgeListDirectedWeightedGraph(V);
    }
    
}
