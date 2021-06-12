/**
 * @(#)frog_jump_hackerearth.java
 *
 *
 * @author 
 * @version 1.00 2014/11/19
 */
import java.io.*;
import java.util.*;

public class frog_jump_hackerearth {

    /*public frog_jump_hackerearth() {
    }*/
    
    public static void main (String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
       	int tcase,i,n,s,m,e,step=0;
       	n=sc.nextInt();
       	int ar[];
       	ar=new int[n];
       	for(i=0;i<n;i++){
       		ar[i]=sc.nextInt();
       	}
       	tcase=sc.nextInt();
       	
       	for(i=0;i<tcase;i++){
       		step=0;
       		s=sc.nextInt();
       		m=sc.nextInt();
       		e=sc.nextInt();
       		int t1=ar[s-1];
       		int t2=ar[e-1];
       		if(t1!=t2){
       			step=-1;
       		}
       		else if(ar[s-1]!=ar[m] || ar[e-1]!=ar[m]){  
       				step=-1;
       		}
       		else{
       			step=2;	
       		}
       		
    		System.out.println (step);
       	}       	
    }    
}