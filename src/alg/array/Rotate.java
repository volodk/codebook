package alg.array;

import java.util.Arrays;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 1:36:39 PM 

public class Rotate {

	static int isRotated(int[] arr, int l, int r) {
		if (arr[l] > arr[r]) {

			if (r - l == 1)
				return r;

			int m = l + (r - l) / 2;

			return Math.max(isRotated(arr, l, m), isRotated(arr, m + 1, r));

		} else {
			return -1;
		}
	}

	static void rol(int[] arr, int k) {
		if (k < 0)
			throw new IllegalArgumentException();
		k = k % arr.length;
		int l = 0, r = arr.length - 1;
		if (k > 0) {
			int a = arr[l];
			for (int i = 1; i <= r; i++) {
				arr[i - 1] = arr[i];
			}
			arr[r] = a;
			rol(arr, k - 1);
		}
	}

	static void rol2(int[] arr, int k) {
		int N = arr.length;
		k = k % N;
		for (int i = 0; i < gcd(k, N); i++) {
			int j = i;
			int t = arr[j];
			for (int c = 0; c < N / gcd(k, N) - 1; c++) {
				int m = (j + k) % N;
				arr[j] = arr[m];
				j = m;
			}
			arr[j] = t;
		}
	}

	static void rol3(int[] arr, int k) {
		int N = arr.length;
		int[] brr = Arrays.copyOf(arr, N);
		for (int i = 0; i < N; i++) {
			brr[i] = arr[(i + k) % N];
		}
		System.arraycopy(brr, 0, arr, 0, N);
	}

	static void ror(int[] arr, int k) {
		if (k < 0)
			throw new IllegalArgumentException();
		k = k % arr.length;
		int l = 0, r = arr.length - 1;
		if (k > 0) {
			int a = arr[r];
			for (int i = r; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[l] = a;
			ror(arr, k - 1);
		}
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		if (a > b)
			return gcd(b, a - b);
		else
			return gcd(a, b - a);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		rol(arr, 5);

		System.out.println(Arrays.toString(arr));

		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		ror(arr2, 8);

		System.out.println(Arrays.toString(arr2));

		System.out.println(isRotated(arr2, 0, arr2.length - 1));

		int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		rol2(arr3, 3);

		System.out.println(Arrays.toString(arr3));

		int[] arr4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		rol2(arr4, 3);

		System.out.println(Arrays.toString(arr4));
	}
}
