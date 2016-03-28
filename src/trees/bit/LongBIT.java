package trees.bit;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:16:38 PM 

public class LongBIT { // a.k.a Fenwick tree

	private long N;
	private long[] bit;

	public LongBIT(int N) {
		bit = new long[N];
	}

	public long sum(int k) {
		int ans = 0;
		for (; k >= 0; k = (k & (k + 1)) - 1)
			ans += bit[k];
		return ans;
	}

	public long sum(int i, int j) {
		return sum(j) - sum(i - 1);
	}

	public void update(int k, long delta) {
		for (; k < N; k = k | (k + 1))
			bit[k] += delta;
	}

}
