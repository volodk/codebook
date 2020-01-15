package ds.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Created by volodymyr on 27-12-16.
 */
public class GraphTest {

    @Test
    public void zeroVertex(){
        Graph g = new Graph(0);

        assertFalse(g.isConnected(0, 0));
        assertFalse(g.isConnected(0, 1));
        assertFalse(g.isConnected(1, 0));

        assertNull(g.adjacentTo(0));
        assertNull(g.adjacentTo(1));
    }

    @Test
    public void singleVertex(){
        Graph g = new Graph(1);
    }

    @Test
    public void dupleVertex(){
        Graph g = new Graph(2);
    }

    @Test
    public void trippleVertex(){
        Graph g = new Graph(3);
    }

    @Test
    public void disconnectedGraph(){
        Graph g = new Graph(10);
    }

    @Test
    public void bigSparseGraph(){
        Graph g = new Graph(1000);
    }

    @Test
    public void bigDenseGraph(){
        Graph g = new Graph(1000);
    }

}
