package graphs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:37 PM 

public class EdgeListGF implements GraphFactory {

    private static int[] toArray(Collection<Integer> collection) {
        int[] arr = new int[collection.size()];
        int i = 0;
        for (Integer o : collection) {
            arr[i++] = o;
        }
        return arr;
    }

    @Override
    public Graph regularGraph(final int V) {
        return new Graph() {

            private final List<Edge> edges = new LinkedList<>();

            @Override
            public boolean hasEdge(int from, int to) {
                return edges.contains(new Edge(from, to));
            }

            @Override
            public int[] adjacentTo(int v) {
                List<Integer> l = new LinkedList<>();
                for (Edge e : edges) {
                    if (e.from == v) {
                        l.add(e.to);
                    }
                }
                return toArray(l);
            }

            @Override
            public void addEdge(int from, int to) {
                edges.add(new Edge(from, to));
            }

            @Override
            public int V() {
                return V;
            }

            @Override
            public int E() {
                return edges.size();
            }

            @Override
            public Graph reverse() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public Weighted weightedGraph(final int V) {
        return new Weighted() {
            
            private final List<Edge> edges = new LinkedList<>();

            @Override
            public boolean hasEdge(int from, int to) {
                return edges.contains(new Edge(from, to));
            }

            @Override
            public int[] adjacentTo(int v) {
                List<Integer> l = new LinkedList<>();
                for (Edge e : edges) {
                    if (e.from == v) {
                        l.add(e.to);
                    }
                }
                return toArray(l);
            }

            @Override
            public void addEdge(int from, int to) {
                addEdge(from, to, 1);
            }

            @Override
            public int V() {
                return V;
            }

            @Override
            public int weight(int from, int to) {
                for (Edge e : edges) {
                    if (e.from == from && e.to == to) {
                        return e.weight;
                    }
                }
                return Integer.MAX_VALUE;
            }

            @Override
            public void addEdge(int from, int to, int w) {
                edges.add(new Edge(from, to, w));
            }

            @Override
            public int E() {
                return edges.size();
            }

            @Override
            public Graph reverse() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public Directed directedGraph(final int V) {
        return new Directed() {

            private final List<Edge> edges = new LinkedList<>();

            @Override
            public boolean hasEdge(int from, int to) {
                return edges.contains(new Edge(from, to));
            }

            @Override
            public int[] adjacentTo(int v) {
                List<Integer> l = new LinkedList<>();
                for (Edge e : edges) {
                    if (e.from == v) {
                        l.add(e.to);
                    }
                }
                return toArray(l);
            }

            @Override
            public void addEdge(int from, int to) {
                edges.add(new Edge(from, to));
            }

            @Override
            public int V() {
                return V;
            }

            @Override
            public int E() {
                return edges.size();
            }

            @Override
            public Graph reverse() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public WeightedDirected weightedDirectedGraph(final int V) {
        return new WeightedDirected() {

            private final List<Edge> edges = new LinkedList<>();

            @Override
            public boolean hasEdge(int from, int to) {
                return edges.contains(new Edge(from, to));
            }

            @Override
            public int[] adjacentTo(int v) {
                List<Integer> l = new LinkedList<>();
                for (Edge e : edges) {
                    if (e.from == v) {
                        l.add(e.to);
                    }
                }
                return toArray(l);
            }

            @Override
            public void addEdge(int from, int to) {
                addEdge(from, to, 1);
            }

            @Override
            public int V() {
                return V;
            }

            @Override
            public int weight(int from, int to) {
                for (Edge e : edges) {
                    if (e.from == from && e.to == to) {
                        return e.weight;
                    }
                }
                return Integer.MAX_VALUE;
            }

            @Override
            public void addEdge(int from, int to, int w) {
                edges.add(new Edge(from, to, w));
            }

            @Override
            public int E() {
                return edges.size();
            }

            @Override
            public Graph reverse() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

}
