package alg.graph.traverse;

import org.junit.Test;

/**
 * Created by volodymyr on 30-12-16.
 */
public class BFSTest {

    @Test
    public void traverseSimpleDirectedGraph(){

        Graph g = new Graph(4).directed()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3);

        g.setVertexValue(0, 1);
        g.setVertexValue(1, 2);
        g.setVertexValue(2, 3);
        g.setVertexValue(3, 4);

        GraphVisitor graphVisitor = new GraphVisitor() {
            @Override
            public void openVertex(Graph g, Integer v) {
                System.out.println(g.getVertexValue(v));
            }
        };

        BFS.traverse(g, 0, graphVisitor);
    }

    @Test
    public void traverseSimpleUndirectedGraph(){

        Graph g = new Graph(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3);

        g.setVertexValue(0, 1);
        g.setVertexValue(1, 2);
        g.setVertexValue(2, 3);
        g.setVertexValue(3, 4);

        GraphVisitor graphVisitor = new GraphVisitor() {
            @Override
            public void openVertex(Graph g, Integer v) {
                System.out.println(g.getVertexValue(v));
            }
        };

        BFS.traverse(g, 0, graphVisitor);
    }
}
