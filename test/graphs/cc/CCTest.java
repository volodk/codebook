package graphs.cc;

import graphs.Graph;
import graphs.GraphGenerator;
import graphs.GraphPrinter;

import org.junit.Before;
import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:39:33 PM 

public class CCTest {

    Graph g;
    
    @Before
    public void setUp(){
        
        g = GraphGenerator.regularAdjacencyMatrixGraph(5, 0.5f);
        
        GraphPrinter.print(g);
    }
    
    @Test
    public void isConnected() {
        
        ConnectedComponents.printConnectedComponents(g);
        
        System.out.println(ConnectedComponents.isConnected(g));
        
    }

}
