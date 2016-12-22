package alg.string;

public class RabbinKarp {
	
	private static final int BASE = 'z' - 'a' + 1;
	private static final int MOD = 104729;
	
	public static int indexOf(String text, String pattern){
		int L = pattern.length();
		int H = hash(pattern, 0, L), C = hash(text, 0, L);
		int offset = 0;
		do {
			if (C == H) {
				return offset;
			}
			++offset;
			if (offset <= text.length() - L) {
				C = rollingHash(text, C, offset, L);
			}
		} while (offset <= text.length() - L);
		return -1;
	}

	private static int rollingHash(String str, int hash, int i, int m) {
		int tmp = modmul(str.charAt(i-1), modpow(BASE, m - 1, MOD), MOD);
		return modadd(modmul((hash - tmp), BASE, MOD), str.charAt(i + m - 1), MOD);
	}

	private static int hash(String str, int i, int m) {
		int hash = 0;
		for (int k = 0; k < m; k++) {
			int H1 = modmul(str.charAt(i + k), modpow(BASE, m - k - 1, MOD), MOD);
			hash = modadd(hash, H1, MOD);
		}
		return hash;
	}

	private static int modadd(int a, int b, int M) {
		return (a % M + b % M) % M;
	}

	private static int modmul(int a, int b, int M) {
		int ans = 0;
		while (a > 0) {
			if ((a & 1) == 1) ans = (ans + b) % M;
			a >>= 1;
			b = (b << 1) % M;
		}
		return ans;
	}

	private static int modpow(int a, int n, int M) {
		int ans = 1;
		a %= M;
		while (n > 0) {
			if ((n & 1) == 1) ans = (ans * a) % M;
			a = (a * a) % M;
			n >>= 1;
		}
		return ans;
	}

}
