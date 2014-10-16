package trees;
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
            if( to < from ) throw new IllegalArgumentException();
            this.from = from;
            this.to = to;
        }
        @Override
        public int compareTo(Interval o) {
            return from - o.from;
        }
        @Override
        public String toString() { return String.format("%d:%d", from, to); }
        public static Interval valueOf(int from, int to){ return new Interval(from, to);}
    }
    
    static boolean lt(Interval i1, Interval i2){ return i1.compareTo(i2) < 0; }
    static boolean le(Interval i1, Interval i2){ return i1.compareTo(i2) <= 0; }
    static boolean ge(Interval i1, Interval i2){ return i1.compareTo(i2) >= 0; }
    static boolean gt(Interval i1, Interval i2){ return i1.compareTo(i2) > 0; }
    static boolean eq(Interval i1, Interval i2){ return i1.compareTo(i2) == 0; }
    
    // ==============================================================================
    
    class Node{
        int top;
        Interval i;
        Node left, right;
    }
    
    Node root;
    
    void add(Interval intvl){
        root = add(intvl, root);
    }
    
    Node add(Interval intvl, Node n){
        if( n == null ){
            Node r = new Node();
            r.i = intvl;
            r.top = intvl.to;
            return r;
        } else {
            if( lt(intvl, n.i) ){
                n.left = add(intvl, n.left);
                n.top = Math.max( n.left.top, n.right == null ? n.left.top : n.right.top);
            } else {
                n.right = add(intvl, n.right);
                n.top = Math.max( n.left == null ? n.right.top : n.left.top, n.right.top);
            }
            return n;
        }
    }
    
    List<Interval> query(int point){
        return null;
    }
        
    public static void main(String[] args) {
        
        SegmentTree st = new SegmentTree();
        
        System.out.println( st.query(5) );
    }
    
}

//
//build( node * 2, b, (b + e)/2, values, segments);
//build( node * 2 + 1, (b + e)/2 + 1, e, values, segments);
