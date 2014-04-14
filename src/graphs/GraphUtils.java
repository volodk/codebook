package graphs;

import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:20:40 PM 

public class GraphUtils {

    static Random rnd = new Random();
    
    public static void test(Undirected g){
        
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
    
    public static void test(Directed g){
        
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
    
    public static void test(Weighted g){
        
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
    
    public static void testDAG(Directed g){
        
    }
    
    public void randomDAG(Directed g, int V){
        
    }
    
    public static void randomlyFill(Undirected g, int V){
        
    }
    
    public static void randomlyFill(Directed g, int V){
        
    }
    
    static int[] POSITIVE_WEIGHTS = { 2, 6, 1, 3, 4, 7, 8, 4, 5, 10, 14, 13 };
    
    static int[] MIXED_WEIGHTS = { 2, 6, -1, 3, -4, 7, 8, -4, 5, 10, 14, -13 };
    
    public static void randomlyFill(Weighted g, int V){
        
    }
    
    public static void randomlyFillWithNegativeWeights(Weighted g, int V){
        
    }
    
}
