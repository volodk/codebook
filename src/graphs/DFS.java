package graphs;

import java.util.Deque;
import java.util.LinkedList;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:50:35 PM 

public class DFS {

    public static void traverse(Graph g, Action action){
        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[g.V()];
        
        for(int v = 0; v < g.V(); v++){
            stack.push(v);
            
            while(!stack.isEmpty()){
                Integer curr = stack.pop();
                if( visited[curr] == 0 ){
                    
                    action.perform(g, curr, visited);
                    
                    for(Integer vv : g.getAdjacent(v)){
                        stack.push(vv);
                    }
                }
            }
        }
    }
    
    public static void traverse(Graph g, Action action, int from){
        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[g.V()];
        
        stack.push(from);
        
        while(!stack.isEmpty()){
            Integer v = stack.pop();
            if( visited[v] == 0 ){
                
                action.perform(g, v, visited);
                
                for(Integer vv : g.getAdjacent(v)){
                    stack.push(vv);
                }
            }
        }
    }
}
