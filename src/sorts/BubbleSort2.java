package sorts;

import java.util.Arrays;

public class BubbleSort2 {

	public static void main(String[] args) {
	    
	    int[] arr = { 4, 3, 5, 2, 1, 6, 0, 9 };
	    
	    int n = arr.length;
	    
	    do{
	        for( int j = 1; j < n; j++ ){
	            if(arr[j-1] > arr[j])
	                swap( arr, j-1, j );
	        }
	    } while(--n > 0);
	    
	    
	    System.out.println(Arrays.toString(arr));

	}

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }

}
