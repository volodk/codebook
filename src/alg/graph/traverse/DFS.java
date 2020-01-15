package alg.graph.traverse;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 5:50:35 PM

import ds.graph.Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {

    public static void traverse(Graph g, int start, GraphVisitor graphVisitor){
        Set<Integer> visited = new HashSet<>();

        Stack<Integer> s = new Stack<>();
        s.push(start);

        while( !s.isEmpty() ){
            int v = s.pop();

            graphVisitor.openVertex(g, v);
            visited.add(v);

            for (int w : g.adjacentTo(v)){
                if (!visited.contains(w)){
                    s.push(w);
                }
            }
        }

    }

}
