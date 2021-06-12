package com.hiring.wissen;

import java.util.Scanner;

public class Wissen2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		char[] cArray = s.toCharArray();
		int q = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < q; i++) {
			String qry = sc.nextLine();
			String[] qryArr = qry.split(" ");
			if (qryArr.length==1) {
				System.out.println(lis(cArray, n));
			}else{
				int indx = Integer.parseInt(qryArr[1]);
				char c = qryArr[2].charAt(0);
				cArray[indx-1] = c;
			}
		}
		sc.close();
	}

	static int lis(char arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		for (i = 0; i < n; i++)
			lis[i] = 1;

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

}
