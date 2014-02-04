package graphs.cc;

import graphs.DirectedGraph;
import graphs.Graph;
import graphs.GraphGenerator;
import graphs.cc.ConnectedComponents;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:39:33 PM 

public class CCTest {

    @Test
    public void printCC() {
       DirectedGraph gid = GraphGenerator.generateDirected(6, 0.4f, false);
       
       gid.print();
       
       ConnectedComponents.printConnectedComponents(gid);
       
       System.out.println();
    }
    
    @Test
    public void isConnected() {
        
        Graph g = GraphGenerator.generateUndirected(10, 0.2f);
        g.print();
        
        ConnectedComponents.printConnectedComponents(g);
        
        boolean b = ConnectedComponents.isConnected(g);
        
        System.out.println(b);
    }

}
