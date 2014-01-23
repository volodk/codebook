package graph;

import graphs.ConnectedComponents;
import graphs.DIGraph;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:39:33 PM 

public class CCTest {

    @Test
    public void test() {
       DIGraph gid = Generator.generateDirected(6, 0.4f, false);
       
       gid.print();
       
       ConnectedComponents.printConnectedComponents(gid);
    }

}
