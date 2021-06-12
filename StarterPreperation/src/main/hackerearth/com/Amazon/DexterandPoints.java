package com.Amazon;

/***
 * 
 * Dexter and Points
Dexter has you on his kill table now. He gives you one last chance to survive. 
He gives you a problem to solve. If you solve the problem correctly, 
he will let you go, else he will kill you.

You are given N integers a1,a2,,...,aN. Consider an 

N-dimensional hyperspace. Let (x1,x2,...,xN) be a point in this hyperspace and all 
xi for 
i∈[1,N] are integers. Now, Dexter gives you a set which contains all the points such that 

0≤xi≤ai for 
i∈[1,N]. Find the number of ways to select two points 
A and B from this set, such that the midpoint of 

A and B also lies in this set.

As the required number can be really large, find the answer modulo 
10
9
+
7
109+7.

Note: The two selected points can be same.

Input
First line of input contains a single integer 
N, representing the number of dimensions in the hyperspace. The second line contains 
N integers, the 
ith of them representing 
ai, as defined in the problem.

Output
The output contains a single integer, the answer to the problem, modulo 

10^9+7.

Constraints
1≤N≤10^5

0≤a^i≤10^9
Sample Input
2
1 2
Sample Output
10
Explanation
The set contains the points:
{(0,0),(0,1),(0,2),(1,0),(1,1),(1,2)}.

The pairs of points(A,B) whose mid point lies in this set are:
A=(0,0),B=(0,0),Midpoint=(0,0)
A=(0,0),B=(0,2),Midpoint=(0,1)
A=(0,1),B=(0,1),Midpoint=(0,1)
A=(0,2),B=(0,2),Midpoint=(0,2)
A=(0,2),B=(0,0),Midpoint=(0,1)
A=(1,0),B=(1,0),Midpoint=(1,0)
A=(1,0),B=(1,2),Midpoint=(1,1)
A=(1,1),B=(1,1),Midpoint=(1,1)
A=(1,2),B=(1,2),Midpoint=(1,2)
A=(1,2),B=(1,0),Midpoint=(1,1)
 */


import java.util.ArrayList;
import java.util.List;

class point{
	
}

public class DexterandPoints {
	
	public static void main(String[] args) {
		
	}
	
	private List<Integer> getMidPoint(List<Integer> pointA, List<Integer> pointB){
		List<Integer> point = new ArrayList<Integer>();
		int i = 0;
		while (i<pointA.size()) {
			int A = (pointA.get(i)+pointB.get(i))/2;
			point.add(i,A);
		}
		return point;
	}
}


