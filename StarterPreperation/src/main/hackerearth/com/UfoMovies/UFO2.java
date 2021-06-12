package com.UfoMovies;
/**
 * 
 * 
 * @author MRINAL
 *
 *Killjee and cities
 * 
Killjee lives in Codaland. Codaland has n cities and m bidirectional roads connecting these cities, 
but not all cities are connected. Now the President of Codaland has passed an order to build q new 
roads one by one connecting two different cities. Killjee wonders how many new roads are needed to 
connect all the cities of Codaland after construction of each road as per President's plan.

Note:- There can be multiple number of roads between two same cities.

INPUT FORMAT

First line of input contain a single integer n, denoting number of cities.

Second line of input contains a single integer m, denoting number of current roads in Codaland.

Third line of input contains a single integer s, where s=2. m lines follow each having two space 
separated integers a,b, denoting a road between city a and b.

Next line contains a single integer q, number of new roads to be built.
Next line of input contains a single integer s, where s=2. q lines follow each having two space 
separated integers a,b, denoting a road between city a and b.

OUTPUT FORMAT

Output 

q space separated integers, 
ith of which denotes number of roads needed to connect all the cities of Codaland after creation of first 
i roads.

INPUT CONSTRAINTS

1≤n,q≤106

0≤m≤106

1≤a,b≤n;a!=b

All the roads in input are valid.

Sample Input
5
0
2
3
2
2 1
2 1
4 3

Sample Output
3 3 2

Explanation

After addition of first road between 1 and 2, we need to connect city 3,4 and 5 with (1,2) so, we need 3 more roads for that.
After addition of second road, the answer remains the same as cities 1 and 2 were already connected.
After addition of third road, we have cities 1 and 2 connected with each other, and cities 
4 and 3 connected to each other. So, in order to connect all cities we need 2 more roads to connect 
5 to (1,2) and (3,4).

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 */

public class UFO2 {

}
