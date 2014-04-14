package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EdgeListWeightedGraph implements WeightedGraph{

    private Set<WeightedEdge> edges = new LinkedHashSet<>();
    
    int V, E;
    
    public EdgeListWeightedGraph(int V) {
        this.V = V;
    }

    @Override
    public int V() { return V; }

    @Override
    public int E() {
        return edges.size();
    }

    @Override
    public int[] adjacentTo(int v) {
        Set<Integer> adj = new HashSet<>();
        
        for( WeightedEdge e : edges ){
            if(e.from == v)
                adj.add(e.to);
            if(e.to == v)
                adj.add(e.from);
        }
        
        int[] arr = new int[adj.size()];
        int i = 0;
        for(Integer w : adj){
            arr[i++] = w; 
        }
        
        Arrays.sort(arr);
        
        return arr;
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return edges.contains(Edge.of(from, to));
    }
    
    @Override
    public void addEdge(int from, int to, int weight) {
        edges.add(WeightedEdge.of(from, to, weight));
    }

    @Override
    public Graph reverse() {
        EdgeListWeightedGraph reversed = new EdgeListWeightedGraph(V);
        Set<WeightedEdge> reversedEdges = new LinkedHashSet<>();
        for( WeightedEdge e : edges ){
            reversedEdges.add(WeightedEdge.reverse(e));
        }
        return reversed;
    }

    @Override
    public void print() {
        for( WeightedEdge e: edges){
            System.out.println(e);
        }
    }

    @Override
    public int weight(int from, int to) {
        for( WeightedEdge e : edges ){
            if(e.from == from && e.to == to){
                return e.weight;
            }
        }
        return Integer.MAX_VALUE;
    }
}
