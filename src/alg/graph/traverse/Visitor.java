package alg.graph.traverse;

import ds.graph.Graph;

/**
 * Created by vkrasnikov on 03/01/17.
 */
public interface Visitor {

    default void openVertex(Graph g, Integer v) {};

    default void closeVertex(Graph g, Integer v) {};
}
