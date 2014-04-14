package graphs.topsort;

import graphs.AbstractGraphFactory;
import graphs.DirectedGraph;
import graphs.GraphFactory;
import graphs.GraphFactory.StorageType;
import graphs.alg.topsort.TopSort;
import graphs.UndirectedGraphPrinterTest;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:48:09 PM 

public class TopSortTest {
    
    GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);

    @Test
    public void liniarity() {
        
        DirectedGraph g = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
                
        
        TopSort.printInOrder(g);
    }
    
    @Test
    public void test() {
        
        DirectedGraph g = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        
        
        TopSort.printInOrder(g);
    }

}
