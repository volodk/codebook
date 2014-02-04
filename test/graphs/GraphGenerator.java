package graphs;

import java.util.Random;

import graphs.DirectedGraph;
import graphs.Graph;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:20:40 PM 

public class GraphGenerator {
    
    static Random rnd = new Random();

    public static void main(String[] args) {
        
        int verticies = 10;
        float density = 0.4f;
        
        Graph g = generateUndirected(verticies, density);
        
        DirectedGraph dig = generateDirected(verticies, density, true);
        
//        g.print();
        dig.print();

    }

    public static Graph generateUndirected(int verticies, float density) {
        Graph g = new Graph(verticies);
        float max = verticies * (verticies - 1) * 0.5f;
        while( g.E() / max <= density){
            int from = rnd.nextInt(verticies);
            int to = rnd.nextInt(verticies);
            g.addEdge(from, to);
        }
        return g;
    }
    
    public static DirectedGraph generateDirected(int verticies, float density, boolean loopsAllowed) {
        DirectedGraph g = new DirectedGraph(verticies, loopsAllowed);
        float max = verticies * (verticies - 1) * 0.5f;
        while( g.E() / max <= density){
            int from = rnd.nextInt(verticies);
            int to = rnd.nextInt(verticies);
            g.addEdge(from, to);
        }
        return g;
    }
    
    public static DirectedGraph generateWeightedDirectedGraph(int verticies, float density, boolean loopsAllowed) {
        DirectedGraph g = new DirectedGraph(verticies, loopsAllowed);
        float max = verticies * (verticies - 1) * 0.5f;
        while( g.E() / max <= density){
            int from = rnd.nextInt(verticies);
            int to = rnd.nextInt(verticies);
            g.addEdge(from, to);
        }
        return g;
    }
    
    public static DirectedGraph generateDAG(int verticies){
        DirectedGraph g = new DirectedGraph(verticies);
        
        for(int i = 0 ; i < verticies - 1; i++){
            g.addEdge(i, i + 1);
        }
        
        return g;
    }
    
    public static DirectedGraph generateWeightedDAG(int verticies){
        DirectedGraph g = new DirectedGraph(verticies);
        
        
        return g;
    }

}
