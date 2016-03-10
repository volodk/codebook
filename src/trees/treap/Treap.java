package trees.treap;

import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 12:53:38 PM 

public class Treap {

	private int key;
	private float priority;
	private Treap left, right;
	
	public Treap(){}
	public Treap(int key, float priority){
		this(key, priority, null, null);
	}
	public Treap(int key, float priority, Treap left, Treap right){
		this.key = key;
		this.priority = priority;
		this.left = left;
		this.right = right;
	}
	
	public static Treap merge(Treap l, Treap r){
		if (l == null) return r;
		if (r == null) return l;
		if (l.priority < r.priority){
			return new Treap(r.key, r.priority, l, merge(l.right, r.right));
		} else {
			return new Treap(l.key, l.priority, merge(l.left, r.left), r);
		}
	}
	
	public static Treap[] split(Treap t, int key){
		if(t.key < key){
			
		} else {
			
		}
	}

	

	public static void main(String[] args) {
		Treap t = new Treap();

	}

}
