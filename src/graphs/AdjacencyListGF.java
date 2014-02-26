package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:18 PM 

public class AdjacencyListGF implements GraphFactory {
    
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

            private final List<Set<Integer>> adjList = new ArrayList<>(V);
            {
                for (int i = 0; i < V; i++) {
                    adjList.set(i, new HashSet<Integer>());
                }
            }

            @Override
            public boolean hasEdge(int from, int to) {
                return adjList.get(from).contains(to);
            }

            @Override
            public int[] adjacentTo(int v) {
                return toArray(adjList.get(v));
            }

            @Override
            public void addEdge(int from, int to) {
                adjList.get(from).add(to);
                adjList.get(to).add(from);
            }

            @Override
            public int V() {
                return V;
            }

            @Override
            public int E() {
                int E = 0;
                for (Set<Integer> s : adjList) {
                    E += s.size();
                }
                return E / 2;
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
            
            private final List<Set<Edge>> adjList = new ArrayList<>(V);

            @Override
            public boolean hasEdge(int from, int to) {
                for(Edge e : adjList.get(from)){
                    if( e.to == to )
                        return true;
                }
                return false;
            }

            @Override
            public int[] adjacentTo(int v) {
                List<Integer> l = new LinkedList<>();
                for( Edge e : adjList.get(v) ){
                    l.add(e.to);
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
                for( Edge e : adjList.get(from) ){
                    if( e.to == to ){
                        return e.weight;
                    }
                }
                return Integer.MAX_VALUE;
            }

            @Override
            public void addEdge(int from, int to, int w) {
                adjList.get(from).add(new Edge(from, to, w));
                adjList.get(to).add(new Edge(to, from, w));
            }

            @Override
            public int E() {
                int E = 0;
                for ( Set<Edge> s : adjList ) {
                    E += s.size();
                }
                return E / 2;
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

            private final List<Set<Integer>> adjList = new ArrayList<>(V);
            {
                for (int i = 0; i < V; i++) {
                    adjList.set(i, new HashSet<Integer>());
                }
            }

            @Override
            public boolean hasEdge(int from, int to) {
                return adjList.get(from).contains(to);
            }

            @Override
            public int[] adjacentTo(int v) {
                return toArray(adjList.get(v));
            }

            @Override
            public void addEdge(int from, int to) {
                adjList.get(from).add(to);
            }

            @Override
            public int V() {
                return V;
            }

            @Override
            public int E() {
                int E = 0;
                for (Set<Integer> s : adjList) {
                    E += s.size();
                }
                return E;
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

            private final List<Set<Edge>> adjList = new ArrayList<>(V);

            @Override
            public boolean hasEdge(int from, int to) {
                for(Edge e : adjList.get(from)){
                    if( e.to == to )
                        return true;
                }
                return false;
            }

            @Override
            public int[] adjacentTo(int v) {
                List<Integer> l = new LinkedList<>();
                for( Edge e : adjList.get(v) ){
                    l.add(e.to);
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
                for( Edge e : adjList.get(from) ){
                    if( e.to == to ){
                        return e.weight;
                    }
                }
                return Integer.MAX_VALUE;
            }

            @Override
            public void addEdge(int from, int to, int w) {
                adjList.get(from).add(new Edge(from, to, w));
            }

            @Override
            public int E() {
                int E = 0;
                for ( Set<Edge> s : adjList ) {
                    E += s.size();
                }
                return E;
            }

            @Override
            public Graph reverse() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

}
