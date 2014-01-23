package kth;

import java.util.Arrays;
import java.util.Random;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 4:42:58 PM 

public class KthOrder {
	
	static Random rnd = new Random();

	public static void main(String[] args) {
		
		int N = 20;
		int [] arr = new int[N];
		
		for(int i = 0; i<N; i++){
			arr[i] = rnd.nextInt(N);
		}
		
		System.out.println( Arrays.toString(arr) );
		
		int[] copy = arr.clone();
		Arrays.sort(copy);
		
		System.out.println( Arrays.toString(copy) );
		
		int k = 5;
		int elem = kth(arr, k);
		
		System.out.println( elem );

	}

	static int kth( int[] arr, int k ) {
		return kth(arr, 0, arr.length, k);
	}
	
	static int kth( int[] arr, int l, int r, int k ) {
		int p_index = random_partition(arr, l, r);
		if(k < p_index){
			return kth(arr, l, p_index, k);
		} else if (k > p_index){
			return kth(arr, p_index + 1, r, k - p_index);
		} else{
			return arr[p_index];
		}
	}

	static int random_partition(int[] arr, int l, int r) {
		int p_index = l + rnd.nextInt( r-l + 1);
		
		int pivot = arr[p_index];
		swap(arr, l, p_index);
		
		int i = l+1, j = r-1;
		
		while( i < j ){
			while( i < j && arr[i] < pivot )i++;
			while( j > i && arr[j] >= pivot )j--;
			if(i < j){ swap(arr, i++, j--);	}
		}
		
		swap(arr, l, i-1);
		
		return i-1;
	}
	
	static void swap(int[] arr, int i, int j)
	{
		int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	}

}
