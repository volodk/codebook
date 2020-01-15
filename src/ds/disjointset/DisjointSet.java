package ds.disjointset;

// Union-Find
public class DisjointSet {

	private final int[] ds;

	public DisjointSet(int n) {
		ds = new int[n];
		for (int i = 0; i < n; i++) {
			ds[i] = i;
		}
	}

	public void connect(int a, int b) {
		if (height(a) < height(b)) {
			ds[root(b)] = ds[root(a)];
		} else {
			ds[root(a)] = ds[root(b)];
		}
	}

	public boolean isConnected(int a, int b) {
		return root(a) == root(b);
	}

	public int root(int a) {
		if (ds[a] != a) {
			return root(ds[a]);
		}
		return a;
	}

	private int height(int a) {
		if (ds[a] != a) {
			return 1 + height(ds[a]);
		}
		return 0;
	}

}
