package com.spoj.dynamicproblems;

import java.util.Scanner;

public class TOURIST {
	static char[][] ar;
	
	private static boolean isSafe(int r, int c){
		return ((r>=0 && r<ar.length)&&(c>=0 && c<ar[0].length));
	}
	
	private static int goToTrgt(int r, int c, int cnt){
		if(!isSafe(r, c)){
			return cnt;
		}
		if((r==ar.length-1 && c==ar[0].length-1)){
			return cnt; 
		}
		if(ar[r][c]=='#'){
			return cnt;
		}
		if(ar[r][c]=='*'){
			ar[r][c]='.';
			cnt++;
		}
		return Math.max(goToTrgt(r+1, c, cnt),goToTrgt(r, c+1, cnt));
	}
	
	private static int goToOrigin(int r, int c, int cnt){
		if(!isSafe(r, c)){
			return cnt;
		}
		if(r==0 && c==0){
			return cnt; 
		}
		if(ar[r][c]=='#'){
			return cnt;
		}
		if(ar[r][c]=='*'){
			cnt++;
		}
		return Math.max(goToOrigin(r-1, c, cnt),goToOrigin(r, c-1, cnt));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int c = sc.nextInt();
			int r = sc.nextInt();
			ar = new char[r][c];
			for (int i = 0; i < r; i++) {
				String s = sc.next();
				for (int j = 0; j < c; j++) {
					ar[i][j] = s.charAt(j);
				}
			}
			System.out.println(goToTrgt(0,0,0));
			System.out.println(goToOrigin(ar.length-1, ar[0].length-1, 0));
		}
		sc.close();
	}

}
