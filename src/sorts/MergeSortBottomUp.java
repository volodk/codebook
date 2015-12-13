package sorts;

import java.util.Arrays;

public class MergeSortBottomUp {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 1, 5, 2, 6, 0 };

		int N = arr.length;

		int[] buff = new int[N];

		mergesort(arr, buff, N);

		System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.toString(buff));

	}

	static void mergesort(int[] arr, int[] buff, int N) {
		int[] copy = arr;
		for (int k = 1; k < N; k += k) {
			for (int i = 0, j = k; i < N; i += 2 * k, j += 2 * k) {
				int n = Math.min(i + k, N);
				int m = Math.min(j + k, N);
				merge(buff, arr, i, n, j, m);
			}
			int[] ref = buff;
			buff = arr;
			arr = ref;
		}
		System.arraycopy(arr, 0, copy, 0, N);
	}

	static void merge(int[] a, int[] b, int i, int n, int j, int m) {
		int k = i;
		while (i < n && j < m) {
			while (i < n && b[i] < b[j])
				a[k++] = b[i++];
			while (j < m && b[i] >= b[j])
				a[k++] = b[j++];
		}
		while (i < n)
			a[k++] = b[i++];
		while (j < m)
			a[k++] = b[j++];
	}

}
