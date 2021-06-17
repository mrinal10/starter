/**
 * @(#)Solution_twoarrays.java
 *
 *
 * @author 
 * @version 1.00 2014/11/21
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class twoarray{
	
	int [] a0,a1;
	twoarray(int a[],int b[]){
		a0=a;
		a1=b;
	}
	public void rev(int a[],int s,int e)
	{
		int temp;
		int mid=(s+e)/2;
		mid=mid-s;
		for(int i=0;i<=mid;i++){
			temp=a[i+s];
			a[i+s]=a[e-i];
			a[e-i]=temp;
		}			
	}
	public void one(int id,int l,int r){
		if(id==0){
			rev(a0,l,r);
		}		
		else{
			rev(a1,l,r);
		}
	}
	
	public void swap(int a[],int l1,int r1,int l2,int r2)
	{
		int temp;		
		for(int i=0;i<=r1-l1;i++){
			temp=a[i+l1];
			a[i+l1]=a[i+l2];
			a[i+l2]=temp;
		}			
	}
	public void two(int id,int l1,int r1,int l2,int r2){
		if(id==0){
			swap(a0,l1,r1,l2,r2);
		}		
		else{
			swap(a1,l1,r1,l2,r2);
		}
	}
	
	public void three(int l,int r)
	{
		int i,temp;		
		for(i=0;i<=r-l;i++){
			temp=a0[i+l];
			a0[i+l]=a1[i+l];
			a1[i+l]=temp;
		}			
	}
}

public class Solution_twoarrays {

    public static void main (String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
    	int N,M;
    	N=sc.nextInt();
    	M=sc.nextInt();
    	
    	int[] a0,a1;
    	a0=new int [N];
    	a1=new int [M];
    	for(int i=0;i<N;i++)
    	{
    		a0[i]=sc.nextInt();
    	}
    	
    	for(int i=0;i<M;i++)
    	{
    		a1[i]=sc.nextInt();
    	}
    	
    	twoarray tn=new twoarray(a0,a1);
    	
	}    
    
}