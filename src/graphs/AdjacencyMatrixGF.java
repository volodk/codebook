package graphs;

import graphs.repr.directed.AMDirectedGraph;
import graphs.repr.undirected.AMUndirectedGraph;
import graphs.repr.weighted.AMWeightedGraph;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:26:55 PM 

public class AdjacencyMatrixGF implements GraphFactory {
    
    @Override
    public Undirected undirectedGraph(final int V) {
        return new AMUndirectedGraph(V);
    }

    @Override
    public Weighted weightedGraph(final int V) {
        return new AMWeightedGraph(V);
    }

    @Override
    public Directed directedGraph(final int V) {
        return new AMDirectedGraph(V);
    }

}
