import trees.avl.AVLTree;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:51:53 PM 

public class IntervalTree {
    
    static class Interval implements Comparable<Interval>{
        int from, to;
        public Interval(int from, int to) {
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
    
    AVLTree<Interval, Integer> tree = new AVLTree<>();
    
    void add(Interval i){
        tree.insert(i, 0);
    }
    
    Interval intersectsWith(Interval i){
        return null;
    }
    
    void print(){ tree.print(); }
    
    public static void main(String[] args) {
        
        IntervalTree it = new IntervalTree();
        
        IntervalTree.Interval[] its = { Interval.valueOf(-1, 3), Interval.valueOf(1, 6), Interval.valueOf(5, 8),
                Interval.valueOf(7, 10), Interval.valueOf(9, 12), Interval.valueOf(4, 6) };
        
        for( Interval i : its ){
            it.add(i);
        }
        
        it.print();
        
    }
}
