package graphs.path;

import graphs.WeightedGraph;

import java.util.PriorityQueue;

public class Dijkstra {

	public static int[] distanceToAll(WeightedGraph g, int from) {
		int[] dist = new int[g.V()];

		for (int v = 0; v < g.V(); v++) {
			dist[v] = Integer.MAX_VALUE;
		}

		dist[from] = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		return dist;
	}

}
