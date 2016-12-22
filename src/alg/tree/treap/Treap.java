package alg.tree.treap;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 12:53:38 PM 

public class Treap<X extends Comparable<X>, Y extends Comparable<Y>> {

	class Node {
		X x; Y y;
		Node left, right;
		Node(X a, Y b, Node l, Node r){ x = a; y = b; left = l; right = r; }
	}
	
	private Node root;
	private Treap(Node root){ this.root = root; }
	
	public Treap<X,Y> merge(Treap<X,Y> t){
		return new Treap<X,Y>( merge(root, t.root) );
	}
	
	private Node merge(Node t1, Node t2){
		if (t1 == null) return t2;
		if (t2 == null) return t1;
		if (t1.y.compareTo(t2.y) < 0){
			return new Node(t2.x, t2.y, merge(t1, t2.left), t2.right);
		} else {
			return new Node(t1.x, t1.y, t1.left, merge(t1.right, t2));
		}
	}
	
	@SuppressWarnings("unchecked")
	public Treap<X,Y>[] split(X x){
		Node[] pair = split(root, x);
		Treap<X, Y> left = new Treap<>(pair[0]);
		Treap<X, Y> right = new Treap<>(pair[1]);
		return (Treap<X,Y>[]) new Treap[]{left, right};
	}

	private Node[] split(Node n, X x) {
		if ( n.x.compareTo(x) < 0 ){
			
		} else {
			
		}
		return null;
	}

}
