package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:03:11 PM 

public interface GraphFactory {
    
    enum StorageType {
        ADJACENCY_MATRIX, ADJACENCY_LIST, EDGE_LIST
    }
        
    Graph undirectedGraph(final int V);
    
    Graph weightedGraph(final int V);
    
    Graph directedGraph(final int V);
    
    Graph weightedDirectedGraph(final int V);
}
