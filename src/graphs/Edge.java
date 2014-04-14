package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:34:36 PM 

class Edge {
    
    int from, to;
    
    public Edge(int from, int to) {
        this.from = from;  this.to = to;
    }
       
    public static Edge of(int from, int to){
        return new Edge(from, to);
    }
    
    public int either(){ return from; }
    
    public int other(){ return to; }

    public static Edge reverse(Edge e) {
        return Edge.of(e.to, e.from);
    }
    
    @Override
    public String toString() {
        return from + "-" + to;
    }
   
}

