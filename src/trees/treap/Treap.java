package trees.treap;

import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:53:38 PM 

public class Treap<X extends Comparable<X>, Y extends Comparable<Y>> {

	class Node {
		X x; Y y;
		Node left, right;
		Node(X xx, Y yy, Node l, Node r){ x = xx; y = yy; left = l; right = r; }
	}
	
	Node root;
	
	public static <X extends Comparable<X>, Y extends Comparable<Y>> Treap<X,Y> merge(Treap<X,Y> t1, Treap<X,Y> t2){
		if (t1 == null) return t2;
		if (t2 == null) return t1;
		if (t1.root.y.compareTo(t2.root.y) < 0){
			return new Treap<X,Y>(t2.root.x, t2.root.y, t1, merge(t1.root.right, t2.root.right));
		} else {
			return new Treap(l.key, l.priority, merge(l.left, r.left), r);
		}
	}
	
	public static Treap[] split(Treap t, int key){
		if(t.key < key){
			
		} else {
			
		}
	}

}
