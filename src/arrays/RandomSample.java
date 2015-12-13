package arrays;

import java.util.Arrays;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:27:33 PM 

public class RandomSample {

	public static void main(String[] args) {

		int N = 100;
		int M = 5;

		int[] plot = new int[N];

		for (int Q = 10000; Q < 1000000000; Q *= 10) {
			for (int q = 0; q < 100000; q++) {
				int[] s = randomSample(N, M);
				for (int pos : s)
					plot[pos] += 1;
			}
			System.out.println(Arrays.toString(plot));
		}

	}

	static int[] randomSample(int limit, int sampleSize) {
		int[] sample = new int[sampleSize];
		Random rnd = new Random(System.currentTimeMillis());
		for (int i = 0; i < limit; i++) {
			if (i < sampleSize)
				sample[i] = i;
			else {
				int j = rnd.nextInt(i + 1);
				if (j < sampleSize) {
					sample[j] = i;
				}
			}
		}
		Arrays.sort(sample);
		return sample;
	}

}
