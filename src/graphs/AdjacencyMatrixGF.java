package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:26:55 PM 

public class AdjacencyMatrixGF implements GraphFactory {
    
    @Override
    public Graph regularGraph(final int V) {
        return new RegularGraph(V, 1);
    }

    @Override
    public Weighted weightedGraph(final int V) {
        return new RegularWeightedGraph(V, Integer.MAX_VALUE);
    }

    @Override
    public Directed directedGraph(final int V) {
        return new RegularDirectedGraph(V, 1);
    }

    @Override
    public WeightedDirected weightedDirectedGraph(final int V) {
        return new RegularWeightedDirectedGraph(V, Integer.MAX_VALUE);
    }
    
    class RegularGraph implements Graph{
        protected int[][] G;
        protected int V, E;
        protected int defaultWeight;
        public RegularGraph(int V, int defaultWeight){
            this.V = V;
            this.defaultWeight = defaultWeight;
            G = new int[V][V];
            for (int i = 0; i < V; i++) {
                G[i][i] = defaultWeight;
            }
        }
        @Override
        public boolean hasEdge(int from, int to) {
            return G[from][to] == defaultWeight;
        }
        @Override
        public int[] adjacentTo(int v) {
            int n = 0;
            for (int j = 0; j < V; j++) {
                if (v != j && G[v][j] != 0)
                    n++;
            }
            int[] adj = new int[n];
            for (int j = 0; j < V; j++) {
                if (v != j && G[v][j] != 0)
                    adj[adj.length - n--] = j;
            }
            return adj;
        }
        @Override
        public void addEdge(int from, int to) {
            if( G[from][to] == 0 ){
                E++;
                G[from][to] = G[to][from] = defaultWeight;
            }
        }
        @Override
        public int V() {
            return V;
        }
        @Override
        public int E() {
            return E;
        }
        @Override
        public Graph reverse() {
            RegularGraph copy = new RegularGraph(V, defaultWeight);
            for( int i = 0; i < V; i++ ){
                System.arraycopy(G[i], 0, copy.G[i], 0, V);
            }
            return copy;
        }
    }
    
    class RegularWeightedGraph extends RegularGraph implements Weighted{
        public RegularWeightedGraph(int V, int defaultWeight) {
            super(V, defaultWeight);
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    G[i][j] = defaultWeight;
                }
                G[i][i] = 0;
            }
        }
        @Override
        public void addEdge(int from, int to, int w) {
            if ( G[from][to] == defaultWeight ) {
                E++;
                G[from][to] = G[to][from] = w;
            }
        }
        @Override
        public int weight(int from, int to) {
            return G[from][to];
        }
        @Override
        public Graph reverse() {
            RegularWeightedGraph copy = new RegularWeightedGraph(V, defaultWeight);
            for( int i = 0; i < V; i++ ){
                System.arraycopy(G[i], 0, copy.G[i], 0, V);
            }
            return copy;
        }
    }
    
    class RegularDirectedGraph extends RegularGraph implements Directed{
        public RegularDirectedGraph(int V, int defaultWeight) {
            super(V, defaultWeight);
        }
        @Override
        public Graph reverse() {
            RegularDirectedGraph copy = new RegularDirectedGraph(V, defaultWeight);
            for( int i = 0; i < V; i++ ){
                System.arraycopy(G[i], 0, copy.G[i], 0, V);
            }
            return copy;
        }
    }
    
    class RegularWeightedDirectedGraph extends RegularWeightedGraph implements WeightedDirected {
        public RegularWeightedDirectedGraph(int V, int defaultWeight) {
            super(V, defaultWeight);
        }
        @Override
        public Graph reverse() {
            RegularWeightedDirectedGraph copy = new RegularWeightedDirectedGraph(V, defaultWeight);
            for( int i = 0; i < V; i++ ){
                System.arraycopy(G[i], 0, copy.G[i], 0, V);
            }
            return copy;
        }
    }

}
