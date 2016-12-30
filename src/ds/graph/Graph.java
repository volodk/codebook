package ds.graph;

public class Graph<X,Y> {

    private int vertexCount;
    private boolean directed;
    private java.util.Map<Integer, X> vertexValues = new java.util.HashMap<>();
    private java.util.Map<Integer, java.util.Map<Integer, Y>> edges = new java.util.HashMap<>();

    public Graph(int V){ this.vertexCount = V; }

    public Graph directed(){ this.directed = true; return this; }

    public Graph addEdge(int from, int to){
        addEdge(from, to, null);
        return this;
    }

    public Graph addEdge(int from, int to, Y value){
        if (from >= vertexCount() || to >= vertexCount() ) throw new IllegalArgumentException();
        if (edges.containsKey(from)){
            edges.get(from).put(to, value);
        } else {
            java.util.Map<Integer, Y> s = new java.util.HashMap<>();
            s.put(to, value);
            edges.put(from, s);
        }
        return this;
    }

    public Y getEdgeValue(int from, int to){
        if (from >= vertexCount() || to >= vertexCount() ) throw new IllegalArgumentException();
        Y value = edges.getOrDefault(from, java.util.Collections.emptyMap()).get(to);
        if (directed) {
            return value;
        } else {
            if (value != null) return value;
            else return edges.getOrDefault(to, java.util.Collections.emptyMap()).get(from);
        }
    }

    public boolean hasEdge(int from, int to){
        boolean hasDirectEdge = edges.getOrDefault(from, java.util.Collections.emptyMap()).containsKey(to);
        if (directed){
            return hasDirectEdge;
        } else {
            return hasDirectEdge || edges.getOrDefault(to, java.util.Collections.emptyMap()).containsKey(from);
        }
    }

    public java.util.Set<Edge> edges(){
        java.util.Set<Edge> allEdges = new java.util.HashSet<>();
        for (Integer from : edges.keySet()){
            edges.get(from).keySet().stream().map(to -> new Edge(from, to)).forEach(allEdges :: add);
        }
        return allEdges;
    }

    public int edgeCount(){
        return edges.values().stream().map(m -> m.size()).reduce(0, Integer :: sum);
    }

    public void removeEdge(int from, int to){
        if (from >= vertexCount() || to >= vertexCount() ) throw new IllegalArgumentException();
        edges.getOrDefault(from, java.util.Collections.emptyMap()).remove(to);
    }

    public int vertexCount(){ return vertexCount; }

    public void removeVertex(int vertex){
        if (vertex >= vertexCount()) throw new IllegalArgumentException();
        edges.remove(vertex);
        for (java.util.Map<?, ?> m : edges.values()) m.remove(vertex);
        vertexCount -= 1;
    }

    public java.util.Set<Integer> getAdjacentVertices(int vertex){
        if (vertex >= vertexCount()) throw new IllegalArgumentException();
        return java.util.Collections.unmodifiableSet(edges.getOrDefault(vertex, java.util.Collections.emptyMap()).keySet());
    }

    public Graph<X,Y> setVertexValue(int vertex, X value){
        if (vertex >= vertexCount()) throw new IllegalArgumentException();
        vertexValues.put(vertex, value);
        return this;
    }

    public X getVertexValue(int vertex){
        if (vertex >= vertexCount()) throw new IllegalArgumentException();
        return vertexValues.get(vertex);
    }

    public static class Edge {
        int from, to;
        public Edge(int a, int b){ from = a; to = b;}
        public boolean equals(Object o) {
            if (this == o) return true;
            Edge other = (Edge) o;
            return this.from == other.from && this.to == other.to;
        }
        public int hashCode() {
            return 7907 * from + 7919 * to;
        }
        public String toString() {
            return from + "-" + to;
        }
    }
}
