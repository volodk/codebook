package kth;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static java.util.Random rnd = new java.util.Random();

    public static void main(String[] args) {
 
    	Scanner sc = new Scanner(Solution.class.getResourceAsStream("input03.txt"));
        try{
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for(int i = 0; i<n; i++) { arr[i] = sc.nextInt(); }
            
            int[] copy = arr.clone();
            Arrays.sort(copy);
            System.out.println(copy[n/2]);
            
            int median = kth(arr, 0, n, n/2);
            System.out.println(median);
        } finally {
            sc.close();
        }
    }
    
    static int kth(int[] arr, int l, int r, int k){
        while( l < r){
            int p = partition(arr, l, r);
            if ( p < k ){
                l = p + 1;
            } else if ( p > k ){
                r = p;
            } else 
                return arr[p];
        }
        return arr[l];
    }
    
    static int partition(int[] arr, int l, int r)
    {
    	int pIndex = l + nextInt(l, r);
        int pivot = arr[pIndex];
		swap(arr, l, pIndex);
        int i = l + 1, j = r - 1;
        while( i < j){
            while(i < r && arr[i] < pivot) i++;
            while(j > l && arr[j] >= pivot) j--;
            if( i < j ){
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

	private static int nextInt(int l, int r) {
		if( r - l == 0) return 0;
		return rnd.nextInt(r-l);
	}
    
    static void swap(int[] arr, int i, int j)
    { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
}