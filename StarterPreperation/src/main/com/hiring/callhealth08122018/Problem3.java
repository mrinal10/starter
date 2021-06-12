package com.hiring.callhealth08122018;


/**
 
Question
3
Max. Marks 100.00
Online Shopping
Company X an E-commerce website kept decent discounts on all of their products on their initial launch 
due to which there was a heavy traffic and their website crashed after some time as a result of which 
they were not able to generate the bills. Fortunately, there is an excel sheet which has the history of all 
the purchases by the customers.

The manager of the company asked you to help them out and generate the bills for every customer. 
Since generating the bills manually for every customer would be a very tedious task you decided to 
write a program which will generate the bills for you.

The excel sheet has the data this way:

Customer ID	Product Type	Quantity	Price (1 Quantity)	Discount Coupon
1	         clothes	        1	         600.00				Yes
3			electronics			2			5000.00				 No
1			groceries			1			 100.00				Yes
2			 clothes			2			 500.00				 No
 
Customer ID: This is the unique ID generated for each customer and the bills must be calculated for each 
of these values.
Product Type: This indicates the type of the product i.e clothes (t-shirt, jeans, etc.) and for each 
product type there is some discount % associated.
Quantity: The total amount of goods demanded.
Price (1 Quantity): Price of the single quantity of that product.
Discount Coupon: It specifies if the customer has a discount coupon and only 1 can be used for the billing.

Apart from this excel sheet, you have also been provided with the discount % of every available product 
type and the discount coupon prize.

Now, you have to generate the bills and provide them in such a way that the customers with the higher 
bills should receive the billing receipt first as the company doesn't want them to be unsatisfied for 
waiting too long.

Note: If two customers have the same bill then the customer having the greater ID will receive the bill first.

Input Format

The first line of the input contains an integer N, the total number of product types available.
Then N lines follow, each line contains two space-separated values Pi and Di, the name of the product 
type and the total flat discount offered on that product type.
The next line of the input contains a floating-point value Ai, the discount coupon prize.
The next line of the input contains an integer M, the total number of entries in the excel sheet.
Then M lines follow, each line contains five space-separated values IDi, PTi, Qi, Ci and DCi, 
the customer id, product type, quantity, prize of the single quantity and if they have the discount coupon.

Output Format

Print M lines, each line should contain two space-separated values, the customer id and the total 
bill of the customer rounded to 2 decimal places.

Constraints

1≤N≤103
1≤|Pi|≤20
0.00≤Di≤100.00
0.00≤Ai≤1000.00
1≤M≤105
1≤IDi≤M
PTi∈P
1≤Qi≤103
1≤Ci≤100000.00
DCi∈{YES,NO}

Sample Input
3
clothes 20.00
electronics 50.00
groceries 50.00
100.00
4
1 clothes 1 600.00 YES
3 electronics 2 5000.00 NO
1 groceries 1 100.00 YES
2 clothes 2 500.00 NO
Sample Output
3 5000.00
2 800.00
1 430.00
Explanation
Customer 1: clothes (600.00−120.00=480.00)+ groceries (100.00−50.00=50.00)=530.00−100.00=430.00
Customer 2: clothes (500.00−100.00=400.00)∗2=800.00
Customer 3: electronics (5000.00−2500.00=2500.00)∗2=5000.00
*/

/*
 * @author Mrinal
 *
 */


public class Problem3 {
	
}
