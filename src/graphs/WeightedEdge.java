package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:49:22 PM 

public class WeightedEdge extends Edge {
    int weight;

    public WeightedEdge(int from, int to, int weight) {
        super(from, to);
        this.weight = weight;
    }
    
}
