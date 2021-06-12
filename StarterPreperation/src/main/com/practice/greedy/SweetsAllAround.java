package com.practice.greedy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class SweetsAllAround {
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		TreeSet<Integer> ha=new TreeSet<Integer>();
		int a[]=new int[n];
		int b[]=new int[n];
		for(int y=0;y<n;y++)
		{
			int x=sc.nextInt();
			int z=sc.nextInt();
			a[y]=x;
			b[y]=z+1;
			ha.add(x);
			ha.add(z+1);
		}
		
		
		Iterator<Integer> fg=ha.iterator();
		int ar[]=new int[ha.size()+1];
		int are[]=new int[ha.size()+1];
		HashMap<Integer,Integer> fb=new HashMap<Integer,Integer>();
		int y=1;
		while(fg.hasNext())
		{
			are[y]=fg.next();
			fb.put(are[y], y);
			y++;
		}
	
		
		for(int u=0;u<n;u++)
		{
			ar[fb.get(a[u])]++;
			
			ar[fb.get(b[u])]--;
		//	System.out.println(fb.get(b[u]));
		}
		//System.out.println(ar[1]);
		for(int f=2;f<=ha.size();f++)
		{
	//		System.out.println(ar[f]);
			ar[f]=ar[f-1]+ar[f];
		}
		int max=Integer.MIN_VALUE;
		int co=0;
		for(int e=1;e<=ha.size();e++)
		{
			if(ar[e]>max)
			{
				max=ar[e];
				co=e;
			}
		}	
		System.out.println(are[co]+" "+max);
    }	
}