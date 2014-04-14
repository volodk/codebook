package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:03:11 PM 

public interface GraphFactory {
    
    enum StorageType {
        ADJACENCY_MATRIX, ADJACENCY_LIST, EDGE_LIST
    }
        
    Undirected undirectedGraph(final int V);
    
    Weighted weightedGraph(final int V);
    
    Directed directedGraph(final int V);
    
//    Graph weightedDirectedGraph(final int V);
}
