package graph;

import java.util.Random;

import graphs.DIGraph;
import graphs.Graph;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:20:40 PM 

public class Generator {
    
    static Random rnd = new Random();

    public static void main(String[] args) {
        
        int edges = 10;
        float density = 0.4f;
        
        Graph g = generateUndirected(edges, density);
        
        DIGraph dig = generateDirected(edges, density, true);
        
//        g.print();
        dig.print();

    }

    public static Graph generateUndirected(int edges, float density) {
        Graph g = new Graph(edges);
        float max = edges * (edges - 1) * 0.5f;
        while( g.E() / max <= density){
            int from = rnd.nextInt(edges);
            int to = rnd.nextInt(edges);
            g.addEdge(from, to);
        }
        return g;
    }
    
    public static DIGraph generateDirected(int edges, float density, boolean loopsAllowed) {
        DIGraph g = new DIGraph(edges, loopsAllowed);
        float max = edges * (edges - 1) * 0.5f;
        while( g.E() / max <= density){
            int from = rnd.nextInt(edges);
            int to = rnd.nextInt(edges);
            g.addEdge(from, to);
        }
        return g;
    }

}
