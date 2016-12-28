package ds.tree.avl;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 6:48:23 PM 

public class AVLTree<K extends Comparable<? super K>, V> {

	class Node {
		int ht;
		K key; V value; 
		Node left, right;
		Node(K k, V v){ key = k; value = v; }
		Node(K k, V v, Node l, Node r){ key = k; value = v; left = l; right = r;}
	}
	
	private Node root;
	
	private AVLTree(Node root){ this.root = root; }

	public void put(K key, V value){
		root = put(root, key, value);
	}
	
	private Node put(Node n, K key, V value) {
		if (n == null) return new Node(key, value);
		if (key.compareTo(n.key) < 0) {
			n.left = put(n.left, key, value);
		} else if (key.compareTo(n.key) > 0) {
			n.right = put(n.right, key, value);
		} else {
			n.value = value;
		}
		n.ht = updateHeight(n);
		return balance(n);
	}

	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node delete(Node n, K key) {
		if (n == null) return null;
		else if (key.compareTo(n.key) < 0) n.left = delete(n.left, key);
		else if (key.compareTo(n.key) > 0) n.right = delete(n.right, key);
		else if (key.compareTo(n.key) == 0) {
			if (n.left == null) return n.right;
			else if (n.right == null) return n.left;
			else {
				Node succ = successor(n);
				n.key = succ.key; n.value = succ.value;
				delete(n.right, succ.key);
			}
		}
		n.ht = updateHeight(n);
		return balance(n);
	}
	
	public boolean contains(K key){
		return get(root, key) != null;
	}

	public V get(K key) {
		Node n = get(root, key);
		return n == null ? null : n.value;
	}
	
	private int bfactor(Node n){
		return height(n.left) - height(n.right);
	}
	
	private Node get(Node n, K key) {
		if (n == null) return null;
		if (key.compareTo(n.key) < 0) return get(n.left, key);
		if (key.compareTo(n.key) > 0) return get(n.right, key);
		return n;	
	}
	
	private int height(Node n) {
		return n == null ? 0 : n.ht;
	}

	private int updateHeight(Node n) {
		return 1 + Math.max(height(n.left), height(n.right));
	}

	private Node balance(Node n) {
		int bf = bfactor(n);
		if ( -1 <= bf && bf <= 1) return n;
		if ( bf < -1) {
			if (bfactor(n.right) > 0){
				n.right = rotateRight(n.right);
			}
			return rotateLeft(n);
		} else {
			if (bfactor(n.left) < 0){
				n.left = rotateLeft(n.left);
			}
			return rotateRight(n);
		}
	}
	
	private Node successor(Node n){
		if (n == null || n.right == null) return null;
		n = n.right; while (n.left != null) n = n.left;
		return n;
	}
	
	private Node rotateLeft(Node n) {
		if (n.right == null) return n;
		Node r = n.right;
		n.right = r.left;
		r.left = n;
		return r;
	}

	private Node rotateRight(Node n) {
		if (n.left == null) return n;
		Node r = n.left;
		n.left = r.right;
		r.right = n;
		return r;
	}
}
