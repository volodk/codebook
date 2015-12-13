package sorts;

import java.util.Arrays;

public class QuickSort3Way {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 3, 1, 2, 3, 4, 4, 1, 2, 3, 4, 1, 2, 3 };

		qsort(arr, 0, arr.length);

		System.out.println(Arrays.toString(arr));
	}

	private static void qsort(int[] arr, int l, int r) {

		if (l < r) {

			int pivot = arr[l];
			int lt = l + 1, gt = r - 1, i = l + 1;
			while (i < gt) {
				if (arr[i] < pivot) {
					swap(arr, lt++, i++);
				} else if (arr[i] > pivot) {
					swap(arr, gt--, i);
				} else {
					i++;
				}
			}
			swap(arr, l, lt);

			qsort(arr, l, lt - 1);
			qsort(arr, gt + 1, r);
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
