package calc;

import java.util.function.Function;

public class BitCounter {
    
    public static int countBits(int n) {
        int c = 0;
        while(n > 0) {
            n = n & (n-1);
            c += 1;
        }
        return c;
    }
    
    public static int countBitsWithMask(int n) {
        n = (n & 0x55555555) + (n >> 1 & 0x55555555);
        n = (n & 0x33333333) + (n >> 2 & 0x33333333);
        n = (n & 0x33333333) + (n >> 4 & 0x33333333);
        
        return n;
    }
    
	public static void main(String[] args) {
	    
	    Function<Integer, Integer> f1 = BitCounter :: countBits;
	    Function<Integer, Integer> f2 = BitCounter :: countBitsWithMask;
	    
	    System.out.println(f1.apply(5));  //101
	    System.out.println(f1.apply(7));  //101
	    
	    System.out.println(f2.apply(5));  //101
        System.out.println(f2.apply(7));  //101
	   
	}
}
