package trees;

public interface Tree<K extends Comparable<K>> {
    void insert(K key);
    void contains(K key);
    void delete(K key);
}
