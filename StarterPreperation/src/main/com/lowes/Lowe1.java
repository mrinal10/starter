package com.lowes;

/*****
 * 
 * 
 * Monk is given a tree rooted at node 
1.The tree has N nodes and N−1 edges. Each edge has some strength 
associated with it. The strength of an edge is determined by the number of pair 
of nodes which are connected with the help of that particular edge.

Alternatively consider all the paths between every pair of nodes and the strength of an edge will be equal to the number of paths in which that edge comes.

Monk wants to know the strength of each edge of the tree.

Note: Node pair (i,j) is same as node pair (j,i).

Input Format
First line consists of an integer 
N denoting the number of nodes in the tree. Then there are
2 integers N-1 and Then N−1 lines follow. Each line consists of two integers 
x and y denoting there is an edge between vertex 
x and vertex y.

Output Format

Output strength of each edge in a separate line. The order of edges in the output should be the same as that in the input.

Constraints

1≤N≤105
1≤x,y≤N;x!=y
Sample Input
6
5 2
1 2
2 3
2 4
1 5
5 6
Sample Output
9
5
5
8
5
Explanation
In the 
1st case if we remove the 4th edge (1-5) then the node pairs which are not connected 
are (5,1),(5,2),(5,3),(5,4),(6,1),(6,2),(6,3),(6,4). Hence there are 8 pairs.

Note: Your code should be able to convert the sample input into the sample output. 
However, this is not enough to pass the challenge, because the code will be run on 
multiple test cases. Therefore, your code must solve this problem statement.
 * 
 * 
 */


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lowe1 {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int M = sc.nextInt();
		 int M1 = sc.nextInt();
         Map<Integer,Integer> mapM = new HashMap<Integer,Integer>();
         Map<Integer,Integer> revMapM = new HashMap<Integer,Integer>();
         for(int i_tree=0; i_tree<M; i_tree++)
         {
         	int N1 = sc.nextInt();
         	int N2 = sc.nextInt();
         	
         	mapM.put(N1, N2);
         	revMapM.put(N2, N1);
         }
         
         for (int i = 0; i < N; i++) {
        	 for (int j = 0; j < N; j++) {
        		 int start = i;
        		 int end = j;
        		 
        		 
     		 }
		 }
    }
}
