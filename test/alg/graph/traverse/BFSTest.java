package alg.graph.traverse;

import ds.graph.Graph;
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

        BFS.traverse(g, 0, (gr, v)-> { System.out.println(gr.getVertexValue(v)); } );
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

        BFS.traverse(g, 0, (gr, v)-> { System.out.println(gr.getVertexValue(v)); } );
    }
}
