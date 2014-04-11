package graphs.cycles;

import graphs.Directed;
import graphs.Graph;

import java.util.Deque;
import java.util.LinkedList;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:37:16 PM 

public class CycleDetector {

    static boolean hasNoCycle(Graph g) {
        
        Directed dig = (Directed) g;

        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[g.V()];

        for (int v = 0; v < g.V() && visited[v] == 0; v++) {
            stack.push(v);

            while (!stack.isEmpty()) {
                Integer curr = stack.pop();
                visited[curr] = 1;
                
                for (Integer vv : g.adjacentTo(curr)) {
                    if (visited[vv] == 0) {
                        stack.push(vv);
                    } else {
                        return false; // cycle detected
                    }
                }
            }
        }

        return true;
    }
}
