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
        public static Interval valueOf(int from, int to){ return new Interval(from, to);}
    }
    
    AVLTree<Interval, Integer> tree = new AVLTree<>();
    
    void add(Interval i){
    }
    
    Interval intersectsWith(Interval i){
        return null;
    }
}
