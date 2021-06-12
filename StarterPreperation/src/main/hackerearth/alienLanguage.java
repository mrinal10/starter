/**
 * @(#)alienLanguage.java
 *
 *
 * @author mrinal
 * @version 1.00 2015/2/4
 */

import java.io.*;
import java.util.*;

class TestClass 
{
	public static void main (String[] args) 
	{
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			String text,pattern;
			text=sc.next();
			pattern=sc.next();
			int len_pattern=pattern.length();
			int len_text=text.length();
			int i,j,k,flag=0;
			for(i=len_pattern;i>=1;i--)
			{
				for(j=0;j<len_pattern-i;j++)
				{
					String tempPattern=pattern.substring(j,j+i);
					String temptext="";
					for(k=0;k<len_text-i;k++)
					{
						temptext=text.substring(k,k+i);
						if(tempPattern.equals(temptext))
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
				if(flag==1)
				{
					break;
				}
			}
			if(flag==1)
			{
				System.out.println ("YES");				
			}
			else
				System.out.println ("NO");
		}
	}    
}