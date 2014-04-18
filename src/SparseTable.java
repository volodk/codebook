import java.util.Arrays;



public class SparseTable<T> {
    
    interface Function<T> {
        T call(T a, T b);  // any associative function like min, max, mul, avg, gcd, lcm ... 
    }
    
    Object[][] t;
    
    @SuppressWarnings("unchecked")
    public SparseTable(Function<T> function, T ... values) {
        
        int N = values.length;
        
        t = new Object[N][log2(N)];
        
        for(int i = 0; i < N; i++){ t[i][0] = values[i]; }
        
        for( int j = 1; j < log2(N); j++ ){
            for(int i = 0; i < N; i++){
                t[i][j] = function.call( (T) t[i][j-1],  (T) t[ Math.min(i + (1 << j-1), N-1)][j-1]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public T query(int i, int j){
        return (T) t[i][ log2(j-i+1) - 1];
    }
    
    public void print(int N){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(t[i]));
        }
    }
    
    
    public static void main(String[] args) {
        
        Function<Integer> lambda = new Function<Integer>() {
            @Override
            public Integer call(Integer a, Integer b) {
//                return Math.min(a, b);
                return Math.max(a, b);
            }
        };
        
        SparseTable<Integer> st = new SparseTable<Integer>( lambda, 1, 3, 4, 2, 5, 7, 6 );
        
        st.print(7);
        
        System.out.println( st.query(0, 6));
    }
    
    private static int log2(int n) {
        return (int) Math.ceil( Math.log(n) / Math.log(2));
    }
}
