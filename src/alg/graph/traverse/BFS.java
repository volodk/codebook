package alg.graph.traverse;

import ds.graph.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

    public static void traverse(Graph g, int start, GraphVisitor graphVisitor){

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int v = q.poll();

            graphVisitor.openVertex(g, v);
            visited.add(v);

            for (int w : g.adjacentTo(v)){
                if (!visited.contains(w)) {
                    q.offer(w);
                }
            }
        }
    }

}
