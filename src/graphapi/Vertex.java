package graphapi;

import java.util.Iterator;

public interface Vertex {
	Iterator<Vertex> adjacentVertices();
}
