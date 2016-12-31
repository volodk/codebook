package alg.graph.traverse;

import ds.graph.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;

public class BFS {

    public static void traverse(Graph g, int start, BiConsumer<Graph, Integer> action){

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Integer v = q.poll();

            visited.add(v);
            action.accept(g, v);

            for (Integer w : g.getAdjacentVertices(v)){
                if (!visited.contains(w)) {
                    q.offer(w);
                }
            }
        }
    }

}
