package graphs.repr.undirected;

import graphs.Graph;
import graphs.Undirected;

import java.util.Arrays;

public class AMUndirectedGraph implements Undirected {
    
    int[][] G;
    int V, E;

    public AMUndirectedGraph(int V) {
        this.V = V;
        G = new int[V][V];
        for (int i = 0; i < V; i++) {
            G[i][i] = 1;
        }
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return G[from][to] == 1;
    }

    @Override
    public int[] adjacentTo(int v) {
        int n = 0;
        for (int j = 0; j < V; j++) {
            if (v != j && G[v][j] != 0)
                n++;
        }
        int[] adj = new int[n];
        for (int j = 0; j < V; j++) {
            if (v != j && G[v][j] != 0)
                adj[adj.length - n--] = j;
        }
        return adj;
    }

    @Override
    public void addEdge(int from, int to) {
        if (G[from][to] == 0) {
            G[from][to] = G[to][from] = 1;
            E++;
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public Graph reverse() {
        AMUndirectedGraph copy = new AMUndirectedGraph(V);
        for (int i = 0; i < V; i++) {
            System.arraycopy(G[i], 0, copy.G[i], 0, V);
        }
        return copy;
    }

    @Override
    public void print() {
        for (int[] row : G) {
            System.out.println(Arrays.toString(row));
        }
    }
}
