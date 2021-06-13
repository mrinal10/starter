package com.java8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Amazon {

    /*
     * Complete the 'connectedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY edges
     */
    static Set<String> allNodesSet;
    static Set<String> allTraversedNode;
    public static int connectedSum(int n, List<String> edges) {
        int sum = 0;
        allNodesSet = new HashSet();
        allTraversedNode = new HashSet();
        Map<String, List<String>> graph = new HashMap();
        for(String s: edges) {
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];
            allNodesSet.add(to);
            allNodesSet.add(from);
            List<String> l1 = new ArrayList();
            if(graph.containsKey(from)){
               l1 = graph.get(from); 
            }
            l1.add(to);
            graph.put(from, l1);
            List<String> l2 = new ArrayList();
            if(graph.containsKey(to)){
               l2 = graph.get(to); 
            }
            l2.add(from);
            graph.put(to, l2);
        }
        List<String> li;
        
        
        boolean[] visited = new boolean[n];
        for(int i=0; i<n-1 ; i++){
            if(!visited[i+1]){                
                li = new ArrayList();
                traversal(graph, String.valueOf(i+1), li, visited);
                int size = li.size();
                sum += Math.ceil(Math.sqrt(size));
            }
        }        
        return sum;
    }
    
    static void traversal(Map<String, List<String>> graph, String node,
         List<String> ct, boolean[] visited){
        visited[Integer.parseInt(node)-1] = true;
        ct.add(node);
        System.out.println(">>"+node);
        if(graph.containsKey(node)) {
	        for(String s:graph.get(node)){
	            if(!visited[Integer.parseInt(s)-1]){
	                traversal(graph, s, ct, visited);
	            }
	        }
        }
    }

    public static void main(String[] args) throws IOException {
      

        List<String> edges = new ArrayList<>();
        edges.add("1 2");
        edges.add("1 3");
        edges.add("2 4");
        edges.add("3 5");
        edges.add("7 8");

        int result = connectedSum(10, edges);

       System.out.println(result);
    }
}
