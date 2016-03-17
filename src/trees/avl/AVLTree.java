package trees.avl;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:48:23 PM 

public class AVLTree<K extends Comparable<? super K>, V> {

	class Node {
		K key; V value; int ht;
		Node left, right;
		Node(K k, V v){ key = k; value = v; }
		Node(K k, V v, int h, Node l, Node r){ key = k; value = v; ht = h; left = l; right = r;}
	}
	
	private Node root;
	private AVLTree(Node root){ this.root = root; }

	public void insert(K key, V value){
		root = insert(root, key, value);
	}

	public void delete(K key) {
		Node n = find(root, key);
		if (n != null){
			if (n.left == null || n.right == null ) root = delete(root, key);
			else root = delete(root, key, successor(root, key));
		}
	}
	
	public boolean contains(K key){
		return find(root, key) != null;
	}

	public V find(K key) {
		Node n = find(root, key);
		return n == null ? null : n.value;
	}
	
	@SuppressWarnings("unchecked")
	public AVLTree<K,V>[] split(K key){
		Node[] pair = split(root, key);
		return (AVLTree<K,V>[]) new AVLTree[]{ new AVLTree<>(pair[0]), new AVLTree<>(pair[1]) };
	}
	
	private Node[] split(Node n, K key) {
		return null;
	}

	public AVLTree<K,V> merge(AVLTree<K,V> t1, AVLTree<K,V> t2){
		return new AVLTree<K,V>(merge(t1.root, t2.root));
	}
	
	private Node merge(Node t1, Node t2) {
		return null;
	}

	private int bfactor(Node n){
		return height(n.left) - height(n.right);
	}
	
	private Node find(Node n, K key) {
		if (key.compareTo(n.key) < 0) return find(n.left, key);
		if (key.compareTo(n.key) > 0) return find(n.right, key);
		return n;	
	}

	private int height(Node n) {
		return n == null ? 0 : n.ht;
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

	private Node insert(Node n, K key, V value) {
		if (n == null) return new Node(key, value);
		if (key.compareTo(n.key) < 0) {
			n.left = insert(n.left, key, value);
		} else if (key.compareTo(n.key) > 0) {
			n.right = insert(n.right, key, value);
		} else {
			n.value = value;
		}
		n.ht = height(n);
		return balance(n);
	}
	
	private Node successor(Node n, K key){
		
	}
	
	private Node predecessor(Node n, K key){
		
	}

	private Node delete(Node n, K key) {
		if (key.compareTo(n.key) == 0){
			if (n.left == null && n.right == null) return null;
			if (n.left == null) return n.right;
			if (n.right == null) return n.left;
		}
		if (key.compareTo(n.key) < 0) n.left = delete(n.left, key);
		if (key.compareTo(n.key) > 0) n.right = delete(n.right, key);
		return n;
	}
	
	private Node delete(Node n, K key, Node succ) {
		if (key.compareTo(n.key) < 0) n.left = delete(n.left, key, succ);
		if (key.compareTo(n.key) > 0) n.right = delete(n.right, key, succ);
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
