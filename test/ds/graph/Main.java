package ds.graph;

/**
 * Created by volodymyr on 27-12-16.
 */
public class Main {

    public static void main(String[] args){

        Graph.IntGraph g = new Graph.IntGraph(5);
        g.isDirected(true);
        g.edge(0,1);

        System.out.println(g.edgeCount());
        System.out.println(g.neighbors(0));
        System.out.println(g.hasPath(0,1));
        System.out.println(g.hasPath(1,0));
        System.out.println(g.edgeValue(0,1));
    }
}
