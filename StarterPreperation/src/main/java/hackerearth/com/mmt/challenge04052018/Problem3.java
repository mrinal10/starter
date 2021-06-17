package com.mmt.challenge04052018;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		int n, t;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		t = sc.nextInt();
		int[] ar = new int[n];
		try {
			
			for(int i=0; i<=t; i++) {
				String s = sc.nextLine();
				if (s.startsWith("1")) {
					int x = Integer.parseInt(s.split(" ")[1]);
					x = x-1;
					ar[x] =  (2 * ar[x]) + 1;
				} else if(s.startsWith("2")) {
					int x = Integer.parseInt(s.split(" ")[1]);
					x = x-1;
					ar[x] =  (int) Math.floor(ar[x]/2);
				} else if(s.startsWith("3")) {
					int x = Integer.parseInt(s.split(" ")[1]);
					x = x-1;
					int y = Integer.parseInt(s.split(" ")[2]);
					y = y-1;
					int count = 0;
					for(int j = x; j<= y; j++ ) {
						int temp = ar[j];
						count += processandCount(temp);
					}
					System.out.println(count);
				} else {
					
				}
				print(ar);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			sc.close();
		}
	}
	
	private static void print(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
	}
	private static int processandCount(int n) {
	    int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
   	}
}
