import java.io.*;
import java.util.*;

class Solution_Grid {

    public static void main (String[] args) 
    {
    	int i,j,T;
    	Scanner sc=new Scanner(System.in);
    	T=sc.nextInt();
    	
    	for(i=0;i<T;i++)
    	{
    		int k,l,r,c,r1,c1;
    		r=sc.nextInt();
    		c=sc.nextInt();
    		int ar[][]=new int[r][c];
    		for(k=0;k<r;k++)
    		{
    			String s=sc.next();
    			for(l=0;l<c;l++)
    			{
    				ar[k][l]=(int)s.charAt(l)-48;
    			}
    		}
    		
    		r1=sc.nextInt();
    		c1=sc.nextInt();
    		int ar1[][]=new int[r][c];
    		for(k=0;k<r1;k++)
    		{
    			String s=sc.next();
    			for(l=0;l<c1;l++)
    			{
    				ar1[k][l]=(int)s.charAt(l)-48;
    			}
    		}
    		int tf=0;
    		for(k=0;k<=r-r1;k++)
    		{
    			for(l=0;l<=c-c1;l++)
    			{
    				int flag=0;
    				for(i=0;i<r1;i++)
    				{
    					for(j=0;j<c1;j++)
    					{
    						if(ar[k+i][l+j]!=ar1[i][j])
    						{
    							flag=1;
    							break;
    						}
    					}
    					if(flag==1)
    					{
    						break;
    					}
    				}
    				if(flag==0)
    				{
    					tf=1;
    					break;
    				}
    				if(tf==1)
    				{
    					break;
    				}
    			}
    		}
    		
    		if(tf==1)
    		{
    			System.out.println ("YES");
    		}
    		else
    		{
    			System.out.println ("NO");
    		}
    		
    	}
    }   
}