package alg.mrq;

// Volodymyr Krasnikov <vkrasnikov@gmail.com> 5:11:30 PM 

public class MinRangeQuery {

	static int mrq(int[] original, int[] prepared, int slice, int from, int to) {

		if (to < from)
			throw new IllegalArgumentException();

		int min = original[from];

		for (int i = from + 1; i <= to;) {
			if (i % slice == 0 && i + slice <= to) {
				min = Math.min(min, prepared[i / slice]);
				i += slice;
			} else {
				min = Math.min(min, original[i]);
				i++;
			}
		}

		return min;
	}

	static int min(int[] arr, int i, int j) {
		if (i < j)
			return Math.min(arr[i], min(arr, i + 1, j));
		return arr[j];
	}

	public static void main(String[] args) {

		int[] arr = { 0, 3, 15, 10, 7, 14, 2, 11, 4, 1, 8, 12, 6, 13, 9, 5, 4, 5, 6, 1, 9 };

		int L = arr.length;

		int sliceLength = (int) Math.ceil(Math.sqrt(L));

		int[] range = new int[sliceLength];

		for (int i = 0; i < sliceLength; i++) {
			int start = i * sliceLength, end = start + sliceLength;
			range[i] = min(arr, start, Math.min(end - 1, arr.length - 1));
		}

		System.out.println(mrq(arr, range, sliceLength, 1, 10));

	}

}
