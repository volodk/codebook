package ds.graph;

import java.util.List;

public interface WeightedGraph<X,Y> extends Graph {
    Y weight(Edge e);
    default X value(int vertex) { return null; };
}
