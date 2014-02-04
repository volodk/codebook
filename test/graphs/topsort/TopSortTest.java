package graphs.topsort;

import static org.junit.Assert.*;
import graphs.DirectedGraph;
import graphs.GraphGenerator;
import graphs.topsort.TopSort;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:48:09 PM 

public class TopSortTest {

    @Test
    public void liniarity() {
        
        DirectedGraph g2 = GraphGenerator.generateDAG(10); 
        
        g2.print();
        
        TopSort.printInOrder(g2);
    }
    
    @Test
    public void test() {
        
        DirectedGraph g2 = new DirectedGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 1);
        
        g2.print();
        
        TopSort.printInOrder(g2);
    }

}
