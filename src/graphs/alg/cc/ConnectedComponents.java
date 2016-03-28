package graphs.alg.cc;

import graphs.Graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 4:31:53 PM 

public class ConnectedComponents {

	static Random rnd = new Random();

	public static boolean isConnected(Graph g) {

		Deque<Integer> stack = new LinkedList<>();
		int marked[] = new int[g.V()];

		stack.push(rnd.nextInt(g.V()));

		while (!stack.isEmpty()) {
			Integer v = stack.pop();

			marked[v] = 1;
			for (Integer vv : g.adjacentTo(v)) {
				if (marked[vv] == 0) {
					stack.push(vv);
				}
			}
		}

		for (int i : marked) {
			if (i == 0)
				return false;
		}

		return true;
	}

	public static void printConnectedComponents(Graph g) {

		Deque<Integer> stack = new LinkedList<>();

		int[] mark = new int[g.V()];

		int color = 0;

		for (int i = 0; i < g.V(); i++) {

			stack.push(i);
			if (mark[i] == 0)
				color += 1;

			while (!stack.isEmpty()) {
				Integer v = stack.pop();
				if (mark[v] == 0) {
					mark[v] = color;
					for (Integer vv : g.adjacentTo(v)) {
						stack.push(vv);
					}
				}
			}

		}

		System.out.println(Arrays.toString(mark));

	}
}
