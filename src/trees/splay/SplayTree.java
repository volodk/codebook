package trees.splay;

// Volodymyr_Krasnikov <vkrasnikov@gmail.com> 6:48:13 PM 

public class SplayTree<K extends Comparable<K>, V> {
	
	class Node {
		K key;
		V value;
		Node left, right;
		Node(K k, V v){ key = k; value = v; }
	}
	
	private Node root;
	private SplayTree(Node root){ this.root = root;}
	
	public void insert(K key, V value) {
		root = insert(root, new Node(key, value));
	}
	
	public void delete(K key) {
		if (contains(root, key)) {
			root = splay(root, predecessor(root, key));
			root = delete(root, key);
		}
	}
	
	public boolean contains(K key){
		if (contains(root, key)) {
			root = splay(root, key);
			return true;
		} else {
			root = splay(root, successor(root, key));
			return false;
		}
	}
	
	public V get(K key) {
		if (contains(root, key)){
			root = splay(root, key);
			return root.value;
		}
		return null;
	}
	
	public int size() { return size(root); }
	
	public SplayTree<K,V> merge(SplayTree<K,V> t){
		return new SplayTree<K,V>(merge(root, t.root));
	}
	
	@SuppressWarnings("unchecked")
	public  SplayTree<K,V>[] split(K key){
		Node[] pair = split(root, key);
		return (SplayTree<K,V>[]) new SplayTree[]{new SplayTree<>(pair[0]), new SplayTree<>(pair[1])};
	}
	
	private Node merge(Node t1, Node t2){
		
	}
	
	private Node[] split(Node n, K key){
		
	}
	
	private Node splay(Node n, K key){
		
	}
	
	private Node delete(Node n, K key){
		
	}
	
	private int size(Node n) {
		if (n == null) return 0;
		return 1 + size(n.left) + size(n.right);
	}

	private boolean contains(Node n, K key){
		if(n == null) return false;
		if( key.compareTo(n.key) < 0) return contains(n.left, key);
		if( key.compareTo(n.key) > 0) return contains(n.right, key);
		return true;
	}
	
	private Node insert(Node n, Node k){
		
	}

	private Node min(Node n) {
		while(n.left != null) n = n.left;
		return n;
	}

	private Node max(Node n) {
		while(n.right != null) n = n.right;
		return n;
	}
	
	private K successor(Node n, K key){
		
	}
	
	private K predecessor(Node n, K key){
		
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
