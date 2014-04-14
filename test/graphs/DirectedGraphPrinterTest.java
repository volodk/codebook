package graphs;

import graphs.GraphFactory.StorageType;

import org.junit.Test;

public class DirectedGraphPrinterTest {
    
    private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);
    private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_LIST);
    private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);
    
    int N = 6;
    
    @Test
    public void printAMDirectedGraph(){
        Directed ug = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(N);
        GraphUtils.test(ug);
        
        ug.print();
        
        System.out.println();
    }
    
    @Test
    public void printALDirectedGraph(){
        Directed ug = ADJACENCY_LIST_GRAPH_FACTORY.directedGraph(N);
        GraphUtils.test(ug);
        
        ug.print();
        
        System.out.println();
        
    }
    
    @Test
    public void printELDirectedGraph(){
        Directed ug = EDGE_LIST_GRAPH_FACTORY.directedGraph(N);
        GraphUtils.test(ug);
        
        ug.print();
        
        System.out.println();
        
    }
    
}
