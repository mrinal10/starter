package com.lowes;

/**
 * 
 * 
 * 
 * The Circular jump (Lowe)
There are 
N chairs arranged around a circular table. Each chair has a number 
Num i written on it. Any person sitting on a chair 
i can jump 
Num i number of indices towards left or right, You are sitting on chair 
X and you have to reach chair Y. 
Tell the minimum number of jumps required by you. If its impossible to reach then print −1.

Example :- If your sitting on chair 4 and it has number 2 written on it then you 
can either jump to chair number 2 or chair number 6.

Constraints 
1<=T<=100 
1<=N<=10^4
1<=Numi<=10^9
1<=X,Y<=N
Format of the input file:
First line : T i.e number of testcases.
For each testcase :
First line : Three space separated integers N , X and Y.
Second line : N space separated integers denoting the chNum.

Format of the output file:
For each testcase print the answer in a separate line.

Sample Input
1
5 1 5
2 1 2 3 4
Sample Output
2
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CircularJump {
	public static void main(String args[] ) throws Exception {
    
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
        	int N = s.nextInt();
        	int startPoint = s.nextInt();
        	int endPoint = s.nextInt();
        	
        	Map<Integer,Integer> mapM = new HashMap<Integer,Integer>();
        	for (int j = 1; j <= N; j++) {
        		int value = s.nextInt();
        		mapM.put(j, value);
        	}
        	int n1=startPoint;
        	int totalPasses = 0;
        	while (n1 != endPoint) {
        		if (n1<endPoint) {
        			n1 = n1+mapM.get(n1);
				} else {
					n1 = n1-mapM.get(n1);
				}
        		
        		//System.out.println("current Chair : "+n1);
        		totalPasses++;		
        		if (n1>endPoint || n1<startPoint) {
					break;
				}
			}
        	if (n1==endPoint) {
				System.out.println(totalPasses);
			} else {
				System.out.println("-1");
			}
        	
        }
    }
}