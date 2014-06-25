package trees;
// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:51:53 PM 

public class IntervalTree {
    
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
    
    Interval intersectsWith(Interval intvl){
        return null;
    }
    
    void print(Node n){  
        if( n != null ){
            System.out.println(n.top);
            print(n.left);
            print(n.right);
        }
    }
    
    
    // ==============================================================================
    public static void main(String[] args) {
        
        IntervalTree it = new IntervalTree();
        
        IntervalTree.Interval[] its = { Interval.valueOf(-1, 3), Interval.valueOf(1, 6), Interval.valueOf(5, 8),
                Interval.valueOf(7, 10), Interval.valueOf(9, 12), Interval.valueOf(4, 6) };
        
        for( Interval i : its ){
            it.add(i);
        }
                
        it.print( it.root );
        
    }
}
