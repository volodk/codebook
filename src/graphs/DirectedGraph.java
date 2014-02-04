package graphs;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:57:14 PM 

public class DirectedGraph extends Graph {
    
    private boolean loopsAllowed;
    
    public DirectedGraph(int V) {
        super(V);
    }

    public DirectedGraph(int V, boolean loopsAllowed) {
        super(V);
        this.loopsAllowed = loopsAllowed;
    }
    
    public DirectedGraph reverse(){
        DirectedGraph r = new DirectedGraph(V());
        
        for( int from = 0; from < V(); from++ ){
            for( Integer to : getAdjacent(from) ){
                r.addEdge(to, from);
            }
        }
        
        return r;
    }
    
    @Override
    public void addEdge(int from, int to) {
        if(from != to || ( from == to && loopsAllowed) )
            adjList.get(from).add(to);
    }
    
    @Override
    public void removeEdge(int from, int to) {
        adjList.get(from).remove(to);
    }
    
    @Override
    public int E(){
        int E = 0;
        for( int i = 0; i < adjList.size(); i++ ){
            E += adjList.get(i).size();
        }
        return E;
    }

}
