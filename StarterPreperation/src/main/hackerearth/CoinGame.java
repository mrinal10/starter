/*
 * Alice and Bob are playing a game. They have N coin piles, where the i th coin pile consists of 
A[i] coins initially. In addition, Alice and Bob have also been given some integer X. In a single move, a player can choose a single pile 
i(1≤i≤N) and withdraw any number of coins between 1 and m in (A[i],X) min(A[i],X) both inclusive from that pile.
Let's call the number of coins they withdraw in a move to be Y. After such a move, the number of coins in pile 
i reduces by Y. That is , A[i] transforms to A[i]−Y.

Alice and Bob take turns in playing this game, starting with Alice. The first player who is unable to make a valid move loses, and the other player wins the game.

Given a state of the game, and considering that both Alice and Bob play optimally, you need to find out the winner of the game.

Print "Alice" ( without quotes ) if Alice wins, else print "Bob" (without quotes) .

Input Format :

The first line consists of a single integer 
T
T denoting the number of test-cases in a single test file.

The first line of each test case consists of a 2 space separated integers 
N and X. The next line consists of N space separated integers, where the ith integer denotes 
A[i].

Output Format :

For each test case, print the winner of the game on a new line.

Constraints :

1≤T≤10

1≤N≤10^5

1≤A[i],X≤10^9 .

Sample Input
1
3 10
1 2 3
Sample Output
Bob
Explanation
If Bob plays optimally, any possible sequence of moves by Alice shall only lead to a loss.

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
Time Limit: 2.0 sec(s) for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes
Allowed Languages: C, C++, C++14, C#, Java, Java 8, JavaScript(Node.js)
 * 
 * 
 * */
public class CoinGame {

}
