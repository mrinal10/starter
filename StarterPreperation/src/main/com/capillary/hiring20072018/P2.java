package com.capillary.hiring20072018;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class P2 {
	private static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] binArr = new int[row][col];
		int flag = 0;
		for (int i = 0; i < row; i++) {
			String s = sc.next();
			for (int j = 0; j < col; j++) {
				binArr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		boolean f = false;
		int i = 0;
		while (!f) {
			if (i<col)  {
				flag = check(binArr, row, i, flag);
				if (flag == 1 && set.size()==1) {
					f = true;
					System.out.println(set.iterator().next()+1);
				}
			}else{
				f = true;
				System.out.println(set.iterator().next()+1);
			}
			i++;
		}
		sc.close();
	}
	
	private static int check(int[][] ar,int row, int col, int flag){
		if (set.isEmpty()) {
			for (int i = 0; i < row; i++) {
				if (ar[i][col]==0 && flag == 0) {
					set.add(i);
				}else if(ar[i][col]==1 && flag==0){
					set.clear();
					set.add(i);
					flag=1;
				}else if (ar[i][col]==1 && flag == 1) {
					set.add(i);
				}
			}
		} else {
			Iterator<Integer> iterator = set.iterator();
			
			while (iterator.hasNext()) {
				int i = iterator.next();
				if (ar[i][col]==0 && flag == 0) {
					set.add(i);
				}else if(ar[i][col]==1 && flag==0){
					set.clear();
					set.add(i);
					flag=1;
				}else if (ar[i][col]==1 && flag == 1) {
					set.add(i);
				}
			}
		}
		return flag;
	}
	
}



