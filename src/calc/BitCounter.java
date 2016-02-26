package calc;

public class BitCounter {
    
    public static int countBits(int n) {
        int c = 0;
        while(n > 0) {
            n = n & (n-1);
            c += 1;
        }
        return c;
    }
    
	public static void main(String[] args) {
	    System.out.println(countBits(5));  //101
	    System.out.println(countBits(7));  //111
	}
}
