package maps;

import java.util.Arrays;

public class Hashtable<K, V> {

	static class Entry {
		Object key, value;
		Entry next;

		public Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private static final int DEFAULT_SIZE = 16;
	private static final float LOAD_FACTOR = 0.75f;

	private Entry[] table = new Entry[DEFAULT_SIZE];

	private int size;

	public Hashtable() {

	}

	public V get(K key) {
		int idx = indexOf(key, table.length);
		for (Entry e = table[idx]; e != null; e = e.next) {
			if (e.key.equals(key)) {
				return (V) e.value;
			}
		}
		return null;
	}

	public boolean contains(K key) {
		return get(key) != null;
	}

	public V put(K key, V value) {

		if (loadFactor() >= LOAD_FACTOR) {
			resize();
		}

		int idx = indexOf(key, table.length);

		table[idx] = new Entry(key, value, table[idx]);
		size++;

		Object oldValue = null;

		for (Entry e = table[idx]; e != null && oldValue == null; e = e.next) {
			Entry next = e.next;
			if (next != null && next.key.equals(key)) {
				oldValue = next.value;
				e.next = next.next;
				size--;
			}
		}

		return (V) oldValue;
	}

	public void remove(K key) {
		int idx = indexOf(key, table.length);

		Entry e = table[idx];
		if (e.key.equals(key)) {
			table[idx] = e.next;
			size--;
		} else {
			for (; e != null; e = e.next) {
				Entry next = e.next;
				if (next.key.equals(key)) {
					e.next = next.next;
					size--;
				}
			}
		}
	}

	public int size() {
		return size;
	}

	private int indexOf(K key, int M) {
		return (key.hashCode() & 0x7FFFFFFF) % M;
	}

	private void resize() {
		Entry[] newTable = new Entry[table.length * 2];
		for (Entry e : table) {
			if (e != null) {
				for (; e.next != null; e = e.next) {
					put((K) e.key, (V) e.value);
				}
			}
		}
		table = newTable;
	}

	private float loadFactor() {
		return size() / table.length;
	}

	public void clear() {
		Arrays.fill(table, null);
		size = 0;
	}

}
