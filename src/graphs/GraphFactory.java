package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:03:11 PM 

public interface GraphFactory {
    
    enum StorageType {
        ADJACENCY_MATRIX, ADJACENCY_LIST, EDGE_LIST
    }
    
    class Edge{
        int from, to, weight;
        
        public Edge(int from, int to) {
            this.from = from;  this.to = to;
        }

        public Edge(int from, int to, int weight) {
            this.from = from;  this.to = to;  this.weight = weight;
        }
        
        public static Edge valueOf(int from, int to){
            return new Edge(from, to);
        }
        
        public static Edge valueOf(int from, int to, int weight){
            return new Edge(from, to, weight);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + from;
            result = prime * result + to;
            result = prime * result + weight;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass() )
                return false;
            Edge other = (Edge) obj;
            if (from != other.from || to != other.to || weight != other.weight)
                return false;
            return true;
        }
    }
    
    Graph regularGraph(final int V);
    
    Weighted weightedGraph(final int V);
    
    Directed directedGraph(final int V);
    
    WeightedDirected weightedDirectedGraph(final int V);
}
