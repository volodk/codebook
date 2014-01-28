package graphs.shortestpath;

import static java.lang.Math.min;
import graphs.Graph;

import java.util.Arrays;

public class FloydWarshall {
    
    public static int[][] findShortestPaths(int V, Graph G){
        
        int[][] dist = new int[V][V];
        for(int[] arr : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < V; i++)
            dist[i][i] = 0;
        
        for(int i = 0; i < V; i++){
            
        }
        
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]); 
                }
            }
        }
        
        return dist;
    }
}
