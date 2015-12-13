package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencyListUndirectedGraph implements UndirectedGraph {

	protected int V, E;
	private List<Set<Edge>> adjList;

	public AdjacencyListUndirectedGraph(int V) {
		this.V = V;
		adjList = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adjList.add(new HashSet<Edge>());
		}
	}

	public AdjacencyListUndirectedGraph(int v, int e, List<Set<Edge>> adjList) {
		V = v;
		E = e;
		this.adjList = adjList;
	}

	@Override
	public void addEdge(int from, int to) {
		adjList.get(from).add(Edge.of(from, to));
		adjList.get(to).add(Edge.of(to, from));

		E += 1;
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
		Edge[] edges = (Edge[]) adjList.get(v).toArray();
		int[] arr = new int[edges.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = edges[i].to;
		}
		return arr;
	}

	@Override
	public boolean hasEdge(int from, int to) {
		return adjList.get(from).contains(Edge.of(from, to));
	}

	@Override
	public Graph reverse() {
		List<Set<Edge>> reversedAdjList = new ArrayList<>(V);
		for (Set<Edge> se : adjList) {

			Set<Edge> adjSet = new HashSet<>();
			reversedAdjList.add(adjSet);

			for (Edge e : se) {
				adjSet.add(Edge.reverse(e));
			}
		}
		return new AdjacencyListUndirectedGraph(V, E, reversedAdjList);
	}

	@Override
	public void print() {
		for (int v = 0; v < V; v++) {
			System.out.println(v + " -> " + adjList.get(v));
		}
	}
}
