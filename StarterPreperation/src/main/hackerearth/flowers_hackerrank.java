import java.io.*;
import java.util.*;

class Solution_Flowers 
{
	public static void main (String[] args) 
	{
		int N,K,i,j;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
					
		int A[]=new int[N];
		
		for(j=0;j<N;j++)			
		{
			A[j]=sc.nextInt();
		}
		A=quicksort(A,0,N-1);
		
		int k,price=0,f=0,mm=1,q,r;	
		
		q=N/K;
		r=N%K;
		//System.out.println (" q : "+q);
		for(j=0;j<q;j++)
		{
			for(i=0;i<K;i++)
			{
				price=price+mm*A[(j*K)+i];
				//System.out.println ("price :"+price);
			}
			mm++;			
		}
		//System.out.println ("j :"+j);
		//System.out.println ("val : "+(j*k));
		for(i=0;i<r;i++)
		{
			//System.out.println ("val : "+(j*q)+i);
			price=price+mm*A[(j*K)+i];
			//System.out.println ("price :"+price);
		}
		System.out.println (price);
	}    
	
	static int[] quicksort(int x[],int first,int last)
	{
		int pivot,j,temp,i;

     	if(first<last)
	 	{
        	pivot=first;
         	i=first;
	        j=last;

         	while(i<j)
		 	{
            	while(x[i]>=x[pivot]&&i<last)
                	i++;
            	while(x[j]<x[pivot])
                	j--;
             	if(i<j)
			 	{
                	temp=x[i];
                    x[i]=x[j];
                    x[j]=temp;
             	}
         	}
         	temp=x[pivot];
         	x[pivot]=x[j];
         	x[j]=temp;
         	quicksort(x,first,j-1);
         	quicksort(x,j+1,last);
    	}
    	return x;
	}
}