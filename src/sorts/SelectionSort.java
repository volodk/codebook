package sorts;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };
		int n = arr.length;

		for (int i = n - 1; i > 0; i--) {
			int max = arr[i];
			int pos = i;
			for (int j = 0; j < i; j++) {
				if (arr[j] > max) {
					max = arr[pos = j];
				}
			}
			swap(arr, pos, i);
		}

		System.out.println(Arrays.toString(arr));

	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
