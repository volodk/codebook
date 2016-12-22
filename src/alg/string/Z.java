package alg.string;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 6:50:58 PM 

public class Z {
	// s = pattern + $ + text
	public static int[] zFunction(char[] s) {
		int N = s.length;
		int[] Z = new int[N];
		int L = 0, R = 0;
		for (int i = 1; i < N; i++) {
			if (i > R) {
				L = R = i;
				while (R < N && s[R - L] == s[R]) 
					R++;
				Z[i] = R - L;
				--R;
			} else {
				int k = i - L;
				if (k < R - i + 1)
					Z[i] = Z[k];
				else {
					L = i;
					while (R < N && s[R - L] == s[R])
						R++;
					Z[i] = R - L;
					--R;
				}
			}
		}
		return Z;
	}
}
