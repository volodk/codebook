package graphs;

import graphs.GraphFactory.StorageType;

import org.junit.Test;

public class UndirectedGraphPrinterTest {
    
    private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);
    private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_LIST);
    private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);
    
    int N = 6;
    
    @Test
    public void printAMUndirectedGraph(){
        Undirected ug = ADJACENCY_MATRIX_GRAPH_FACTORY.undirectedGraph(N);
        GraphUtils.test(ug);
        
        ug.print();
        
        System.out.println();
    }
    
    @Test
    public void printALUndirectedGraph(){
        Undirected ug = ADJACENCY_LIST_GRAPH_FACTORY.undirectedGraph(N);
        GraphUtils.test(ug);
        
        ug.print();
        System.out.println();
    }
    
    @Test
    public void printELUndirectedGraph(){
        Undirected ug = EDGE_LIST_GRAPH_FACTORY.undirectedGraph(N);
        GraphUtils.test(ug);
        
        ug.print();
        
        System.out.println();
        
    }
    
}
