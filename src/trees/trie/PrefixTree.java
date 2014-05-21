package trees.trie;

import java.util.Set;

public class PrefixTree {
	
	private static final int ALPHABET_SIZE = 'z' - 'A' + 1;

    class Node {
        char[] text;
        boolean terminal;
        Node[] next = new Node[ ALPHABET_SIZE] ;
    }
    
    Node root = new Node();
    
    public void insert(char[] word){
        
    }
    
    public void remove(char[] word){
        
    }
    
    public boolean contains(char[] word){
        return true;
    }
    
    public Set<char[]> startsWith(char[] prefix){
        return null;
    }
    
    public int wordCount(){
        return 0;
    }
    
}
