package trees;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:16:38 PM 

/**
 * A Fenwick tree or binary indexed tree is a data structure providing efficient
 * methods for calculation and manipulation of the prefix sums of a table of
 * values. It was proposed by Peter Fenwick in 1994.[1] Fenwick trees primarily
 * solve the problem of balancing prefix sum calculation efficiency with element
 * modification efficiency. The efficiency of these operations comes as a
 * trade-off - greater efficiency in prefix sum calculation is achieved by
 * pre-calculating values, but as more values are pre-calculated more must be
 * re-calculated upon any modification to the underlying value table. Fenwick
 * trees both calculate prefix sums and modify the table in O(\log n) time,
 * where n is the size of the table.
 * 
 */

public class BinaryIndexedTree { // a.k.a Fenwick tree

	int[] t;
	int N;

	public BinaryIndexedTree(int N) {
		t = new int[this.N = N];
	}

	int sum(int k) {
		int ans = 0;
		for (; k >= 0; k = (k & (k + 1)) - 1)
			ans += t[k];
		return ans;
	}

	int sum(int i, int j) {
		return sum(j) - sum(i - 1);
	}

	void update(int k, int delta) {
		for (; k < N; k = k | (k + 1))
			t[k] += delta;
	}

	public static void main(String[] args) {

		BinaryIndexedTree bit = new BinaryIndexedTree(10);

		bit.update(2, 1);
		bit.update(3, 2);
		bit.update(4, 1);

		// {0,0,1,0,0,0,0,0,0,0}
		// {0,0,1,2,0,0,0,0,0,0}
		// {0,0,1,2,1,0,0,0,0,0}

		System.out.println(bit.sum(2, 4)); // 4

	}

}
