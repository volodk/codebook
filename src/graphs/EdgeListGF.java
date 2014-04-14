package graphs;

import graphs.repr.directed.ELDirectedGraph;
import graphs.repr.undirected.ELUndirectedGraph;
import graphs.repr.weighted.ELWeightedGraph;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:37 PM 

public class EdgeListGF implements GraphFactory {

    @Override
    public Undirected undirectedGraph(final int V) {
        return new ELUndirectedGraph(V);
    }

    @Override
    public Weighted weightedGraph(final int V) {
        return new ELWeightedGraph(V);
    }

    @Override
    public Directed directedGraph(final int V) {
        return new ELDirectedGraph(V);
    }
    
}
