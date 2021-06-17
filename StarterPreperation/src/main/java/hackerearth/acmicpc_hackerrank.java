/**
 * @(#)acmicpc_hackerrank.java
 *
 *
 * @author 
 * @version 1.00 2014/11/24
 */


import java.io.*;
import java.util.*;

class test_acm{
	public static void main (String[] args) 
	{
		int i,j,k,N,M,max=0,count=0,temp=0;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		String s=new String();
		int in[][]=new int[N][M];
		for(i=0;i<N;i++)
		{
			s=sc.next();
			for(j=0;j<M;j++)
			{
				in[i][j]=(int) s.charAt(j)-48;
			}
		}
		
		for(i=0;i<N-1;i++)
		{
			for(j=i+1;j<N;j++)
			{
				for(k=0;k<M;k++)	
				{
					if(in[i][k]==1 || in[j][k]==1)
					{
						temp++;
					}
				}
				if(temp>max)
				{
					max=temp;
					count=1;
				}
				else if(temp==max)
				{
					count++;
				}
				temp=0;
			}
		}
		System.out.println (max);
		System.out.println (count);
	}
}