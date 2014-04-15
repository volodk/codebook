package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:02:04 PM 

public class EdgeListDirectedWeightedGraph implements DirectedWeightedGraph {
    
    private Set<WeightedEdge> edges = new LinkedHashSet<>();

    int V, E;

    public EdgeListDirectedWeightedGraph(int V) {
        this.V = V;
    }

    @Override
    public void addEdge(int from, int to) {
        throw new UnsupportedOperationException("use weigthed method ");
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return edges.size();
    }

    @Override
    public int[] adjacentTo(int v) {
        Set<Integer> adj = new HashSet<>();

        for (WeightedEdge e : edges) {
            if (e.from == v)
                adj.add(e.to);
        }

        int[] arr = new int[adj.size()];
        int i = 0;
        for (Integer w : adj) {
            arr[i++] = w;
        }

        Arrays.sort(arr);

        return arr;
    }

    @Override
    public boolean hasEdge(int from, int to) {
        for ( WeightedEdge e : edges ){
            if(e.from == from && e.to == to){
                return true;
            }
        }
        return false;
    }

    @Override
    public Graph reverse() {
        EdgeListDirectedWeightedGraph reversed = new EdgeListDirectedWeightedGraph(V);
        Set<WeightedEdge> reversedEdges = new LinkedHashSet<>();
        for( WeightedEdge e : edges ){
            reversedEdges.add(WeightedEdge.reverse(e));
        }
        return reversed;
    }

    @Override
    public void print() {
        for (WeightedEdge e : edges) {
            System.out.println(e);
        }
    }

    @Override
    public void addEdge(int from, int to, int w) {
        edges.add(WeightedEdge.of(from, to, w));
    }

    @Override
    public int weight(int from, int to) {
        for( WeightedEdge e : edges ){
            if(e.from == from && e.to == to){
                return e.weight();
            }
        }
        return Integer.MAX_VALUE;
    }

}
