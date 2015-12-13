package strings;

public class KMP {

	public static void main(String[] args) {

		String s = "aaaaaababaa";
		String p = "ababaa";

		int offset = indexOf(s, p);

		System.out.println(offset);

	}

	private static int indexOf(String str, String pat) {

		char[] s = str.toCharArray();
		char[] p = pat.toCharArray();

		int[] f = overlap(p);

		for (int i = 0; i < s.length - p.length + 1;) {

			int j = 0;
			for (; j < p.length; j++) {
				if (s[i + j] != p[j]) {
					break;
				}
			}
			if (j == p.length) {
				return i;
			} else {
				i += Math.max(1, f[j]);
			}
		}

		return -1;
	}

	private static int[] overlap(char[] p) {
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
