package ds.graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by volodymyr on 27-12-16.
 */
public class GraphTest {

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeBetweenExistingAndNonExistingVertex(){
        int V = 4;
        Graph<Integer, Integer> g = new Graph<>(V, true);
        g.addEdge(0, 100);
    }

    @Test
    public void createSimpleDirectedGraph(){
        int V = 4;
        Graph<Integer, Integer> g = new Graph<>(V, true);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.println(g.edgeCount());
        System.out.println(g.edges());

        assertTrue(g.hasEdge(0, 1));
        assertFalse(g.hasEdge(1, 0));
        assertFalse(g.hasEdge(0, 2));

    }

    @Test
    public void addSelfLoopEdge(){
        int V = 5;
        Graph<Integer, Integer> g = new Graph<>(V, true);
        for (int i = 0; i < 100; i++){
            g.addEdge(0, 0);
        }
        assertEquals(1, g.edgeCount());
    }

    @Test
    public void addTheSameEdge(){
        int V = 5;
        Graph<Integer, Integer> g = new Graph<>(V, true);
        for (int i = 0; i < 100; i++){
            g.addEdge(0, 1);
        }
        assertEquals(1, g.edgeCount());
    }

    @Test
    public void createStarDirectedGraph(){
        int V = 100001, E = 100000;
        Graph<Integer, Integer> g = new Graph<>(V, true);
        for (int i = 1; i < V; i++){
            g.addEdge(0, i);
        }
        assertEquals(E, g.edgeCount());
    }

    @Test
    public void createTreeGraph(){
        int V = 7;
        Graph<Integer, Integer> g = new Graph<>(V, true);

        g.setVertexValue(0, 0);
        g.setVertexValue(1, 1);
        g.setVertexValue(2, 2);
        g.setVertexValue(3, 3);
        g.setVertexValue(4, 4);
        g.setVertexValue(5, 5);
        g.setVertexValue(6, 6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        int[] values = {0,1,2,3,4,5,6};
        int index = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.println(g.getVertexValue(v));

            assertEquals(values[index++], g.getVertexValue(v).intValue());

            for (int next : g.getAdjacentVertices(v)){
                q.offer(next);
            }
        }
    }

}
