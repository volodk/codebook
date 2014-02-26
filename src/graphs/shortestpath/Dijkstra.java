package graphs.shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;

import graphs.AbstractGraphFactory;
import graphs.GraphFactory;
import graphs.GraphPrinter;
import graphs.Weighted;
import graphs.GraphFactory.StorageType;

public class Dijkstra {
    
    public static int[] distanceToAll(Weighted g, int from){
        int[] dist = new int[g.V()];
        
        for(int v = 0; v < g.V(); v++){
            dist[v] = Integer.MAX_VALUE;
        }
        
        dist[from] = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        return dist;
    }

    
    public static void main(String[] args) {
        
        GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);
        Weighted g = EDGE_LIST_GRAPH_FACTORY.weightedGraph(6);
        
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 9);
        g.addEdge(0, 5, 14);
        
        g.addEdge(1, 2, 10);
        g.addEdge(1, 3, 15);
        
        g.addEdge(2, 3, 11);
        g.addEdge(2, 5, 2);
        
        g.addEdge(3, 4, 6);
        g.addEdge(5, 4, 9);
        
        GraphPrinter.print(g);
        
        int start = 0;
        int[] dist = distanceToAll(g, start);
        
        System.out.println( Arrays.toString(dist) );
        
    }
}
