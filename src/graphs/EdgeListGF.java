package graphs;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:37 PM 

public class EdgeListGF implements GraphFactory {

    @Override
    public EdgeListUndirectedGraph undirectedGraph(final int V) {
        return new EdgeListUndirectedGraph(V);
    }

    @Override
    public EdgeListWeightedGraph weightedGraph(final int V) {
        return new EdgeListWeightedGraph(V);
    }

    @Override
    public EdgeListDirectedGraph directedGraph(final int V) {
        return new EdgeListDirectedGraph(V);
    }

    @Override
    public EdgeListDirectedWeightedGraph directedWeightedGraph(int V) {
        return new EdgeListDirectedWeightedGraph(V);
    }
    
}
