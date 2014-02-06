package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:03:11 PM 

public interface GraphFactory {
    
    enum StorageType {
        ADJACENCY_MATRIX, ADJACENCY_LIST, EDGE_LIST
    }
    
    Graph regularGraph();
    
    Weighted weightedGraph();
    
    Directed directedGraph();
    
    WeightedDirected weightedDirectedGraph();
}
