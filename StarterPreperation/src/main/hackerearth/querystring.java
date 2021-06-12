import java.io.*;
import java.util.*;


public class querystring {
	

    public static void main (String[] args) 
    {
    	int t;
    	Scanner sc=new Scanner(System.in);
    	t=sc.nextInt();
    	
    	while(t--!=0)
    	{
    		String newstr;
    		newstr=sc.next();
    		int a[]=new int[26];
    		for(int i=0;i<newstr.length();i++)
    		{
    			int val=((int)newstr.charAt(i))-97;
    			a[val]++;
    		}
    		for(int i=0;i<26;i++)
    		{
    			System.out.println (a[i]);
    		}
    		int noofquery=sc.nextInt();
    		while(noofquery--!=0)
    		{
    			String qstrng=sc.next();
    			int b[]=new int[26];
    			for(int i=0;i<qstrng.length();i++)
	    		{
	    			int val=((int)qstrng.charAt(i))-97;
	    			b[val]++;
	    		}
	    		for(int i=0;i<26;i++)
	    		{
	    			System.out.println (b[i]);
	    		}
    		}
    		   		int q=100;
    		for(int j=newstr.length();j>=q ;j--)
    		{
    			
    		}
    	}
	}
    
    
}