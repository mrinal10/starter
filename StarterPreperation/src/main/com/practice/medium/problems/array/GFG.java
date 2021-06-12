package com.practice.medium.problems.array;

class GFG
{
     
    // Function for multiplication
    static int multiply(int n, int m)
    { 
        int ans = 0, count = 0;
        while (m > 0)
        {
            // check for set bit and left 
            // shift n, count times
            if (m % 2 == 1)             
                ans += n << count;
            System.out.println( "ans :: "+ans );
            // increment of place 
            // value (count)
            count++;
            m /= 2;
        }
         
        return ans;
    }
     
    // Driver function
    public static void main (String[] args)
    {
        int n = 20, m = 13;
         
        System.out.print( multiply(n, m) );
    }
}
