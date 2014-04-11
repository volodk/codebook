package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:34:36 PM 

public class WeightedEdge extends Edge{
    
    int from, to, weight;
    
    public WeightedEdge(int from, int to, int w) {
        super(from, to);
        this.weight = w;
    }
       
    public static WeightedEdge of(int from, int to, int w){
        return new WeightedEdge(from, to, w);
    }
    
    public int weight(){ return weight; }
    
    public static WeightedEdge reverse(WeightedEdge e) {
        return WeightedEdge.of(e.to, e.from, e.weight);
    }
   
}

