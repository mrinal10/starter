package com.hiring.callhealth08122018;

/*
 * 
 * Food Orders
The company X supplies food products in the market. Since the demand is very large, 
they came with an idea of making a large warehouse with a capacity of n items. 
Since food products can't be kept for a long time, they started to expire.
 The dates of expire are such that every day exactly k of the n food items get expired. 
 Company  has vans and each van can deliver  products in a day. How many minimum 
 additional vans should the company X buy so that not more than p products get expire 
 before they get delivered.

Note: Everyday the vans go and deliver the product after that K items expire.

Input

The first line contains  space-separated integers as input: N, K, n, m, p and  respectively.

Output

In the output, you need to print the minimum number of extra vans required.

Constraints
0<= all are <=10^18
Sample Input
10 1 3 1 1
Sample Output
2
Explanation
Let us assume that the company does not buy any van. So, on the first day,  item will 
expire and  gets delivered. On the second day,  more item gets expired and  more gets 
delivered. On the third day, the remaining  items get delivered.

So, out of the  items,  get successfully delivered and  expire. Since expired items 
are greater than , we need to increase the number of vans.

If we add just one more van, you see that  items get delivered on the first day and one item 
gets expired.  items again get delivered and  more item gets expired. Thus out of the  items,  
gets delivered and  gets expired. Still, expired items are more than .

Now, we add  more vans so  items get delivered and  expires on the first day. Now, remaining 
items get delivered. So only item expires.

Note: Your code should be able to convert the sample input into the sample output. However, 
this is not enough to pass the challenge, because the code will be run on multiple test cases. 
Therefore, your code must solve this problem statement.
 * 
 * 
 * */

public class FoodOrders {

}
