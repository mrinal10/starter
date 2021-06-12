package com.Amazon;

/**
 * King Arthur’s Kingdom
You are given a tree consisting of N nodes and another integer K, where the 
ith node has value equal to v[i].

Now, we call the value of a sub-tree the number of distinct v[i] among all nodes 
it contains. You need to find the number of sub-trees of this tree having value ≤K .

A sub-tree of a tree is a subset of nodes and edges of the tree that form a single connected component.

Input: :

Input starts with an integer (1≤T≤15) denoting the number of test cases. 
Each case starts with two positive integers N and K.

The next line consists of N space separated integers, where the ith integer denotes 

v[i]. Each of the next N−1 lines contains 2 space separated integers u and v, 
denoting an edge between nodes u and v,

Output:

For each test case, print the answer on a new line.

Constraints:

1≤T≤15

2≤N≤18
1≤K≤N

0≤v[i]≤10^9

1≤u,v≤N
Sample Input
1
5 2
5 12 7 2 10
1 2
1 3
2 4
1 5
Sample Output
Case 1: 9
Explanation
In the sample test case given there are 9 subtrees that have their value less than or equal to 2 and those can be listed as following - 
1.) Subtree with only one node - There are 5 such subtress i.e. all the nodes taken 1 at a time 1,2,3,4,5 
2.) Subtree with only two nodes - There are 4 such subtrees i.e. all the edges taken 1 at a time (1,2) , (1,3) , (1,5) and (2,4) 
Apart from that any subtree will have its value either greater than 2 or the subtree won't be connected

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
Time Limit: 1.0 sec(s) for each input file
 * @author MRINAL
 *
 */

public class KIngARthur {

}
