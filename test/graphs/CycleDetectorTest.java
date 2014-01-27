package graphs;

import static org.junit.Assert.*;

import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:47:46 PM 

public class CycleDetectorTest {

    @Test
    public void test() {
        
//        DIGraph g = GraphGenerator.generateDirected(6, 0.4f, false);
        
        DIGraph g2 = GraphGenerator.generateDAG(10); 
        
        g2.print();
        
        System.out.println(CycleDetector.hasNoCycle(g2));
    }

}
