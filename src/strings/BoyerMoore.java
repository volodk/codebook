package strings;

public class BoyerMoore {

	public static void main(String[] args) {
		
		String p = "needle";
		String s = "findaneedleinahaystack";
		
		int i = indexOf(p, s);
		
		System.out.println(i);
	}

	static int indexOf(String p, String s) {
		return -1;
	}

}
