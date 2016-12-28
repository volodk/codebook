package ds.graph;

import org.junit.Test;

import java.util.Random;

/**
 * Created by volodymyr on 27-12-16.
 */
public class GraphTest {

    @Test
    public void createGraph(){
        int V = 100, E = 200;
        Graph<Integer, Integer> g = new Graph<>(V, true);

        Random rnd = new Random();

        for (int i = 0; i < E; i++){
            int from = rnd.nextInt(V);
            int to = rnd.nextInt(V);
            g.addEdge(from, to);
        }

        System.out.println(g.edgeCount());
        System.out.println(g.edges());

    }

}
