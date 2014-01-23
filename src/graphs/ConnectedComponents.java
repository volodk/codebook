package graphs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:31:53 PM 

public class ConnectedComponents {
    
    public static void printConnectedComponents(Graph g){
        
        Deque<Integer> stack = new LinkedList<>();
        
        int[] mark = new int[g.V()];
        Arrays.fill(mark, -1);
        
        int color = 0;
        
        for(int i = 0; i < g.V(); i++){
        
            stack.push(i);
            
            while( !stack.isEmpty() ){
                Integer v = stack.pop();
                if( mark[v] == -1){
                    mark[v] = color;
                    for( Integer vv : g.getAdjacent(v) ){
                        stack.push(vv);
                    }
                }
            }
            
            color += 1;
        }
        
        System.out.println(Arrays.toString(mark));
        
    }
}
