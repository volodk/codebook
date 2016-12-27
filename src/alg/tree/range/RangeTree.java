package alg.tree.range;

import java.util.List;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:16:25 PM 

/**
 * In computer science, a range tree is an ordered tree data structure to hold 
 * a list of points. It allows all points within a given range to be reported efficiently,
 * and is typically used in two or higher dimensions. 
 */

/**
 * 
 * A range tree on a set of 1-dimensional points is a balanced binary search
 * tree on those points. The points stored in the tree are stored in the leaves
 * of the tree; each internal node stores the largest value contained in its
 * left subtree. A range tree on a set of points in d-dimensions is a
 * recursively defined multi-level binary search tree. Each level of the data
 * structure is a binary search tree on one of the d-dimensions. The first level
 * is a binary search tree on the first of the d-coordinates. Each setVertexValue v of
 * this tree contains an associated structure that is a (d-1)-dimensional range
 * tree on the last (d-1)-coordinates of the points stored in the subtree of v.
 * 
 */

public class RangeTree {

	static class Node {
		int value;
		Node left, right;
	}

	public void add(int value) {

	}

	List<Integer> between(int from, int to) {
		return null;
	}

	public static void main(String[] args) {

	}

}
