package alg.sort;

import java.util.Arrays;

public class MergeSort2 {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };

		int N = arr.length;

		mergesort(arr, new int[N], 0, N - 1);

		System.out.println(Arrays.toString(arr));

	}

	static void mergesort(int[] arr, int[] buff, int l, int r) {

		if (l == r) {
			buff[l] = arr[l];
		} else {

			int m = l + (r - l) / 2;

			mergesort(arr, buff, l, m);
			mergesort(arr, buff, m + 1, r);

			System.arraycopy(arr, 0, buff, 0, arr.length);

			merge(arr, buff, l, m, m + 1, r);
		}
	}

	static void merge(int[] a, int[] b, int l0, int r0, int l1, int r1) {

		int k = l0;

		while (l0 <= r0 && l1 <= r1) {
			while (l0 <= r0 && l1 <= r1 && b[l0] < b[l1])
				a[k++] = b[l0++];
			while (l0 <= r0 && l1 <= r1 && b[l0] >= b[l1])
				a[k++] = b[l1++];
		}
		while (l0 <= r0)
			a[k++] = b[l0++];
		while (l1 <= r1)
			a[k++] = b[l1++];
	}

}
