package graphs.topsort;

import graphs.DIGraph;

import java.util.Deque;
import java.util.LinkedList;

public class TopSort {

    public static void printInOrder(DIGraph g){
        
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
                    
                    for(Integer vv : g.getAdjacent(curr)){
                        stack.push(vv);
                    }
                }
            }
        }
        
        System.out.println(inOrder);
        
    }
}
