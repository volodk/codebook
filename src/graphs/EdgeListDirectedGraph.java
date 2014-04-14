package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EdgeListDirectedGraph implements DirectedGraph {

    private Set<Edge> edges = new LinkedHashSet<>();

    int V, E;

    public EdgeListDirectedGraph(int V) {
        this.V = V;
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

        for (Edge e : edges) {
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
        return edges.contains(Edge.of(from, to));
    }

    @Override
    public void addEdge(int from, int to) {
        edges.add(Edge.of(from, to));
    }

    @Override
    public Graph reverse() {
        EdgeListUndirectedGraph reversed = new EdgeListUndirectedGraph(V);
        Set<Edge> reversedEdges = new LinkedHashSet<>();
        for (Edge e : edges) {
            reversedEdges.add(Edge.reverse(e));
        }
        return reversed;
    }

    @Override
    public void print() {
        for (Edge e : edges) {
            System.out.println(e);
        }
    }

}
