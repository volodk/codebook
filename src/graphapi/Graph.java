package graphapi;

import java.util.Iterator;

public interface Graph {
	Iterator<Vertex> vertices();
	Iterator<Edge> edges();
}
