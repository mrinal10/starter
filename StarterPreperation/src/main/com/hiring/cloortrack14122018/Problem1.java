package com.hiring.cloortrack14122018;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Largest Subsequence
There are  students in the class. Each student has his own intelligence level denoted by 
the number  for the  student. Now class teacher wants to choose a maximum number of students 
from the class such that if she arranges the chosen students according to their intelligence 
levels, the maximum difference of intelligence level between adjacent students is at most 1. 
You need to find the maximum number of students that can be chosen.

Input

The first line of input contains an integer  that denotes the total number of test cases.
For each test case, the first line contains an integer  that denotes the number of students 
in the class and the second line contains  space separated integers denoting the intelligence 
level of each student.

Output

For every test case, output the maximum number of students that can be chosen.

Constraints




Sample Input
2
5
9 2 1 9 1
4
3 2 4 1
Sample Output
3
4

Explanation
For the first test case, two possible sorted subsequences are  and .

For the second test case, possible sorted subsequence is .

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the 
challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.

Time Limit: 1.0 sec(s) for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes
Allowed Languages: Python, Python 3
New Submission
 */


public class Problem1 {
	private static int[] hlpr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) 
				ar[j] = sc.nextInt();
			Arrays.sort(ar);
			System.out.println(longestLISLength(ar));
		}	
		sc.close();
	}

	private static int longestLISLength(int arr[]) {
		hlpr = new int[arr.length];
		for(int i=1; i<arr.length; i++){
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]){
					hlpr[i] = Math.max(hlpr[i], hlpr[j]+1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max<hlpr[i]) {
				max = hlpr[i];
			}
		}
		return max+1;
	}
}
