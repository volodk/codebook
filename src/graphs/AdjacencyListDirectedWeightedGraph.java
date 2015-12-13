package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:01:25 PM 

public class AdjacencyListDirectedWeightedGraph implements DirectedWeightedGraph {

	int V, E;
	List<Set<WeightedEdge>> adjList;

	public AdjacencyListDirectedWeightedGraph(int V) {
		this.V = V;
		adjList = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adjList.add(new HashSet<WeightedEdge>());
		}
	}

	public AdjacencyListDirectedWeightedGraph(int V, int E, List<Set<WeightedEdge>> reversedAdjList) {
		this.V = V;
		this.E = E;
		this.adjList = reversedAdjList;
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
		return E;
	}

	@Override
	public int[] adjacentTo(int v) {
		WeightedEdge[] WeightedEdges = (WeightedEdge[]) adjList.get(v).toArray();
		int[] arr = new int[WeightedEdges.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = WeightedEdges[i].to;
		}
		return arr;
	}

	@Override
	public boolean hasEdge(int from, int to) {
		for (Set<WeightedEdge> wes : adjList) {
			for (WeightedEdge e : wes) {
				if (e.from == from && e.to == to) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Graph reverse() {
		List<Set<WeightedEdge>> reversedAdjList = new ArrayList<>(V);
		for (Set<WeightedEdge> se : adjList) {

			Set<WeightedEdge> adjSet = new HashSet<>();
			reversedAdjList.add(adjSet);

			for (WeightedEdge e : se) {
				adjSet.add(WeightedEdge.reverse(e));
			}
		}
		return new AdjacencyListDirectedWeightedGraph(V, E, reversedAdjList);
	}

	@Override
	public void print() {
		for (int v = 0; v < V; v++) {
			System.out.println(v + " -> " + adjList.get(v));
		}
	}

	@Override
	public void addEdge(int from, int to, int w) {
		adjList.get(from).add(WeightedEdge.of(from, to, w));
		E += 1;
	}

	@Override
	public int weight(int from, int to) {
		for (WeightedEdge e : adjList.get(from)) {
			if (e.from == from && e.to == to) {
				return e.weight();
			}
		}
		return Integer.MAX_VALUE;
	}

}
