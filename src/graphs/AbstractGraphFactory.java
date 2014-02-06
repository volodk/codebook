package graphs;

import graphs.GraphFactory.StorageType;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:23:50 PM 

public class AbstractGraphFactory {
    
    private AbstractGraphFactory() {
        // TODO Auto-generated constructor stub
    }

    public static GraphFactory byStorageType(StorageType type, int vertexCount) {
        switch (type) {

        default: case ADJACENCY_MATRIX:
            return new AdjacencyMatrixGF(vertexCount);

        case ADJACENCY_LIST:
            return new AdjacencyListGF(vertexCount);

        case EDGE_LIST:
            return new EdgeListGF(vertexCount);

        }
    }
}
