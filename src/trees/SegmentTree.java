package trees;
import java.util.Objects;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:38:23 PM 

public class SegmentTree<T> {

    interface Function<T> {
        T call(T a, T b);  // any associative function like min, max, mul, avg, gcd ... 
    }  
    
    private final Function<T> function;
    
    private int[] segments;
    
    public SegmentTree(Function<T> function) {
        this.function = function;
    }
    
    public void build(T ... values){
        Objects.requireNonNull(values);
        int N = values.length;
        segments = new int[ N + 1];
        int node = 1;
        int i = 0, j = N-1;
        
        build( node, i, j, values, segments );
    }
    
    private void build(int node, int b, int e, T[] values, int[] segments){
        
        if(b == e)
            segments[node] = b;
        
        build( node * 2, b, (b + e)/2, values, segments);
        build( node * 2 + 1, (b + e)/2 + 1, e, values, segments);
        
        // calc function over child nodes
        
    }
    
    public T query(int i, int j){
        return null;
    }
    
        
    public static void main(String[] args) {
        
        SegmentTree<Integer> st = new SegmentTree<Integer>(new Function<Integer>() {
            @Override
            public Integer call(Integer a, Integer b) {
                return Math.min(a, b);
            }
        });
        
        st.build( 3,1,4,5,2,6,3,7,4 );
        
        System.out.println( st.query(1,5) );
    }
    
}
