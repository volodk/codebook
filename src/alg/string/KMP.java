package alg.string;

public class KMP {

	public static int indexOf(String text, String pattern) {
		char[] s = text.toCharArray(), p = pattern.toCharArray();
		int[] f = skipArray(p);
		for (int i = 0; i < s.length - p.length + 1;) {
			int j = 0;
			while (j < p.length && s[i + j] == p[j]) {
				++j;
			}
			if (j == p.length) {
				return i;
			} else {
				i += Math.max(1, f[j]);
			}
		}
		return -1;
	}

	private static int[] skipArray(char[] p) {
		int[] skip = new int[p.length];
		int k = 0;
		skip[k] = 0;
		for (int j = 1; j < p.length; j++) {
			while (k > 0 && p[k] != p[j]) {
				k = skip[k - 1];
			}
			if (p[j] == p[k]) {
				k += 1;
			}
			skip[j] = k;
		}
		return skip;
	}
}
