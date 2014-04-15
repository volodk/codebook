package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:20:40 PM 

public class PredefinedGraphs {
    
    public static void test(UndirectedGraph g){
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        
    }
    
    public static void test(DirectedGraph g){
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        
        g.addEdge(3, 4);
        g.addEdge(4, 5);
    }
    
    public static void test(WeightedGraph g){
        
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 9);
        g.addEdge(0, 5, 14);
        
        g.addEdge(1, 2, 10);
        g.addEdge(1, 3, 15);
        
        g.addEdge(2, 3, 11);
        g.addEdge(2, 5, 2);
        
        g.addEdge(3, 4, 6);
        g.addEdge(4, 5, 9);
        
    }
    
    public static void test(DirectedWeightedGraph g){
        
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 9);
        g.addEdge(0, 5, 14);
        
        g.addEdge(1, 2, 10);
        g.addEdge(1, 3, 15);
        
        g.addEdge(2, 3, 11);
        g.addEdge(2, 5, 2);
        
        g.addEdge(3, 4, 6);
        g.addEdge(4, 5, 9);
        
    }
    
    public static void testDAG(DirectedGraph g){
        
    }
    
}
