package comb;

import java.util.Arrays;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 6:53:48 PM 

public class Antilex2 {

    public static void main(String[] args) {
        
        int[] p = {1,2,3};
        int m = p.length;
        
        antilex(p, m-1);

    }
    
    static void antilex(int[] p, int m) {
        if(m == 0) {
          System.out.println( Arrays.toString(p) );  
        } else {
            for(int i = 0; i <= m; i++){
                antilex(p, m-1);
                if(i < m){
                   swap(p, i, m);
                   reverse(p, 0, m-1);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int ch = arr[i]; arr[i] = arr[j]; arr[j] = ch;
    }
    
	static void reverse(int[] str, int i, int j){
		for(; i < j; i++, j--){swap(str, i, j);}
	}

}
