package graphs;

import java.util.Deque;
import java.util.LinkedList;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:37:16 PM 

public class CycleDetector {
    
    static boolean hasNoCycle(DIGraph dig){
        
        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[dig.V()];
        
        for(int v = 0; v < dig.V() && visited[v] == 0; v++){
            stack.push(v);
            
            while(!stack.isEmpty()){
                Integer curr = stack.pop();
                if( visited[curr] == 0 ){
                    visited[curr] = 1;
                    for(Integer vv : dig.getAdjacent(curr)){
                        stack.push(vv);
                    }
                } else {
                    return false;   // cycle detected
                }
            }
        }
        
        return true;
    }
}
