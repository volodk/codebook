package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:26:55 PM 

public class AdjacencyMatrixGF implements GraphFactory {
    
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
    
    class RegularGraph implements Graph, Undirected{
        int[][] G;
        int V, E;
        public RegularGraph(int V){
            this.V = V;
            G = new int[V][V];
            for(int i = 0; i < V; i++){
                G[i][i] = 1;
            }
        }
        @Override
        public boolean hasEdge(int from, int to) {
            return G[from][to] == 1;
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
                G[from][to] = G[to][from] = 1;
                E++;
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
            RegularGraph copy = new RegularGraph(V);
            for( int i = 0; i < V; i++ ){
                System.arraycopy(G[i], 0, copy.G[i], 0, V);
            }
            return copy;
        }
    }
    
    class RegularWeightedGraph extends RegularGraph implements Weighted{
        public RegularWeightedGraph(int V) {
            super(V);
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    G[i][j] = Integer.MAX_VALUE;
                }
                G[i][i] = 0;
            }
        }
        @Override
        public void addEdge(int from, int to, int w) {
            if ( G[from][to] == Integer.MAX_VALUE ) {
                G[from][to] = G[to][from] = w;
                E++;
            }
        }
        @Override
        public boolean hasEdge(int from, int to) {
            return G[to][from] != Integer.MAX_VALUE;
        }
        @Override
        public int weight(int from, int to) {
            return G[from][to];
        }
        @Override
        public Graph reverse() {
            RegularWeightedGraph copy = new RegularWeightedGraph(V);
            for( int i = 0; i < V; i++ ){
                System.arraycopy(G[i], 0, copy.G[i], 0, V);
            }
            return copy;
        }
    }
    
    class RegularDirectedGraph extends RegularGraph implements Directed{
        public RegularDirectedGraph(int V) {
            super(V);
        }
        @Override
        public void addEdge(int from, int to) {
            if ( G[from][to] == 0 ) {
                G[from][to] = 1;
                E++;
            }
        }
        @Override
        public Graph reverse() {
            RegularDirectedGraph copy = new RegularDirectedGraph(V);
            for( int i = 0; i < V; i++ ){
                for(int j = 0; j < V; j++){
                    copy.G[i][j] = G[j][i];
                }
            }
            return copy;
        }
    }
    
    class RegularWeightedDirectedGraph extends RegularWeightedGraph implements Weighted, Directed {
        public RegularWeightedDirectedGraph(int V) {
            super(V);
        }
        @Override
        public void addEdge(int from, int to, int w) {
            if ( G[from][to] == Integer.MAX_VALUE ) {
                G[from][to] = w;
                E++;
            }
        }
        @Override
        public Graph reverse() {
            RegularDirectedGraph copy = new RegularDirectedGraph(V);
            for( int i = 0; i < V; i++ ){
                for(int j = 0; j < V; j++){
                    copy.G[i][j] = G[j][i];
                }
            }
            return copy;
        }
    }

}
