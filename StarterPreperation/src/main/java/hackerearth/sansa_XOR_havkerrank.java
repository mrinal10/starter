import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution44
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int N,i,j,l,k,T;/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        T=sc.nextInt();
        for(i=0;i<T;i++)
        {
        	N=sc.nextInt();
        	int ar[]=new int[N];
        	for(j=0;j<N;j++)
        	{
        		ar[j]=sc.nextInt();
        	}
        	int kk=0;
        	for(j=1;j<=N;j++)
        	{
        		for(l=0;l<=N-j;l++)	
        		{
        			for(k=1;k<=j;k++)
        			{
        				kk=kk^ar[l+k-1];
        				System.out.print(" "+ar[l+k-1]);
        			}
        		}
        	}
        	System.out.println (kk);
        }
    }
}