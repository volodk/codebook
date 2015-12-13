package arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {

	public static void main(String[] args) {

		Random rnd = new Random();

		int N = 1000, M = 10;

		int[] arr = new int[M];

		for (int i = 0; i < N; i++) {
			if (i < M) {
				arr[i] = i;
			} else {
				int j = rnd.nextInt(i + 1);
				if (j < M) {
					arr[j] = i;
				}
			}
		}

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

	}

}
