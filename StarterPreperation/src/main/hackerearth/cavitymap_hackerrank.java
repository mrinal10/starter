import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*class tile
{
	private String s;
	public int in,i,j;
	public tile(n){
		in=new int[n][n];
		s=new String();
		Scanner sc=new Scanner(system.in);
		for(i=0;i<n;i++)
		{
			s=sc.next();
			for(j=0;j<n;j++)
			{
				in[i][j]=((int)s.charAt(j))-48;
			}
		}
	}
	
	int[][] getCavity()
	{
		int k,l;
		for(k=1;k<n-1;k++)
		{
			for(l=1;l<n-1;l++)
			{
				if(in[k][l]<in[k-1][l] && in[k][l]<in[k+1][l] && in[k][l]<in[k][l-1] && in[k][l]<in[k][l+1])
				{
					in[k][l]=-1;
				}				
			}	
		}
		return in;
	}
}*/


class Solution_Cavity {

    public static void main(String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	int i,j,n,res,k,l;
    	n=sc.nextInt();
    	//tile t=new tile(n);
    	//res=new int[n][n];
    	//res=t.getCavity();
    	int in[][]=new int[n][n];
    	int in1[][]=new int[n][n];
		String s=new String();
		for(i=0;i<n;i++)
		{
			s=sc.next();
			for(j=0;j<n;j++)
			{
				in[i][j]=((int)s.charAt(j))-48;
			}
		}
		System.out.println ();
		System.out.println ();
		for(l=0;l<n;l++)
		{
			in1[0][l]=in[0][l];
			in1[n-1][l]=in[n-1][l];			
		}
		
		for(k=0;k<n;k++)		
		{
			in1[k][0]=in[k][0];	
			in1[k][n-1]=in[k][n-1];			
		}
		
		for(k=1;k<n-1;k++)
		{
			for(l=1;l<n-1;l++)
			{
				if(in[k][l]>in[k-1][l] && in[k][l]>in[k+1][l] && in[k][l]>in[k][l-1] && in[k][l]>in[k][l+1])
				{
					in1[k][l]=-1;
				}
				else
				{
					in1[k][l]=in[k][l];
				}				
			}
		}
		
		for(k=0;k<n;k++)
		{
			for(l=0;l<n;l++)
			{
				if(in1[k][l]!=-1)
					System.out.print(in1[k][l]);
				else
					System.out.print("x");
			}
			System.out.println ();
		}		
    }
}