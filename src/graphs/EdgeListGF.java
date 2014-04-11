package graphs;

import java.util.Collection;

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

        public RegularGraph(int V) {
            // TODO Auto-generated constructor stub
        }

        @Override
        public void addEdge(int from, int to) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int V() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int E() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int[] adjacentTo(int v) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean hasEdge(int from, int to) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Graph reverse() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
    class RegularWeightedGraph extends RegularGraph implements Weighted{

        public RegularWeightedGraph(int V) {
            super(V);
        }

        @Override
        public void addEdge(int from, int to, int w) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public int weight(int from, int to) {
            // TODO Auto-generated method stub
            return 0;
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
