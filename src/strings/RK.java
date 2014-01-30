package strings;

public class RK {

    public static void main(String[] args) {
        
        int B = 'z' - 'a' + 1;
        int M = 179453731;
        
//        baaaaababbaa
//        abbab
        
//        aaaabaaaaabbaaaa
//        aa

        char[] str = "aaaabaaaaabbaaaa".toCharArray();
        char[] p = "aa".toCharArray();
        
        int L = p.length;
        
        int H = hash(p, 0, L, M, B);
        int C = hash(str, 0, L, M, B);
        
        int offset = 0;
        
        do {
            if( C == H ){
                System.out.println(offset);
            }
            offset += 1;
            if( offset <= str.length - L ){
                C = shift(str, C, offset, L, M, B);
            }
        } while(offset <= str.length - L);

    }
    
    static int shift(char[] str, int H, int i, int m, int M, int B){
        int tmp = mul(str[i-1], pow(B, m - 1), M);
        return add( mul( (H - tmp), B, M), str[i + m - 1], M);
    }

    static int hash(char[] str, int i, int m, int M, int B) {
        int H = 0;
        for(int k = 0; k < m; k++){
            int H1 = mul( str[i + k], pow(B, m - k - 1), M );
            H = add(H, H1, M);
        }
        return H;
    }

    private static int add(int a, int b, int M) {
        return (a % M + b % M) % M;
    }

    private static int mul(int a, int b, int M) {
        return (a % M * b % M) % M;
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
    
    private static int pow(int a, int n){
        if( n == 0 ) return 1;
        if( n == 1 ) return a;
        if( n % 2 > 0){
            return a * pow(a, n - 1);
        } else {
            int t = pow(a, n/2);
            return t * t;
        }
    }

}
