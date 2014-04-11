package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:16:38 PM 

public interface Graph {
    
    int V();
    
    int E();
    
    int[] adjacentTo(int v);
    
    boolean hasEdge(int from, int to);
    
    Graph reverse();
}
