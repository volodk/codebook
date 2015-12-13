package graphs;

import java.util.Arrays;

public class AdjacencyMatrixWeightedGraph implements WeightedGraph {

	int[][] G;
	int V, E;

	public AdjacencyMatrixWeightedGraph(int V) {
		this.V = V;
		G = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				G[i][j] = Integer.MAX_VALUE;
			}
			G[i][i] = 0;
		}
	}

	@Override
	public boolean hasEdge(int from, int to) {
		return G[from][to] < Integer.MAX_VALUE;
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
	public void addEdge(int from, int to, int w) {
		if (G[from][to] == Integer.MAX_VALUE) {
			G[from][to] = G[to][from] = w;
			E++;
		}
	}

	@Override
	public int weight(int from, int to) {
		return G[from][to];
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
		AdjacencyMatrixWeightedGraph copy = new AdjacencyMatrixWeightedGraph(V);
		copy.E = E;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				copy.G[i][j] = G[j][i];
			}
		}

		return copy;
	}

	@Override
	public void print() {
		for (int[] row : G) {
			System.out.println(Arrays.toString(row).replaceAll(String.valueOf(Integer.MAX_VALUE), "INF"));
		}
	}

}
