package calc;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:07:34 PM 

public class GCD {

    public static void main(String[] args) {
        
        System.out.println( gcd( 14, 21 ) );

    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
//        return gcd(b, a % b);
        if( a > b) return gcd(b, a - b); 
        return gcd(a, b - a);
    }

}
