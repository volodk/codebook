package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:18 PM 

public class AdjacencyListGF implements GraphFactory {

    @Override
    public Graph undirectedGraph(final int V) {
        return new RegularGraph(V);
    }

    @Override
    public Graph weightedGraph(final int V) {
        return new RegularWeightedGraph(V);
    }

    @Override
    public Graph directedGraph(final int V) {
        return new RegularDirectedGraph(V);
    }

    @Override
    public Graph weightedDirectedGraph(final int V) {
        return new RegularWeightedDirectedGraph(V);
    }

    class RegularGraph implements Graph, Undirected {

        protected int V, E;
        private List< Set<Edge> > adjList;

        public RegularGraph(int V) {
            this.V = V;
            adjList = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adjList.set(i, new HashSet< Edge >());
            }
        }

        public RegularGraph(int v, int e, List<Set<Edge>> adjList) {
            V = v;
            E = e;
            this.adjList = adjList;
        }

        @Override
        public void addEdge(int from, int to) {
            adjList.get(from).add(Edge.of(from, to));
            adjList.get(to).add(Edge.of(to, from));
            
            E += 1;
        }

        @Override
        public int V() { return V; }

        @Override
        public int E() { return E; }

        @Override
        public int[] adjacentTo(int v) {
            Edge[] edges = (Edge[]) adjList.get(v).toArray();
            int[] arr = new int[edges.length];
            for( int i = 0; i < arr.length; i++ ){
                arr[i] = edges[i].to;
            }
            return arr;
        }

        @Override
        public boolean hasEdge(int from, int to) {
            return adjList.get(from).contains(Edge.of(from, to));
        }

        @Override
        public Graph reverse() {
            List<Set<Edge>> reversedAdjList = new ArrayList<>(V);
            for( Set<Edge> se : adjList ){
                
                Set<Edge> adjSet = new HashSet<>();
                reversedAdjList.add(adjSet);
                
                for( Edge e : se ){
                    adjSet.add(Edge.reverse(e));
                }
            }
            return new RegularGraph(V, E, reversedAdjList);
        }
        
    }
    
    class RegularWeightedGraph extends RegularGraph implements Weighted{
        
        private List< Set<WeightedEdge> > adjList;

        public RegularWeightedGraph(int V) {
            super(V);
            adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.set(i, new HashSet< WeightedEdge >());
            }
        }

        public RegularWeightedGraph(int V, int E, List<Set<WeightedEdge>> reversedAdjList) {
            super(V);
            this.E = E;
            this.adjList = reversedAdjList;
        }

        @Override
        public void addEdge(int from, int to, int w) {
            adjList.get(from).add(WeightedEdge.of(from, to, w));
            adjList.get(to).add(WeightedEdge.of(to, from, w));
            
            E += 1;
        }

        @Override
        public int weight(int from, int to) {
            WeightedEdge[] edges = (WeightedEdge[]) adjList.get(from).toArray();
            
            for( WeightedEdge e : edges ){
                if( e.to == to )
                    return e.weight;
            }
            return Integer.MAX_VALUE;
        }
        
        @Override
        public Graph reverse() {
            List<Set<WeightedEdge>> reversedAdjList = new ArrayList<>(V);
            for( Set<WeightedEdge> se : adjList ){
                
                Set<WeightedEdge> adjSet = new HashSet<>();
                reversedAdjList.add(adjSet);
                
                for( WeightedEdge e : se ){
                    adjSet.add( WeightedEdge.reverse(e) );
                }
            }
            return new RegularWeightedGraph(V, E, reversedAdjList);
        }
    }
    
    class RegularDirectedGraph extends RegularGraph implements Directed {

        public RegularDirectedGraph(int V) {
            super(V);
        }
        
    }
    
    class RegularWeightedDirectedGraph extends RegularWeightedGraph implements Weighted, Directed{

        public RegularWeightedDirectedGraph(int V) {
            super(V);
            // TODO Auto-generated constructor stub
        }
        
    }
   

}
