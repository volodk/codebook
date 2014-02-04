package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:57:14 PM 

public class Graph {
    
    protected final List<Set<Integer>> adjList;
    
    public Graph(int V) {
        adjList = new ArrayList<>(V);
        for( int i = 0; i < V; i++ ){
            adjList.add(new HashSet<Integer>());
        }
    }

    public int V(){
        return adjList.size();
    }
    
    public int E(){
        int E = 0;
        for( int i = 0; i < adjList.size(); i++ ){
            E += adjList.get(i).size();
        }
        return E / 2;
    }
    
    public void addEdge(int from, int to){
        if( from != to ){
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        } 
    }
    
    public void addEdge(Edge e){
        
    }
    
    public void removeEdge(int from, int to){
        adjList.get(from).remove(to);
        adjList.get(to).remove(from);
    }
    
    public boolean hasEdge(int from, int to){
        return adjList.get(from).contains(to);
    }
    
    public Set<Integer> getAdjacent(int v){
        return Collections.unmodifiableSet(adjList.get(v));
    }
    
    public void print(){
        for(int i = 0; i < adjList.size(); i++){
            System.out.format("%d -> %s\n", i, adjList.get(i));
        }
    }
}
