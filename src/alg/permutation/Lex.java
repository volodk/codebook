package alg.permutation;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 1:08:45 PM 

public class Lex {

	static void next_permutation(int[] p) {

	}

	static boolean eq(int[] a, int[] b) {
		if (a.length == a.length) {
			int i = 0;
			while (i < a.length) {
				if (a[i] != b[i])
					return false;
				i++;
			}
			return true;
		}
		return false;
	}

	static void swap(int[] arr, int i, int j) {
		int ch = arr[i];
		arr[i] = arr[j];
		arr[j] = ch;
	}

	static void reverse(int[] str, int i, int j) {
		for (; i < j; i++, j--) {
			swap(str, i, j);
		}
	}

}
