package trees.trie;

import java.util.Set;

public class PrefixTree {

    class Node{
        char ch;
        boolean isTerminate;
        Node[] next = new Node['z'];
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
