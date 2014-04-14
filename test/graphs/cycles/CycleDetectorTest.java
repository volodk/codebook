package graphs.cycles;

import graphs.AbstractGraphFactory;
import graphs.Directed;
import graphs.GraphFactory;
import graphs.GraphFactory.StorageType;
import graphs.UndirectedGraphPrinterTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:47:46 PM 

public class CycleDetectorTest {
    
    Directed g1, g2;
    
    @Before
    public void setUp(){
        
        GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);
        
        g1 = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(1, 3);
        
        
        g2 = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 1);
        
    }

    @Test
    public void test() {
        
        Assert.assertTrue( CycleDetector.hasNoCycle(g1) );
        
        Assert.assertFalse( CycleDetector.hasNoCycle(g2) );
    }

}
