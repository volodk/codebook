package graphs;

import java.util.Arrays;

public class GraphPrinter {
    
    public static void print(Graph g){
        for( int i = 0; i < g.V(); i++ ){
            System.out.format("%d -> %s\n", i, Arrays.toString(g.adjacentTo(i)));
        }
        System.out.println();
    }
    
//    public static void print(Directed g){
//        print(g);
//    }
    
    public static void print(Weighted g){
        for( int i = 0; i < g.V(); i++ ){
            System.out.format("%d -> [", i);
            for(int j : g.adjacentTo(i)){
                System.out.format(" %d(%d)", j, g.weight(i, j));
            }
            System.out.format(" ]\n");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        Graph g1 = GraphGenerator.regularAdjacencyMatrixGraph(5, 0.2f);
        print(g1);
        
        Weighted g2 = GraphGenerator.weightedAdjacencyMatrixGraph(10, 0.2f);
        print(g2);
        
        Directed g3 = GraphGenerator.directedAdjacencyMatrixGraph(10, 0.2f);
        print(g3);
        
        WeightedDirected g4 = GraphGenerator.weightedDirectedAdjacencyMatrixGraph(10, 0.25f);
        print(g4);
    }
}
