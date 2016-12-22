package alg.tree.splay;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 6:48:13 PM 

public class SplayTree<K extends Comparable<K>, V> {
	
	class Node {
		K key;
		V value;
		Node left, right;
		Node(K k, V v){ key = k; value = v; }
	}
	
	private Node root;
	
	private SplayTree(Node root){ this.root = root; }
	
	public V get(K key){
		root = splay(root, key);
		return key.compareTo(root.key) == 0 ? root.value : null;
	}
	
	public boolean contains(K key){
		root = splay(root, key);
		return key.compareTo(root.key) == 0;
	}
	
	private Node splay(Node n, K key){
		if (n == null) return null;
		if (key.compareTo(n.key) < 0) {
			if (n.left != null) n.left = splay(n.left, key);
			return rotateRight(n);
		} else if (key.compareTo(n.key) > 0){
			if (n.right != null) n.right = splay(n.right, key);
			return rotateLeft(n);
		} else {
			return n;
		}
	}

	public void insert(K key, V value){
		root = insert(root, key, value);
	}
	
	private Node insert(Node n, K key, V value) {
		if (n == null) return new Node(key, value);
		if (key.compareTo(n.key) < 0){
			n.left = insert(n.left, key, value);
			return rotateRight(n);
		} else if (key.compareTo(n.key) > 0) {
			n.right = insert(n.right, key, value);
			return rotateLeft(n);
		} else {
			n.value = value;
			return n;
		}
	}
	
	public void delete(K key){
		root = delete(root, key);
	}
	
	private Node delete(Node n, K key){
		if (n == null) return null;
		if (key.compareTo(n.key) < 0) { 
			if (n.left != null) n.left = delete(n.left, key);
			return rotateRight(n);
		} else if (key.compareTo(n.key) > 0) {
			if (n.right != null) n.right = delete(n.right, key);
			return rotateLeft(n);
		} else {
			if (n.left == null) return n.right;
			else if (n.right == null) return n.left;
			else {
				Node succ = successor(n);
				n.key = succ.key; n.value = succ.value;
				n.right = delete(n.right, succ.key);
			}
			return n;
		}
	}
	
	private Node successor(Node n){
		if (n == null || n.right == null) return null;
		n = n.right; while (n.left != null) n = n.left;
		return n;
	}
	
	@SuppressWarnings("unchecked")
	public SplayTree<K, V>[] split(K key){
		root = splay(root, key);
		SplayTree<K, V> left = new SplayTree<>(root.left);
		SplayTree<K, V> right = new SplayTree<>(root.right);
		root = null;
		return (SplayTree<K,V>[]) new SplayTree[]{left, right};
	}
	
	public void join(SplayTree<K,V> t){
		root = max(root);
		root.right = t.root;
	}

	public V max(){
		return root == null ? null : (root = max(root)).value; 
	}
	
	private Node max(Node n){
		if (n.right != null){
			n.right = max(n.right);
			return rotateLeft(n);
		}
		return n;
	}
	
	public V min(){
		return root == null ? null : (root = min(root)).value;
	}
	
	private Node min(Node n){
		if (n.left != null){
			n.left = max(n.left);
			return rotateRight(n);
		}
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
