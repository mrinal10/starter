
import java.io.*;
import java.util.*;

class combi
{	
	public int n1,r;
	public combi(int n2,int r2)
	{
		n1=n2;
		r=r2;
	}
	
	public int fact(int n)
	{
		int i,fact=1;
		for(i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		if(n==0)
		{
			return 1;
		}
		else
		{
			return fact;
		}
	}
		
	public int getcombi()
	{
		int combinat;
		combinat=fact(this.n1)/(fact(this.r)*(fact(this.n1-this.r)));
		return combinat;
	}	

}

class test_nice
{
	
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("\nEnter the number n:");
		int a=sc.nextInt();
		System.out.println ("\nEnter the number r:");
		int b=sc.nextInt();
		combi c=new combi(a,b);
		System.out.println (c.getcombi());
	}
	
}