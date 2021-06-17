/**
 * @(#)countenemy.java
 *
 *
 * @author 
 * @version 1.00 2015/1/26
 */

import java.util.*;


class countenemy1 
{
	public static void main (String[] args) 
	{
		int tc;
		Scanner sc=new Scanner(System.in);
		tc=sc.nextInt();
		
		while(tc>0)
		{
			tc--;
			String abc=sc.next();
			int count=0;
			int length=abc.length();
			System.out.println ("length :"+length);
			char theflag=abc.charAt(0);
			char temp;
			for(int i=1;i<length;i++)
			{
				temp=abc.charAt(i);
				if(theflag=='X')		
				{					
					if(temp=='X')
					{
						System.out.println ("YES!!");
						System.out.println ("i = "+i);
						theflag='X';
					}					
					else if(temp=='O')
					{
						abc=abc.substring(0,i-1)+'K'+abc.substring(i+1);
					}
					else
					{
						theflag='N';
					}
					if(abc.charAt(i-1)=='O')
					{
						
						if(i==1)
						{
							abc='K'+abc.substring(i);
						}
						else
						{
							abc=abc.substring(0,i-2)+'K'+abc.substring(i);
						}
					}
				}
				else if(theflag=='N')
				{
					if(temp=='X')
					{
						theflag='X';
					}
					if(temp=='O')
					{
						count++;
					}
				}
			}			
			System.out.println (abc);
			System.out.println (count);			
		}
	}
}