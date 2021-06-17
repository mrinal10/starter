import java.io.*;
import java.util.*;

class Solution_two
{
	public static void main (String[] args) 
	{
		int T,N,K,i,j;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(i=0;i<T;i++)
		{
			N=sc.nextInt();
			K=sc.nextInt();
						
			int A[]=new int[N];
			int B[]=new int[N];
			
			for(j=0;j<N;j++)			
			{
				A[j]=sc.nextInt();
			}
			
			for(j=0;j<N;j++)			
			{
				B[j]=sc.nextInt();
			}
			A=quicksort(A,0,N-1);
			B=quicksort(B,0,N-1);
			
			int flag=0,temp=0;	
			for(j=0;j<N;j++)
			{
				temp=A[j]+B[N-1-j];
				if(temp<K)
				{
					flag=1;
				}
			}
			if(flag==0)
				System.out.println ("YES");
			else
				System.out.println ("NO");
		}
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
            	while(x[i]<=x[pivot]&&i<last)
                i++;
            	while(x[j]>x[pivot])
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