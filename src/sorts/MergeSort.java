package sorts;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };

		int N = arr.length;

		int[] a = mergesort(arr, 0, N - 1);

		System.out.println(Arrays.toString(a));

	}

	static int[] mergesort(int[] arr, int l, int r) {

		if (l == r)
			return new int[] { arr[l] };

		int m = l + (r - l) / 2;

		int[] left = mergesort(arr, l, m);
		int[] right = mergesort(arr, m + 1, r);

		return merge(left, right);
	}

	static int[] merge(int[] a, int[] b) {
		int N = a.length, M = b.length;
		int[] c = new int[N + M];

		int i, j, k;

		i = j = k = 0;

		while (i < N && j < M) {
			while (i < N && j < M && a[i] < b[j])
				c[k++] = a[i++];
			while (i < N && j < M && a[i] >= b[j])
				c[k++] = b[j++];
		}

		while (i < N)
			c[k++] = a[i++];
		while (j < M)
			c[k++] = b[j++];

		return c;
	}

}
