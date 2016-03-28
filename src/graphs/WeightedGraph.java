package graphs;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 6:16:50 PM 

public interface WeightedGraph extends Graph {
	void addEdge(int from, int to, int w);

	int weight(int from, int to);
}
