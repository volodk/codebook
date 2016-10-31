package sorts;

import java.util.ArrayList;
import java.util.List;

import heaps.Heaps;
import heaps.Heaps.Heap;

public class HeapSort {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };

		Heap<Integer> h = Heaps.newMinHeap();

		for (int a : arr) {
			h.push(a);
		}

		List<Integer> ans = new ArrayList<>();
		while (h.size() > 0) {
			ans.add(h.pop());
		}

		System.out.println(ans);

	}

}
