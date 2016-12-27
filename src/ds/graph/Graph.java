package ds.graph;

import java.util.*;

public class Graph<X,Y> {

    private int edgeCount;
    private boolean isDirected;
    private List<Set<Integer>> adjacencyList;
    private Map<Integer, X> vertexValues = new HashMap<>();
    private Map<Edge, Y> edgeValues = new HashMap<>();

    // API
    public Graph(int vertexCount){
        adjacencyList = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) adjacencyList.add(new HashSet<>());
    }
    public int vertexCount(){ return adjacencyList.size(); }
    public int edgeCount(){ return edgeCount; }
    public Set<Integer> neighbors(int vertex){
        return Collections.unmodifiableSet(adjacencyList.get(vertex));
    }
    public boolean hasPath(int from, int to){
        if (isDirected){
           return adjacencyList.get(from).contains(to);
        } else {
            return adjacencyList.get(from).contains(to) || adjacencyList.get(to).contains(from);
        }
    }
    public X vertexValue(int vertex){
        return vertexValues.get(vertex);
    }
    public Y edgeValue(int from, int to){
        if (isDirected) {
            return edgeValues.get(Edge.between(from, to));
        } else {
            Y w = edgeValues.get(Edge.between(from, to));
            if (w != null) return w;
            return edgeValues.get(Edge.between(to, from));
        }
    }

    // Construct API
    public void isDirected(boolean value){
        isDirected = value;
    }
    public void setVertexValue(int vertex, X value){
        vertexValues.put(vertex, value);
    }
    public void edge(int from, int to) {
        edgeCount++;
        adjacencyList.get(from).add(to);
    }
    public void edge(int from, int to, Y value) {
        edge(from, to);
        edgeValues.put(Edge.between(from, to), value);
    }

    private static class Edge {
        int from, to;
        static Edge between(int from, int to) {
            Edge e = new Edge();
            e.from = from; e.to = to;
            return e;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Edge other = (Edge) o;
            return this.from == other.from && this.to == other.to;

        }
        @Override
        public int hashCode() {
            return 7907 * from + 7919 * to;
        }
    }

    public static class IntGraph extends Graph<Integer, Integer> { public IntGraph(int n){super(n); } }
    public static class LongGraph extends Graph<Long, Long> { public LongGraph(int n){super(n); } }
    public static class StringGraph extends Graph<String, String> { public StringGraph(int n){super(n); } }
}
