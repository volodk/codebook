package permutations;

import java.util.Arrays;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 6:53:48 PM 

public class Antilex2 {

	public static void main(String[] args) {

		char[] p = { 'a', 'b', 'c', 'd' };

		int m = p.length;

		antilex(p, m - 1);

	}

	static void antilex(char[] p, int m) {
		if (m == 0) {
			System.out.println(String.valueOf(p));
		} else {
			for (int i = 0; i <= m; i++) {
				antilex(p, m - 1);
				if (i < m) {
					swap(p, i, m);
					reverse(p, 0, m - 1);
				}
			}
		}
	}

	static void swap(char[] arr, int i, int j) {
		char ch = arr[i];
		arr[i] = arr[j];
		arr[j] = ch;
	}

	static void reverse(char[] str, int i, int j) {
		for (; i < j; i++, j--) {
			swap(str, i, j);
		}
	}

}
