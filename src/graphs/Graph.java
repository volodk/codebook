package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 2:57:14 PM 

public class Graph {
    
    private int V;
    
    protected final List<Set<Integer>> adjList;
    
    public Graph(int v) {
        V = v;
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
    
    public void addEdge(int v1, int v2){
        if( v1 != v2 ){
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        } 
    }
    
    public void removeEdge(int v1, int v2){
        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
    }
    
    public boolean isEdge(int from, int to){
        return adjList.get(from).contains(to);
    }
    
    public Set<Integer> getAdjacent(int v){
        return Collections.unmodifiableSet(adjList.get(v));
    }
    
    public void print(){
        for(int i = 0; i < V; i++){
            System.out.format("%d -> %s\n", i, adjList.get(i));
        }
    }
}
