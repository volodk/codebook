package graphs;

import graphs.GraphFactory.StorageType;

import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:20:40 PM 

public class GraphGenerator {

    static Random rnd = new Random();
    
    private static final int[] WEIGHTS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
    
    private static final GraphFactory ADJACENCY_MATRIX_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_MATRIX);
    private static final GraphFactory ADJACENCY_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.ADJACENCY_LIST);
    private static final GraphFactory EDGE_LIST_GRAPH_FACTORY = AbstractGraphFactory.getFactory(StorageType.EDGE_LIST);
    
    public static Graph regularAdjacencyMatrixGraph(int V, float density) {

        Graph g = ADJACENCY_MATRIX_GRAPH_FACTORY.undirectedGraph(V);

        populate(V, density, g);
        
        return g;
    }

    public static Graph regularAdjacencyListGraph(int V, float density) {

        Graph g = ADJACENCY_LIST_GRAPH_FACTORY.undirectedGraph(V);

        populate(V, density, g);
        
        return g;
    }

    public static Graph regularEdgeListGraph(int V, float density) {

        Graph g = EDGE_LIST_GRAPH_FACTORY.undirectedGraph(V);

        populate(V, density, g);
        
        return g;
    }

    public static Directed directedAdjacencyMatrixGraph(int V, float density) {

        Directed g = ADJACENCY_MATRIX_GRAPH_FACTORY.directedGraph(V);

        populate(V, density, g);
        
        return g;
    }

    public static Directed directedAdjacencyListGraph(int V, float density) {

        Directed g = ADJACENCY_LIST_GRAPH_FACTORY.directedGraph(V);

        populate(V, density, g);
        return g;
    }

    public static Directed directedEdgeListGraph(int V, float density) {

        Directed g = EDGE_LIST_GRAPH_FACTORY.directedGraph(V);

        populate(V, density, g);
        return g;
    }

   
    
    public static Weighted weightedAdjacencyMatrixGraph(int V, float density) {

        Weighted g = ADJACENCY_MATRIX_GRAPH_FACTORY.weightedGraph(V);

        populate(V, density, g, randomWeight() );
        
        return g;
    }


    public static Weighted weightedAdjacencyListGraph(int V, float density) {

        Weighted g = ADJACENCY_LIST_GRAPH_FACTORY.weightedGraph(V);

        populate(V, density, g, randomWeight() );
        
        return g;
    }

    public static Weighted weightedEdgeListGraph(int V, float density) {

        Weighted g = EDGE_LIST_GRAPH_FACTORY.weightedGraph(V);

        populate(V, density, g, randomWeight() );
        
        return g;
    }
    
    
    public static WeightedDirected weightedDirectedAdjacencyMatrixGraph(int V, float density) {

        WeightedDirected g = ADJACENCY_MATRIX_GRAPH_FACTORY.weightedDirectedGraph(V);

        populate(V, density, g, randomWeight() );
        
        return g;
    }
    
    public static WeightedDirected weightedDirectedAdjacencyListGraph(int V, float density) {

        WeightedDirected g = ADJACENCY_LIST_GRAPH_FACTORY.weightedDirectedGraph(V);

        populate(V, density, g, randomWeight() );
        
        return g;
    }
    
    public static WeightedDirected weightedDirectedEdgeListGraph(int V, float density) {

        WeightedDirected g = EDGE_LIST_GRAPH_FACTORY.weightedDirectedGraph(V);

        populate(V, density, g, randomWeight() );
        
        return g;
    }
    
    
    private static int randomWeight(){
        return WEIGHTS[rnd.nextInt( WEIGHTS.length )];
    }
    
    private static void populate(int V, float density, Graph g) {
        float max = V * (V - 1) * 0.5f;
        while (g.E() / max <= density) {
            int from = rnd.nextInt(V);
            int to = rnd.nextInt(V);
            if (from != to)
                g.addEdge(from, to);
        }
    }
    
    private static void populate(int V, float density, Weighted g, int weight) {
        float max = V * (V - 1) * 0.5f;
        while (g.E() / max <= density) {
            int from = rnd.nextInt(V);
            int to = rnd.nextInt(V);
            if (from != to)
                g.addEdge(from, to, weight );
        }
    }
    
}
