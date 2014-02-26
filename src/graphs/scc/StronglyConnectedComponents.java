package graphs.scc;

import java.util.Arrays;

import graphs.AbstractGraphFactory;
import graphs.Directed;
import graphs.GraphFactory;
import graphs.GraphFactory.StorageType;

public class StronglyConnectedComponents {
    
    public static int[] findSCC(Directed G){
        int[] scc = new int[G.V()];
        
        return scc;
    }
    
    public static void main(String[] args) {
        
        GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);
        Directed g = EDGE_LIST_GRAPH_FACTORY.directedGraph(6);
        
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        
        g.addEdge(1, 4);    // linking edge
        
        int[] scc = findSCC(g);
        
        System.out.println(Arrays.toString(scc));
        
    }
}
