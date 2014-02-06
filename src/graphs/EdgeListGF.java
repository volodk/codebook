package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:27:37 PM 

public class EdgeListGF implements GraphFactory {

    @Override
    public Graph regularGraph(final int V) {
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

            @Override
            public int E() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

    @Override
    public Weighted weightedGraph(final int V) {
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

            @Override
            public int E() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

    @Override
    public Directed directedGraph(final int V) {
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

            @Override
            public int E() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

    @Override
    public WeightedDirected weightedDirectedGraph(final int V) {
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

            @Override
            public int E() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

}
