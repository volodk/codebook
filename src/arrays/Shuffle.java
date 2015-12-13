package arrays;

import java.util.Arrays;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:36:12 PM 

public class Shuffle {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// shuffle(arr);
		knuthShuffle(arr);

		System.out.println(Arrays.toString(arr));

	}

	static void knuthShuffle(int[] arr) {
		Random rnd = new Random();
		int n = arr.length;
		while (--n > 0) {
			swap(arr, rnd.nextInt(n + 1), n);
		}
		;
	}

	static void shuffle(int[] arr) {
		Random rnd = new Random();
		int n = arr.length;
		do {
			if (rnd.nextFloat() < 1.0 / n) {
				swap(arr, rnd.nextInt(n), n - 1);
			}
		} while (--n > 0);
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
