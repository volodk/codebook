package calc;

import java.util.Arrays;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 2:21:41 PM 

//  https://en.wikipedia.org/wiki/Catalan_number

public class CalalanNumbers {

	public static void main(String[] args) {
		
	    int N = 10;
		long[] c = new long[N];
		c[0] = 1;

		for (int n = 1; n < N; n++) {
			for (int k = 0; k < n; k++) {
				c[n] += c[k] * c[n - k - 1];
			}
		}
		
		System.out.println(Arrays.toString(c));
	}

}
