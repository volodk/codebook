package sorts;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };

		int N = arr.length;

		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j])
					swap(arr, i, j);
			}

		System.out.println(Arrays.toString(arr));

	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
