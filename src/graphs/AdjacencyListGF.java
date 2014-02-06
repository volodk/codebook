package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:18 PM 

public class AdjacencyListGF implements GraphFactory {

    private final int V;

    public AdjacencyListGF(int V) {
        this.V = V;
    }

    @Override
    public Graph regularGraph() {
        
        return new Graph() {
            
            @Override
            public boolean hasEdge(int from, int to) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public int[] adjacentTo(int v) {
                // TODO Auto-generated method stub
                return null;
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
        };
    }

    @Override
    public Weighted weightedGraph() {
        return new Weighted() {
            
            @Override
            public boolean hasEdge(int from, int to) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public int[] adjacentTo(int v) {
                // TODO Auto-generated method stub
                return null;
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
            public int weight(int from, int to) {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public void addEdge(int from, int to, int w) {
                // TODO Auto-generated method stub
                
            }
        };
    }

    @Override
    public Directed directedGraph() {
        return new Directed() {
            
            @Override
            public boolean hasEdge(int from, int to) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public int[] adjacentTo(int v) {
                // TODO Auto-generated method stub
                return null;
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
        };
    }

    @Override
    public WeightedDirected weightedDirectedGraph() {
        return new WeightedDirected() {
            
            @Override
            public boolean hasEdge(int from, int to) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public int[] adjacentTo(int v) {
                // TODO Auto-generated method stub
                return null;
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
            public int weight(int from, int to) {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public void addEdge(int from, int to, int w) {
                // TODO Auto-generated method stub
                
            }
        };
    }

}
