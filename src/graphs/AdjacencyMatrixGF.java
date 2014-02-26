package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:26:55 PM 

public class AdjacencyMatrixGF implements GraphFactory {

    @Override
    public Graph regularGraph(final int V) {

        return new Graph() {

            private int[][] G = new int[V][V];
            private int E = 0;

            {
                for (int i = 0; i < V; i++) {
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
                    E++;
                    G[from][to] = 1;
                    G[to][from] = 1;
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
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public Weighted weightedGraph(final int V) {
        return new Weighted() {

            private int[][] G = new int[V][V];
            private int E = 0;
            {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        G[i][j] = Integer.MAX_VALUE;
                    }
                    G[i][i] = 0;
                }
            }

            @Override
            public boolean hasEdge(int from, int to) {
                return G[from][to] != Integer.MAX_VALUE;
            }

            @Override
            public int[] adjacentTo(int v) {
                int n = 0;
                for (int j = 0; j < V; j++) {
                    if (v != j && G[v][j] != Integer.MAX_VALUE)
                        n++;
                }
                int[] adj = new int[n];
                for (int j = 0; j < V; j++) {
                    if (v != j && G[v][j] != Integer.MAX_VALUE)
                        adj[adj.length - n--] = j;
                }
                return adj;
            }

            @Override
            public void addEdge(int from, int to, int w) {
                if ( G[from][to] == Integer.MAX_VALUE ) {
                    E++;
                    G[from][to] = w;
                    G[to][from] = w;
                }
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
                return G[from][to];
            }

            @Override
            public int E() {
                // TODO Auto-generated method stub
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
    public Directed directedGraph(final int V) {
        return new Directed() {

            private int[][] G = new int[V][V];
            private int E = 0;
            
            {
                for (int i = 0; i < V; i++) {
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
                if(G[from][to] == 0){
                    E++;
                    G[from][to] = 1;
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
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public WeightedDirected weightedDirectedGraph(final int V) {
        return new WeightedDirected() {

            private int[][] G = new int[V][V];
            private int E;
            
            {
                for (int i = 0; i < V; i++) {
                    for (int j = i; j < V; j++) {
                        G[i][j] = Integer.MAX_VALUE;
                    }
                    G[i][i] = 0;
                }
            }

            @Override
            public boolean hasEdge(int from, int to) {
                return G[from][to] != Integer.MAX_VALUE;
            }

            @Override
            public int[] adjacentTo(int v) {
                int n = 0;
                for (int j = v; j < V; j++) {
                    if (v != j && G[v][j] != Integer.MAX_VALUE)
                        n++;
                }
                int[] adj = new int[n];
                for (int j = v; j < V; j++) {
                    if (v != j && G[v][j] != Integer.MAX_VALUE)
                        adj[adj.length - n--] = j;
                }
                return adj;
            }

            @Override
            public void addEdge(int from, int to, int w) {
                if ( G[from][to] == Integer.MAX_VALUE ) {
                    E++;
                    G[from][to] = w;
                }
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
                return G[from][to];
            }

            @Override
            public int E() {
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
