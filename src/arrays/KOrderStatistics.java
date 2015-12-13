package arrays;

public class KOrderStatistics {

	public static void main(String[] args) {

		int[] A = { 2, 3, 1, 7, 5, 6, 8, 4 };

		int k = 5;

		if (k > A.length - 1)
			throw new IllegalArgumentException();

		int p, l = 0, r = A.length;
		do {
			p = Partition.random(A, l, r);
			if (p > k) {
				r = p;
			} else if (p < k) {
				l = p + 1;
			}
		} while (k != p);

		System.out.println(A[p]);

	}

}
