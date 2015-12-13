package graphs;

import graphs.GraphFactory.StorageType;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:23:50 PM 

public class AbstractGraphFactory {

	private AbstractGraphFactory() {
	}

	public static GraphFactory getFactory(StorageType type) {
		switch (type) {

		default:
		case ADJACENCY_MATRIX:
			return new AdjacencyMatrixGF();

		case ADJACENCY_LIST:
			return new AdjacencyListGF();

		case EDGE_LIST:
			return new EdgeListGF();

		}
	}
}
