package graphs.alg.topsort;

import graphs.DirectedGraph;

import java.util.Deque;
import java.util.LinkedList;

public class TopSort {

    public static void printInOrder(DirectedGraph g){
        
        Deque<Integer> stack = new LinkedList<>();
        
        Deque<Integer> inOrder = new LinkedList<>();
        
        int[] visited = new int[g.V()];
        
        for(int v = 0; v < g.V() && visited[v] == 0; v++){
            stack.push(v);
            
            while(!stack.isEmpty()){
                Integer curr = stack.pop();
                
                if( visited[curr] == 0 ){
                    visited[curr] = 1;
                    
                    inOrder.push(curr);
                    
                    for(Integer vv : g.adjacentTo(curr)){
                        stack.push(vv);
                    }
                }
            }
        }
        
        System.out.println(inOrder);
        
    }
}