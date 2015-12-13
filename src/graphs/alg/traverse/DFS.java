package graphs.alg.traverse;

import graphs.Graph;

import java.util.Stack;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:50:35 PM 

public class DFS {

	public static void traverse(Graph g) {
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[g.V()];

		for (int v = 0; v < g.V(); v++) {
			stack.push(v);
			while (!stack.isEmpty()) {
				Integer curr = stack.pop();
				visited[curr] = 1;
				// visitor.visit(g, curr, visited);
				for (Integer next : g.adjacentTo(curr)) {
					if (visited[next] == 0) {
						stack.push(next);
					}
				}
			}
		}
	}

	public static void traverse(Graph g, int from) {
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[g.V()];
		stack.push(from);
		while (!stack.isEmpty()) {
			Integer curr = stack.pop();
			visited[curr] = 1;
			// visitor.visit(g, curr, visited);
			for (Integer next : g.adjacentTo(curr)) {
				if (visited[next] == 0) {
					stack.push(next);
				}
			}
		}
	}
}
