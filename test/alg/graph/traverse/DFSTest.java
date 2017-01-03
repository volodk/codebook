package alg.graph.traverse;

import ds.graph.Graph;
import org.junit.Test;

/**
 * Created by volodymyr on 1-1-17.
 */
public class DFSTest {

    @Test
    public void traverseSimpleGraph(){

//        A
//        |\
//        B C
//        |\|\
//        DEFG
        Graph g = new Graph(7)
                .setVertexValue(0, 'A')
                .setVertexValue(1, 'B')
                .setVertexValue(2, 'C')
                .setVertexValue(3, 'D')
                .setVertexValue(4, 'E')
                .setVertexValue(5, 'F')
                .setVertexValue(6, 'G')
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .addEdge(2, 6);

        DFS.traverse(g, 0, (gr, v) -> {System.out.println(g.getVertexValue(v)); } );

    }
}
