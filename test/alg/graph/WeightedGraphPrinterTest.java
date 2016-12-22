package alg.graph;

import alg.graph.GraphFactory.StorageType;

import org.junit.Test;

public class WeightedGraphPrinterTest {
    
    private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);
    private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_LIST);
    private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);
    
    int N = 6;
    
    @Test
    public void printAMUndirectedGraph(){
        WeightedGraph ug = ADJACENCY_MATRIX_GRAPH_FACTORY.weightedGraph(N);
        PredefinedGraphs.test(ug);
        
        ug.print();
        
        System.out.println();
    }
    
    @Test
    public void printALUndirectedGraph(){
        WeightedGraph ug = ADJACENCY_LIST_GRAPH_FACTORY.weightedGraph(N);
        PredefinedGraphs.test(ug);
        
        ug.print();
        
        System.out.println();
        
    }
    
    @Test
    public void printELUndirectedGraph(){
        WeightedGraph ug = EDGE_LIST_GRAPH_FACTORY.weightedGraph(N);
        PredefinedGraphs.test(ug);
        
        ug.print();
        
        System.out.println();
        
    }
    
}
