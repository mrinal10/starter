import java.io.*;
import java.util.*;

class Solution_cipher
{
   public static void main (String[] args) 
   {
   		int kk,i,j,l,ac,no;
   		Scanner sc=new Scanner(System.in);
   		ac=sc.nextInt();
   		no=sc.nextInt();
   		int res[]=new int[ac];
   		int ar[][]=new int[no+1][ac+no-1];
   		String s=new String();
   		s=sc.next();
   		for(i=0;i<ac+no-1;i++)
   		{
   			ar[no][i]=(int) s.charAt(i)-48;
   		}
   	//	System.out.println ();
   		/*for(i=0;i<no;i++)
   		{
   			for(j=ac-i;j<ac+no-1;j++)	
   			{
   				ar[i][j]=0;
   			}
   			for(j=0;j<i;j++)	
   			{
   				ar[i][j]=0;
   			}
   		}*/
   		int z_c=0,o_c=0; 	
   		for(i=ac+no-2;i>no-2;i--)
   		{
   			for(j=0;j<no-1;j++)
   			{
   				if(ar[j][i]==1)
   				{
   					o_c++;
   				}   				
   			}
   		//	System.out.println (o_c);
   		//	System.out.println ("---"+ar[no][i]);
   			if(o_c%2==0 && ar[no][i]==1) 
   			{
   				ar[no-1][i]=1;
   				for(kk=0;kk<=no-2;kk++)
   				{
   					ar[kk][i-no+1+kk]=1;
   				}
   			}
   				
   			else if(o_c%2==0 && ar[no][i]==0)
   			{
   				ar[no-1][i]=0;
   				for(kk=0;kk<=no-2;kk++)
   				{
   					ar[kk][i-no+1+kk]=0;
   				}
   			}
   			else if(o_c%2==1 && ar[no][i]==1) 
   			{
   				ar[no-1][i]=0;
   				for(kk=0;kk<=no-2;kk++)
   				{
   					ar[kk][i-no+1+kk]=0;
   				}
   			}
   				
   			else if(o_c%2==1 && ar[no][i]==0)
   			{
   				ar[no-1][i]=1;
   				for(kk=0;kk<=no-2;kk++)
   				{
   					ar[kk][i-no+1+kk]=1;
   				}
   			}  
   			o_c=0;
   		}
   		  		
   	/*	for(i=0;i<=no;i++)
   		{
   			for(j=0;j<ac+no-1;j++)
   			{
   				System.out.print(ar[i][j]);
   			}
   			System.out.println ();
   		}	*/	
    
   //	System.out.println ();
   for(i=0;i<ac;i++)    
   {
   	System.out.print(ar[0][i]);
   }
   }
}