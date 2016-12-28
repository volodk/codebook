package ds.graph;

import java.util.*;

public class Graph<X,Y> {

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

    public Set<Edge> edges(){
        Set<Edge> edges = new HashSet<>();
        for (int from = 0; from < vertexCount(); from++){
            for (int to : adjacencyList.get(from)){
                edges.add(Edge.between(from, to));
            }
        }
        return Collections.unmodifiableSet(edges);
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

    public static class Builder<X,Y> {
        Graph<X,Y> g = new Graph<>();
        Builder<X,Y> vertices(int vertexCount){
            g.adjacencyList = new ArrayList<>(vertexCount);
            for (int i = 0; i < vertexCount; i++) g.adjacencyList.add(new HashSet<>());
            return this;
        }
        Builder<X,Y> directed(boolean isDirected){
            g.isDirected = isDirected;
            return this;
        }
        Builder<X,Y> vertex(int vertex, X value){
            g.vertexValues.put(vertex, value);
            return this;
        }
        Builder<X,Y> edge(int from, int to) {
            g.edgeCount++;
            g.adjacencyList.get(from).add(to);
            return this;
        }
        Builder<X,Y> edge(int from, int to, Y value) {
            edge(from, to);
            g.edgeValues.put(Edge.between(from, to), value);
            return this;
        }
        Graph<X,Y> build() {
            return g;
        }
    }

    public static class Edge {
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

        @Override
        public String toString() {
            return from + "-" + to;
        }
    }

    public static <X,Y> Builder<X,Y> newGraph() { return new Builder<>(); }
    public static Builder<Integer, Integer> newIntValueGraph() { return new Builder<>(); }
    public static Builder<Long, Long> newLongValueGraph() { return new Builder<>(); }
    public static Builder<String, String> newStringValueGraph() { return new Builder<>(); }

}
