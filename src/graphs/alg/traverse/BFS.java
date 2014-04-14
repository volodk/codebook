package graphs.alg.traverse;

import graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    public static void traverse(Graph g, Visitor visitor){
        
        Queue<Integer> q = new LinkedList<>();
        
        int[] visited = new int[g.V()];
        
        for( int v = 0; v < g.V() && visited[v] == 0; v++ ){
            
            q.offer(v);
            
            while(!q.isEmpty()){

                Integer curr = q.poll();
                   
                visited[curr] = 1;
                
                visitor.visit(g, curr, visited);
                
                for( int vv : g.adjacentTo(curr) ){
                    if( visited[vv] == 0 ){
                        q.offer(vv);
                    }
                }
                
            }
            
        }
        
    }
}
