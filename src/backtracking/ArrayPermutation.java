package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayPermutation {

    public static void main(String[] args) {
        
        Queue<Integer> s = new LinkedList<>();
        for(int i = 1; i <= 6; i++) s.offer(i);
        
        int n = 3;
        int k = 0;
        int[] a = new int[n];
        
        backtrack(s,a,n,k);

    }

    static void backtrack(Queue<Integer> s, int[] a, int n, int k) {
        if(k < n) {
            while(!s.isEmpty()) {
                a[k] = s.poll();
                backtrack(s, a, n, k + 1);
                s.offer(a[k]);
            }
        } else {
            System.out.println(Arrays.toString(a));
        }
    }

}
