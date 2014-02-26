import java.lang.reflect.Array;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:38:23 PM 

public class SegmentTree<T> {

    interface Function<T>{ T f(T a, T b); }  // any associative function like min, max, mul, avg, gcd ...
    
    private Function<T> fun;
    
    public SegmentTree(Function<T> f, Class<T> klass, T ... values) {
        this.fun = f;
        
        int N = values.length;
        
        @SuppressWarnings("unchecked")
        T[][] t = (T[][]) Array.newInstance(klass, N, log2(N));
        
        for(int i = 0; i < N; i++){
            t[i][0] = values[i];
        }
        
        for(int i = 0; i < N; i++){
            for( int j = 0; j < log2(N); j++ ){
                t[i][j] = fun.f( t[i][j-1], t[i + 1 << (j-1)][j-1] );
            }
        }
        
    }
    
    private int log2(int n) {
        int i = 1;
        while( 2 << i <= n ) i++;
        return i;
    }

    public T query(int i, int j){
        return null;
    }
    
    
    public static void main(String[] args) {
        
        SegmentTree<Integer> st = new SegmentTree<Integer>( new Function<Integer>(){
            @Override
            public Integer f(Integer a, Integer b) {
                return Math.min(a, b);
            }}, Integer.class, 1, 3, 4, 2, 5, 7, 6 );
        
        System.out.println( st.query(2, 5));
    }
}
