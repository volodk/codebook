package graphs.traverse;

import graphs.Graph;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:48:58 PM 

public interface Visitor {
    void visit(Graph g, int curr, int[] visited);
}
