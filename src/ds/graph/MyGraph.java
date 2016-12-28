package ds.graph;

import java.util.*;

/**
 * Created by vkrasnikov on 28/12/16.
 */
public class MyGraph<X,Y> {

    private boolean directed;
    private List<Set<Integer>> vertices;
    private Map<Integer, X> vertexValues = new HashMap<>();
    private Map<Integer, Map<Integer, Y>> edges = new HashMap<>();

    public MyGraph(int n, boolean directed){
        this.directed = directed;
        vertices = new ArrayList<>(n);
    }

    public boolean hasPath(int from, int to){
        if (directed){
            return edges.getOrDefault(from, Collections.emptyMap()).containsKey(to);
        }
        return true;
    }

    public int vertexCount(){ return vertices.size(); }


}
