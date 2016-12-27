package ds.graph;

import java.util.*;

public class Graph<X,Y> {

    public static class IntGraph extends Graph<Integer, Integer> {}
    public static class LongGraph extends Graph<Long, Long> {}
    public static class StringGraph extends Graph<String, String> {}

    private int edgeCount;
    private boolean isDirected;
    private List<Set<Integer>> adjacencyList;
    private Map<Integer, X> vertexValues = new HashMap<>();
    private Map<Edge, Y> edgeValues = new HashMap<>();

    private Graph() {
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

    public static <X,Y> Builder<X,Y> builder(int vertexCount, boolean isDirected) {
        return new Builder<>(vertexCount, isDirected);
    }

    public static class Builder<X,Y> {
        Graph<X,Y> g = new Graph<>();
        Builder(int vertexCount, boolean isDirected) {
            g.isDirected = isDirected;
            g.adjacencyList = new ArrayList<>(vertexCount);
            for (int i = 0; i < vertexCount; i++) g.adjacencyList.add(new HashSet<>());
        }
        Graph<X,Y> build() {
            return g;
        }
        Builder vertex(int vertex, X value){
            g.vertexValues.put(vertex, value);
            return this;
        }
        Builder edge(int from, int to) {
            g.edgeCount++;
            g.adjacencyList.get(from).add(to);
            return this;
        }
        Builder edge(int from, int to, Y value) {
            edge(from, to);
            g.edgeValues.put(Edge.between(from, to), value);
            return this;
        }
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

}
