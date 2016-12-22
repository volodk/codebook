package ds.disjointset;
import java.util.Arrays;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 1:27:47 PM 

public class DisjointSet {

	private int[] ds;

	public DisjointSet(int N) {
		ds = new int[N];
		for (int i = 0; i < N; i++)
			ds[i] = i;
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
		if (ds[a] != a)
			return root(ds[a]);
		return a;
	}

	private int height(int a) {
		if (ds[a] != a)
			return 1 + height(ds[a]);
		return 0;
	}

	public void print() {
		System.out.println(Arrays.toString(ds));
		System.out.print("[");
		for (int i = 0; i < ds.length - 1; i++) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print(ds.length - 1);
		System.out.println("]\n");
	}
}
