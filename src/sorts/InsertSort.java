package sorts;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };

		int N = arr.length;

		for (int i = 0; i < N; i++) {
			int t = arr[i];
			int j = i - 1;
			while (j >= 0 && t < arr[j]) {
				arr[j + 1] = arr[j];
				arr[j] = t;
				j--;
			}
		}

		System.out.println(Arrays.toString(arr));

	}

}
