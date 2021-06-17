/**
 * @(#)completestring.java
 *
 *
 * @author 
 * @version 1.00 2015/1/27
 */
import java.util.*;

public class completestring 
{
	public static void main (String[] args) 
	{

	int t;    
	Scanner sc=new Scanner(System.in);
	t=sc.nextInt();
	while(t>0)
	{
		t--;
		String s=sc.next();
		if(s.length()<26)
		{
			System.out.println ("NO");
		}
		else
		{
			int a[]=new int[26];
			int temp,flag=0;
			for(int i=0;i<26;i++)
			{
				a[i]=0;
			}
			for(int j=0;j<s.length();j++)
			{
				temp=((int)s.charAt(j))-97;
				//System.out.println ("temp : "+temp);
				a[temp]++;
			}
			for(int i=0;i<26;i++)
			{
				if(a[i]==0)
				{
					flag=-1;
					break;
				}
			}
			if(flag==-1)
			{
				System.out.println ("NO");
			}
			else
			{
				System.out.println ("YES");
			}
		}
	}
	}
}