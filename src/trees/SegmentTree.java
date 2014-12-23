package trees;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:38:23 PM 

/**
 * In computer science, a segment tree is a tree data structure for storing
 * intervals, or segments. It allows querying which of the stored segments
 * contain a given point. It is, in principle, a static structure; that is, its
 * content cannot be modified once the structure is built. A similar data
 * structure is the interval tree. A segment tree for a set I of n intervals
 * uses O(n log n) storage and can be built in O(n log n) time. Segment trees
 * support searching for all the intervals that contain a query point in O(log n
 * + k), k being the number of retrieved intervals or segments.[1] Applications
 * of the segment tree are in the areas of computational geometry, and
 * geographic information systems. The segment tree can be generalized to higher
 * dimension spaces as well.
 */
public class SegmentTree {
    
    static class Interval implements Comparable<Interval>{
        int from, to;
        public Interval(int from, int to) {
            if( from > to ) throw new IllegalArgumentException();
            this.from = from; this.to = to;
        }
        @Override
        public int compareTo(Interval o) {
            return from - o.from;
        }
        @Override
        public String toString() { return String.format("[%d,%d]", from, to); }
    }
    
    // ==============================================================================
    
    class Node{
        int top;
        Interval i;
        Node left, right;
    }
    
    private Node root;
    
    public void add(Interval i){
        if( i != null )
            root = add(root, i);
    }
    
    private Node add(Node n, final Interval intvl){
        if( n == null ){
            Node r = new Node();
            r.i = intvl;
            r.top = intvl.to;
            return r;
        } else {
            if( intvl.compareTo(n.i) < 0 ){ // less than
                n.left = add(n.left, intvl);
                if( n.right != null ){
                    n.top = Math.max( n.left.top, n.right.top);
                } else { 
                    n.top = n.left.top;
                }
            } else {
                n.right = add(n.right, intvl);
                if (n.left != null){
                    n.top = Math.max(n.left.top, n.right.top);
                } else {
                    n.top = n.right.top;
                }
            }
            return n;
        }
    }
    
    public List<Interval> query(int point){
        return null;
    }
        
    public static void main(String[] args) {
        
        SegmentTree st = new SegmentTree();
        
        List<Interval> intervals = Arrays.asList(new Interval(-10, 0), new Interval(2, 6), new Interval(7, 9),
                new Interval(-2, 4), new Interval(3, 8));
        
        Collections.sort(intervals);
        
        for(Interval i : intervals){
            st.add(i);
        }
        
        System.out.println( "Must be 1 selected -> " + st.query(-9) );
        System.out.println( "Must be 1 selected -> " + st.query(1) );
        System.out.println( "Must be 3 selected -> " + st.query(3) );
        System.out.println( "Must be 2 selected -> " + st.query(5) );
        System.out.println( "Must be 0 selected -> " + st.query(10) );
    }
    
}
