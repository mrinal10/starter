/**
 * @(#)sherlokandpermutation.java
 *
 *
 * @author 
 * @version 1.00 2014/12/29
 */
import java.io.*;
import java.util.*;

public class sherlokandpermutation {

	public static int comb(int a,int b){
		int combi=1;
		
		return combi;
	}
   public static void main (String[] args) {
   		Scanner sc=new Scanner(System.in);
   		int t=sc.nextInt();
   		for(int i=0;i<t;i++)
   		{
   			int n,m;
   			n=sc.nextInt();
   			m=sc.nextInt();
   			
   			int val=comb(n+m-1,m-1);
   		}
   } 
    
}