package ds.sparsetable;
import java.util.Arrays;

public class SparseTable<T> {

	interface Function<T> {
		T call(T a, T b);
	}

	Object[][] t;

	@SuppressWarnings("unchecked")
	public SparseTable(Function<T> function, T... values) {

		int N = values.length;

		t = new Object[N][log2(N) + 1];

		for (int i = 0; i < N; i++) {
			t[i][0] = values[i];
		}

		for (int j = 1; j <= log2(N); j++) {
			for (int i = 0; i < N; i++) {
				t[i][j] = function.call((T) t[i][j - 1], (T) t[Math.min(i + (1 << j - 1), N - 1)][j - 1]);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public T query(int i, int j) {
		if (i > j)
			throw new IllegalArgumentException();
		return (T) t[i][log2(j - i + 1)];
	}

	private static int log2(int n) {
		return (int) Math.ceil(Math.log(n) / Math.log(2));
	}
}
