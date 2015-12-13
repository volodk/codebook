package dynamic_programming;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:25:35 PM 

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(fib(40));
		System.out.println(fib2(40));

	}

	private static long fib(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 0 || n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	private static long fib2(int n) {
		int[] d = new int[n + 1];
		d[0] = d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		return d[n];
	}

}
