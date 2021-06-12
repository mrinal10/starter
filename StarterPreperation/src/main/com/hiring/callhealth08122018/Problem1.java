package com.hiring.callhealth08122018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * 
Max. Marks 100.00
Gift Vouchers
Company X, an air transport service provider decided to give gift vouchers to the passengers
 this festive season. But they cannot give the gift vouchers to everyone in the flight. So, 
they decided to give the vouchers to every K-th passenger in each of their flights.

Every passenger who is travelling has a unique Id. Now, the manager asked you to tell them how 
many gift vouchers will be required in total and who all will be getting the gift vouchers.
Neither you are provided with the exact data that how many flights will be there nor the Id's 
of the passengers that belong to a particular flight. Instead you are given M connections 
represented by two passenger Id's x and y that denote x and y belong to the same flight.

Now, every K-th passenger from each flight will get the gift voucher after ordering them in the 
increasing order of their Id's.

Input Format

The first line of the input contains three space-separated integers N, M, and K, the total number of passengers, 
the total number of connections and the number K as described in the above statement.
Then M lines follow, each line contains two space-separated integers x and y denoting that x and y belong 
to the same flight.

Output Format

In the first line of the output print the total number of passengers getting the gift vouchers.
In the next line of the output print space-separated Id's of the passengers getting the gift 
vouchers in the increasing order.

Constraints

1≤N≤105
1≤M≤min(106,N∗(N−1))
1≤K,x,y≤N

Sample Input
6 3 2
1 4
5 4
3 6
Sample Output
2
4 6
Explanation
[1,4,5] belong to the same flight, passenger with Id 4 will get the voucher. [3,6] belong 
to the same flight, passenger with Id 6 will get the voucher. [2] belong to the same flight, 
no one will get the gift voucher as there is only 1 passenger.

Note: Your code should be able to convert the sample input into the sample output. However, 
this is not enough to pass the challenge, because the code will be run on multiple test cases. 
Therefore, your code must solve this problem statement.

 * */
public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfPassesegers = sc.nextInt();
		int noOfConnections = sc.nextInt();
		int passengerIndx = sc.nextInt();
		
		List<Set<Integer>> setList = new ArrayList<>();
		for (int i = 0; i < noOfConnections; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			boolean flag = false;
			if (!setList.isEmpty()) {
				for (int j = 0; j < setList.size(); j++) {
					Set<Integer> ntrySet = setList.get(j);
					if (ntrySet.contains(to)){ 
						ntrySet.add(from);
						flag = true;
						break;
					}else if(ntrySet.contains(from)) {
						ntrySet.add(to);
						flag = true;
						break;
					}
				}
				if (!flag) {
					Set<Integer> ntrySet = new HashSet<>();
					ntrySet.add(from);
					ntrySet.add(to);
					setList.add(ntrySet);
				}
			}else{
				Set<Integer> ntrySet = new HashSet<>();
				ntrySet.add(from);
				ntrySet.add(to);
				setList.add(ntrySet);
			}
		}
		
		List<Integer> listt = new ArrayList<>();
		for (Iterator<Set<Integer>> iterator = setList.iterator(); iterator.hasNext();) {
			Set<Integer> curSet = iterator.next();
			List<Integer> ll = new ArrayList<>();
			for (int value : curSet) {
				ll.add(value);
			}
			Collections.sort(ll);
			int itCnt = 1;
			for (int i = 0; i < ll.size(); i++) {
				if (itCnt == passengerIndx) {
					listt.add(ll.get(i));
					itCnt = 0; 
				}
				itCnt++;
			}
		}
		System.out.println(listt.size());
		for (int i = 0; i < listt.size(); i++) {
			System.out.print(listt.get(i)+" ");
		}
		sc.close();
	}

}
