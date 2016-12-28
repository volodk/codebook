package ds.tree.bit;

public class LongBIT {

	private long N;
	private long[] bit;

	public LongBIT(int N) {
		bit = new long[N + 1];
	}

	public long get(int i) {
		int ans = 0;
		while (i > 0){
			ans += bit[i];
			i -= (i & -i);
		}
		return ans;
	}
	
	public void set(int i, long d) {
		while (i <= N){
			bit[i] += d;
			i += i & -i; 
		}
	}

	public long get(int i, int j) {
		return get(j) - get(i);
	}
}
