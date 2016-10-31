package graphs.path;

import static java.lang.Math.min;
import graphs.WeightedGraph;

import java.util.Arrays;

public class FloydWarshall {

	public static int[][] findShortestPaths(WeightedGraph G) {

		int V = G.V();

		int[][] dist = new int[V][V];
		for (int[] arr : dist) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}

		for (int i = 0; i < V; i++)
			dist[i][i] = 0;

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		return dist;
	}
}
