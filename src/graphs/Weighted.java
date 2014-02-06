package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:16:50 PM 

public interface Weighted extends Graph {

    void addEdge(int from, int to, int w);
    
    int weight(int from, int to);
}
