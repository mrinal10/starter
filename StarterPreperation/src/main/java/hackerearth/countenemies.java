import java.util.*;
import java.io.*;

class countenemy 
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
			int length=abc.length();
			System.out.println ("length :"+length);
			char theflag=abc.charAt(0);
			char temp;
			for(int i=0;i<length;i++)
			{				
				if(abc.charAt(i)=='o')
				{
					int k=78;
					int j=i-1;
					while(j>=0 && abc.charAt(j)!='*' && abc.charAt(j)!='N')
					{
						if(abc.charAt(j)=='x')
						{
//							abc.charAt(j)=(char)k;
						}
						j--;
					}
					j=i+1;
					while(j<length && abc.charAt(j)!='*' && abc.charAt(j)!='N')
					{
						if(abc.charAt(j)=='x')
						{
//							abc.charAt(j)=(char)k;
						}
						j++;
					}					
				}
			}
			System.out.println (abc);
		}
	}
}