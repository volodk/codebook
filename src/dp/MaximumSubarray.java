package dp;

public class MaximumSubarray {

	public static void main(String[] args) {
		
		int[] arr = {-1, 2, 3, -4, 5,-1, 6};
		
		int max = 0;
		int curr_max = 0;
		
		// Kadane's
		for(int a : arr){
			curr_max = Math.max(0, curr_max + a);
			max = Math.max(curr_max, max);
		}
		
		System.out.println(max);
	}
}
