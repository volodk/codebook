package graphs.cycles;

import graphs.DirectedGraph;

import java.util.Stack;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:37:16 PM 

public class CycleDetector {

	public static boolean hasNoCycle(final DirectedGraph g) {

		Stack<Integer> stack = new Stack<>();
		int[] market = new int[g.V()];

		// 0 - open
		// 1 - in cycle
		// 2 - closed

		for (int v = 0; v < g.V(); v++) {
			stack.push(v);

			while (!stack.isEmpty()) {
				Integer curr = stack.pop();
				market[curr] = 1;

				// todo

				for (Integer next : g.adjacentTo(curr)) {
					if (market[next] == 0) {
						stack.push(next);
					} else {
						return false; // cycle detected
					}
				}
			}
		}

		return true;
	}

	public static void printCycles(DirectedGraph g) {
		if (hasNoCycle(g)) {
			System.out.println("No cycles detected, graph is DAG");
		} else {

		}
	}
}
