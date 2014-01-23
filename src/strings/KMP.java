package strings;

public class KMP {

	public static void main(String[] args) {
			    
	    String s = "abcba";
	    String p = "cb";
	    
	    int offset = indexOf(s, p);
	    
	    System.out.println(offset);

	}

    private static int indexOf(String str, String pat) {
        
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        
        int[] f = skip(p);
        
        for(int i = 0; i < s.length - p.length + 1; ){
            
            int j = 0;
            for(; j < p.length; j++){
                if( s[i+j] != p[j]){
                    break;
                }
            }
            if(j == p.length){
                return i;
            } else {
                i += Math.max(1, f[j]);
            }
        }
                
        return -1;
    }

    private static int[] skip(char[] p) {
        int[] f = new int[p.length];
        f[0] = 0;
        
        
        return f;
    }

}
