package graphs.alg.traverse;

import graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    public static void traverse(Graph g){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[ g.V() ];
        for( int v = 0; v < g.V(); v++ )
        {
            q.offer(v);
            while(!q.isEmpty()){
                Integer curr = q.poll();
                visited[curr] = 1;
                //
                for( int next : g.adjacentTo(curr) ){
                    if( visited[next] == 0 ){
                        q.offer(next);
                    }
                }
            }
        }
    }
}
