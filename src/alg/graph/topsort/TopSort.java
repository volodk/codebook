package alg.graph.topsort;

import alg.graph.DirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopSort {

	public static void printTopologicalOrder(final DirectedGraph g) {
		System.out.println(topologicalOrdering(g));
	}

	public static List<Integer> topologicalOrdering(final DirectedGraph g) {
		Stack<Integer> stack = new Stack<>(), topsort = new Stack<>();
		int[] visited = new int[g.V()];
		for (int v = 0; v < g.V(); v++) {
			if (visited[v] == 0) {
				stack.push(v);
				while (!stack.isEmpty()) {
					Integer curr = stack.pop();
					if (visited[curr] == 0) {
						visited[curr] = 1;
						topsort.push(curr);
						for (Integer next : g.adjacentTo(curr)) {
							stack.push(next);
						}
					}
				}
			}
		}
		return new ArrayList<>(topsort);
	}
}
