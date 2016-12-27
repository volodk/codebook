package ds.graph;

import java.util.*;

public class Graph<T> {

    boolean isDirected;

    List<Set<Integer>> adjacencyList;

    Map<Edge, T> edgeValues = new HashMap<>();

    private Graph() {
    }

    int vertexCount(){ return adjacencyList.size(); }

    int edgeCount(){ return 0; }

    Set<Integer> neighbors(int vertex){
        return Collections.unmodifiableSet(adjacencyList.get(vertex));
    }

    boolean hasPath(int from, int to){
        if (isDirected){
           return adjacencyList.get(from).contains(to);
        } else {
            return adjacencyList.get(from).contains(to) || adjacencyList.get(to).contains(from);
        }
    }

    T edgeValue(int from, int to){
        if (isDirected) {
            return edgeValues.get(Edge.of(from, to));
        } else {
            T w1 = edgeValues.get(Edge.of(from, to));
            if (w1 != null) return w1;
            return edgeValues.get(Edge.of(to, from));
        }
    }

    static <T> Builder builder(int vertexCount, boolean isDirected, Class<T> edgeValueType) {
        return new Builder<T>(vertexCount, isDirected);
    }

    static class Builder<T> {
        Graph<T> g = new Graph<T>();

        Builder(int vertexCount, boolean isDirected) {
            g.isDirected = isDirected;
            g.adjacencyList = new ArrayList<>(vertexCount);
            for (int i = 0; i < vertexCount; i++) g.adjacencyList.add(new HashSet<>());
        }

        Graph<T> get() {
            return g;
        }

        Builder edge(int from, int to) {
            g.adjacencyList.get(from).add(to);
            return this;
        }

        Builder edge(int from, int to, T weight) {
            edge(from, to);
            g.edgeValues.put(Edge.of(from, to), weight);
            return this;
        }
    }

    private static class Edge {
        int from, to;
        static Edge of(int from, int to) {
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
            return 31 * from + 71 * to;
        }
    }
}
