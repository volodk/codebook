package graphs;

import graphs.repr.directed.ALDirectedGraph;
import graphs.repr.undirected.ALUndirectedGraph;
import graphs.repr.weighted.ALWeightedGraph;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:18 PM 

public class AdjacencyListGF implements GraphFactory {

    @Override
    public Undirected undirectedGraph(final int V) {
        return new ALUndirectedGraph(V);
    }

    @Override
    public Weighted weightedGraph(final int V) {
        return new ALWeightedGraph(V);
    }

    @Override
    public Directed directedGraph(final int V) {
        return new ALDirectedGraph(V);
    }

}
