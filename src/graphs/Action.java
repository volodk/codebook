package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:48:58 PM 

public interface Action {
    void perform(Graph g, int curr, int[] visited);
}
