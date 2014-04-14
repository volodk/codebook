package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:34:36 PM 

public class WeightedEdge{
    
    public int from, to, weight;
    
    public WeightedEdge(int from, int to, int w) {
        this.from = from;
        this.to = to;
        this.weight = w;
    }
       
    public static WeightedEdge of(int from, int to, int w){
        return new WeightedEdge(from, to, w);
    }
    
    public int weight(){ return weight; }
    
    public static WeightedEdge reverse(WeightedEdge e) {
        return WeightedEdge.of(e.to, e.from, e.weight);
    }
    
    @Override
    public String toString() {
        return from + "-" + to + "(" + weight + ")";
    }
   
}

