package graphs.cc;

import graphs.AbstractGraphFactory;
import graphs.Graph;
import graphs.GraphFactory;
import graphs.PredefinedGraphs;
import graphs.UndirectedGraph;
import graphs.UndirectedGraphPrinterTest;
import graphs.GraphFactory.StorageType;
import graphs.alg.cc.ConnectedComponents;

import org.junit.Before;
import org.junit.Test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:39:33 PM 

public class CCTest {
    
    private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);
    private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_LIST);
    private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);

    UndirectedGraph g;
    
    @Before
    public void setUp(){
        
        g = ADJACENCY_MATRIX_GRAPH_FACTORY.undirectedGraph(6);
        
        PredefinedGraphs.test(g);
    }
    
    @Test
    public void isConnected() {
        
        ConnectedComponents.printConnectedComponents(g);
        
        System.out.println(ConnectedComponents.isConnected(g));
        
    }

}
