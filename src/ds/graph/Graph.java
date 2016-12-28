package ds.graph;

public class Graph<X,Y> {

    private boolean directed;
    private int vertexCount, edgeCount;
    private java.util.List<java.util.Set<Integer>> vertices;
    private java.util.Map<Integer, X> vertexValues = new java.util.HashMap<>();
    private java.util.Map<Integer, java.util.Map<Integer, Y>> edges = new java.util.HashMap<>();

    public Graph(int n, boolean directed){
        this.directed = directed;
        vertices = new java.util.ArrayList<>(vertexCount =  n);
    }

    public Graph addEdge(int from, int to){
        addEdge(from, to, null);
        return this;
    }

    public Graph addEdge(int from, int to, Y value){
        if(from >= vertexCount || to >= vertexCount) throw new IllegalArgumentException();
        if (edges.containsKey(from)){
            Y oldValue = edges.get(from).put(to, value);
            if (oldValue == null) edgeCount++;
        } else {
            java.util.Map<Integer, Y> s = new java.util.HashMap<>();
            s.put(to, value);
            edges.put(from, s);
            edgeCount++;
        }
        return this;
    }

    public Y getEdgeValue(int from, int to){
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

    public int edgeCount(){ return edgeCount;}

    public int vertexCount(){ return vertexCount; }

    public java.util.Set<Integer> getAdjacentVertices(int vertex){
        return java.util.Collections.unmodifiableSet(vertices.get(vertex));
    }

    public Graph<X,Y> setVertexValue(int vertex, X value){
        vertexValues.put(vertex, value);
        return this;
    }

    public X getVertexValue(int vertex){
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
