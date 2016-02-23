package strings;

public class RabbinKarp {

	public static void main(String[] args) {

		int B = 'z' - 'a' + 1;
		int M = 46337;

		char[] str = "aaaabaaaaabbaaaa".toCharArray();
		char[] p = "aa".toCharArray();

		int L = p.length;

		int H = hash(p, 0, L, M, B);
		int C = hash(str, 0, L, M, B);

		int offset = 0;

		do {
			if (C == H) {
				System.out.println(offset);
			}
			offset += 1;
			if (offset <= str.length - L) {
				C = shift(str, C, offset, L, M, B);
			}
		} while (offset <= str.length - L);

	}

	static int shift(char[] str, int H, int i, int m, int M, int B) {
		int tmp = modmul(str[i - 1], modpow(B, m - 1, M), M);
		return add(modmul((H - tmp), B, M), str[i + m - 1], M);
	}

	static int hash(char[] str, int i, int m, int M, int B) {
		int H = 0;
		for (int k = 0; k < m; k++) {
			int H1 = modmul(str[i + k], modpow(B, m - k - 1, M), M);
			H = add(H, H1, M);
		}
		return H;
	}

	private static int add(int a, int b, int M) {
		return (a % M + b % M) % M;
	}

	static int modmul(int a, int b, int M) {
		int res = 0;
		while (a > 0) {
			if ((a & 1) == 1)
				res = (res + b) % M;
			a >>= 1;
			b = (b << 1) % M;
		}
		return res;
	}

	static int modpow(int a, int n, int M) {
		a %= M;
		int result = 1;
		while (n > 0) {
			if ((n & 1) == 1)
				result = (result * a) % M;
			a = (a * a) % M;
			n >>= 1;
		}
		return result;
	}

}
