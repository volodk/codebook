package test;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:25:25 PM 

public class UniqueNum {

	public static void main(String[] args) {
		
		int N = 1024;
		long bound = 9876543210L;
		
		final int q = (int) bound / N;
		
		for( int n = 0; n < N ; n++ ){
			final int offset = n;
			new Thread(new Runnable() {
				@Override
				public void run() {
					filter( offset * q, offset * q + q );
				}
			}).start();
		}
		
	}

	private static void filter(long min, long max) {
		while( min < max ){
			long print = min, val = min;
			int mask = 0, shift = 0;
			while( val > 0 && (mask & shift) == 0) {
				mask |= shift;
				int digit = (int)(val % 10);
				shift = 1 << digit;
				val /= 10;
			}
			if( val == 0 ){
				System.out.println(print);
			}
			min++;
		}
	}

}
