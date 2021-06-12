import java.io.*;
import java.util.*;




class test_chocolate{
		
	
	public static int getdistinct(int a[],int t)
	{
		int distinct;
		int b[]=new int[t];
		int tb=-1;
		for(int i=0;i<t;i++)
		{
			int flag=0;
			for(int j=0;j<tb;j++){
				//System.out.println ("b[j] :"+b[j]);
				if(a[i]==b[j])
				{
					flag=1;
					break;
				}
			}
			if(flag!=1){
				tb++;
				b[tb]=a[i];
			}
		}
		distinct=tb-1;
		return distinct;
	}
	
	public static int ipow(int base, int exp)
	{
	    int result = 1;
	    while(exp!=0)
	    {
	        if ((exp&1)!=0)
	        {
	        	result *= base;
	        }
	            
	        exp >>= 1;
	        base *= base;
	    }
	
	    return result;
	}
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
	
		int a[]=new int[t];
		for(int i=0;i<t;i++){
			a[i]=sc.nextInt();
		}
		
		int val=getdistinct(a,t);
		System.out.println (val);
		val=ipow(2,val)-1;
		System.out.println (val);
	}
}