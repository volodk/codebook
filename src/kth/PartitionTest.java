package kth;

import java.util.Arrays;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:18:47 PM 

public class PartitionTest {

	public static void main(String[] args) {
		
		int[] arr = {0, 3, 6, 10, 14, 19, 16};
		
		int elem = KthOrder.random_partition(arr, 0, arr.length);
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(elem);

	}

}
