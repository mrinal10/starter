import java.io.*;
import java.util.*;

class TestClass_Haunted {
    public static void main(String args[] ) 
    {
    	Scanner sc=new Scanner(System.in);
    	int N=sc.nextInt();
    	int M=sc.nextInt();
    	int ar[]=new int[N];
    	int br[]=new int[M];
    	
    	for(int i=0;i<N;i++)
    	{
    		ar[i]=sc.nextInt();
    	}
    	
    	for(int i=0;i<N;i++)
    	{
    		br[ar[i]-1]++;
    		int count=0;
    		int index=0;
    		for(int j=M-1;j>=0;j--)
    		{
    			if(count<br[j])
    			{
    				count=br[j];
    				index=j;
    			}
    		}
    		System.out.println ((index+1)+" "+count);
    	}
    }
}
