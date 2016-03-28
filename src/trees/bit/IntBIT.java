package trees.bit;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:16:38 PM 

public class IntBIT { // a.k.a Fenwick tree

	private int N;
	private int[] bit;

	public IntBIT(int N) {
		bit = new int[N];
	}

	public int sum(int k) {
		int ans = 0;
		for (; k >= 0; k = (k & (k + 1)) - 1)
			ans += bit[k];
		return ans;
	}

	public int sum(int i, int j) {
		return sum(j) - sum(i - 1);
	}

	public void update(int k, int delta) {
		for (; k < N; k = k | (k + 1))
			bit[k] += delta;
	}

}
