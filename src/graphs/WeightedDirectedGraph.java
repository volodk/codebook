package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:37:10 PM 

public class WeightedDirectedGraph extends DirectedGraph implements Weighted {

    public WeightedDirectedGraph(int V) {
        super(V);
    }
    
    public WeightedDirectedGraph(int V, boolean allowLoops) {
        super(V, allowLoops);
    }

    @Override
    public int weight(int from, int to) {
        // TODO Auto-generated method stub
        return 0;
    }

}
