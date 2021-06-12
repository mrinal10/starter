package com.zero;

import java.util.Scanner;

public class Test
{
	
  	public static int printArr(int[] ar, int indx, int len, int key, int cnt){
      if(indx>len){
        return cnt;
      }
      if(ar[indx]==key){
        cnt = cnt+1;
      }
       return printArr(ar, indx+1, len, key, cnt);
       
    }
  
	public static void main(String[] args)
	{
    Scanner sc = new Scanner(System.in);  
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
          ar[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
          int key = sc.nextInt();
          int cnt = 0;
          cnt = printArr(ar, 0, ar.length-1, key, cnt);
          System.out.print(cnt);
        }
        
      }
      
	}
}