package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:16:38 PM 

public interface Graph {
    
    int V();
    
    void addEdge(int from, int to);
    
    int[] adjacentTo(int v);
    
    boolean hasEdge(int from, int to);
}
