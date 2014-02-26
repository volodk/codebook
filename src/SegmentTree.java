
// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:38:23 PM 

public class SegmentTree<T> {

    interface Function<T> {
        T call(T a, T b);  // any associative function like min, max, mul, avg, gcd ... 
    }  
    
    private Function<T> funtion;
    
}
