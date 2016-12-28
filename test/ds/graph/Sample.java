package ds.graph;

/**
 * Created by volodymyr on 27-12-16.
 */
public class Sample {

    public static void main(String[] args){

        Graph g = Graph.newGraph()
                    .vertices(5)
                    .edge(0, 1)
                    .edge(1, 2)
                    .edge(2, 3)
                    .edge(3, 4)
                    .edge(4, 0)
                .build();

        System.out.println(g.vertexCount());
        System.out.println(g.edgeCount());
        System.out.println(g.edges());

        Graph<Integer, Integer> ig = Graph.newIntValueGraph()
                    .vertices(5)
                    .directed(true)
                    .edge(0,1,5)
                .build();

        System.out.println(ig.edgeCount());
        System.out.println(ig.neighbors(0));
        System.out.println(ig.hasPath(0,1));
        System.out.println(ig.hasPath(1,0));
        System.out.println(ig.edgeValue(0,1));

        Graph<Long, Long> lg = Graph.newLongValueGraph()
                .vertices(5)
                .directed(true)
                .edge(0,1, 5L)
            .build();

        System.out.println(lg.edgeCount());
        System.out.println(lg.neighbors(0));
        System.out.println(lg.hasPath(0,1));
        System.out.println(lg.hasPath(1,0));
        System.out.println(lg.edgeValue(0,1));

        Graph<String, String> sg = Graph.newStringValueGraph()
                .vertices(5)
                .directed(true)
                .edge(0,1, "5")
            .build();

        System.out.println(sg.edgeCount());
        System.out.println(sg.neighbors(0));
        System.out.println(sg.hasPath(0,1));
        System.out.println(sg.hasPath(1,0));
        System.out.println(sg.edgeValue(0,1));
    }
}
