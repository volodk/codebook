package graphs.topsort;

import graphs.AbstractGraphFactory;
import graphs.Directed;
import graphs.GraphFactory;
import graphs.GraphFactory.StorageType;
import graphs.GraphPrinter;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:48:09 PM 

public class TopSortTest {
    
    GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);

    @Test
    public void liniarity() {
        
        Directed g = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
                
        GraphPrinter.print(g);
        
        TopSort.printInOrder(g);
    }
    
    @Test
    public void test() {
        
        Directed g = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        
        GraphPrinter.print(g);
        
        TopSort.printInOrder(g);
    }

}
