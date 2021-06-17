/**
 * @(#)cricketMatch.java
 *
 *
 * @author 
 * @version 1.00 2015/1/23
 */
import java.io.*;
import java.util.*;

public class cricketMatch 
{
	public static boolean find(int key,ArrayList al)
	{int i=0;
		for(i=0;i<al.size();i++)
		{
			if(key==(Integer)al.get(i))
				return true;
		}
		return false;
	}

	public static void main (String[] args) 
	{
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int m,n,i;
			n=sc.nextInt();
			m=sc.nextInt();
			int abc[][]=new int[n][2];
			for(i=0;i<m;i++)
			{
				abc[i][0]=sc.nextInt();
				abc[i][1]=sc.nextInt();
			}
			ArrayList t1=new ArrayList();
			ArrayList t2=new ArrayList();
			
			for(i=0;i<m;i++)
			{
				if(t1.size()==0 && t2.size()==0)
				{
					t1.add(abc[i][0]);
					t2.add(abc[i][0]);
				}
					
				else
				{
					int key=abc[i][0];
					boolean flag=find(key,t1);
					if(flag==true)
					{
						key=abc[i][1];
						flag=find(key,t2);
						if(flag==true)
						{
							System.out.println ("NO");
							System.exit(0);
						}							
						else
							t2.add(key);
					}
					else
					{
						t1.add(key);
						key=abc[i][1];
						flag=find(key,t2);
						if(flag==true)
						{
							System.out.println ("NO");
							System.exit(0);
						}							
						else
							t2.add(key);
					}				
				}
			}
			System.out.println ("YES")			;
		}	
	}

}