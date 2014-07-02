package trees;
import java.lang.reflect.Array;
import java.util.Objects;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:38:23 PM 

public class SegmentTree<T> {

    interface Function<T> { // associative function
        T call(T a, T b);   
    }  
    
    private final Function<T> function;
    private final Class<T> elemClass;
    
    private T[] tree;
    
    public SegmentTree(Class<T> clazz, Function<T> function) {
        this.function = function;
        elemClass = clazz;
    }
    
    @SuppressWarnings("unchecked")
    public void build(T ... values){
        Objects.requireNonNull(values);
        
        int N = values.length;
        tree = (T[]) Array.newInstance(elemClass, N);
        
        int node = 1;
        int i = 0, j = N-1;
        
        build( node, i, j, values, tree );
    }
    
    private void build(int node, int b, int e, T[] values, T[] segments){
        
//        if(b == e)
//            segments[node] = b;
        
        build( node * 2, b, (b + e)/2, values, segments);
        build( node * 2 + 1, (b + e)/2 + 1, e, values, segments);
        
        // calc function over child nodes
        
    }
    
    public T query(int i, int j){
        return null;
    }
    
        
    public static void main(String[] args) {
        
        SegmentTree<Integer> st = new SegmentTree<Integer>( Integer.class, new Function<Integer>() {
            @Override
            public Integer call(Integer a, Integer b) {
                return Math.min(a, b);
            }
        });
        
        st.build( 3,1,4,5,2,6,3,7,4 );
        
        System.out.println( st.query(1,5) );
    }
    
}
