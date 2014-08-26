import java.util.Arrays;

public class SparseTable<T> {
    
    interface Function<T> {
        T call(T a, T b);  // commutative function
    }
    
    Object[][] t;
    
    @SuppressWarnings("unchecked")
    public SparseTable(Function<T> function, T ... values) {
        
        int N = values.length;
        
        t = new Object[N][ log2(N) + 1];
        
        for(int i = 0; i < N; i++){ t[i][0] = values[i]; }
        
        for( int j = 1; j <= log2(N); j++ ){
            for(int i = 0; i < N; i++){
                t[i][j] = function.call( (T) t[i][j-1],  (T) t[ Math.min( i + (1 << j-1), N-1)][j-1]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public T query(int i, int j){
        if( i > j)
            throw new IllegalArgumentException();
        return (T) t[i][ log2(j-i+1) ];
    }
    
    public void print(){
        for(int i = 0; i < t.length; i++){
            System.out.println(Arrays.toString(t[i]));
        }
    }
    
    
    public static void main(String[] args) {
        
        Function<Integer> fun = new Function<Integer>() {
            @Override
            public Integer call(Integer a, Integer b) {
                return Math.min(a, b);
//                return Math.max(a, b);
                
            }
        };
        
        SparseTable<Integer> st = new SparseTable<Integer>( fun, 2,5,0,6,8,-1,9,3,4 );
        
        st.print();
        
        System.out.println( st.query(1, 5) );
    }
    
    private static int log2(int n) {
        return (int) Math.ceil( Math.log(n) / Math.log(2));
    }
}
