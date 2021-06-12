package com.hotstar.hiring06072018;

import java.util.Scanner;

class BinTOdec {
	
	private static int countOnes(String s, int length){
		int count = 0;
//		System.err.println("count Ones :: "+length);
		for (int i = 0; i < length; i++) {
			if (s.substring(i, i+1).equals("1")) {
				count++;
			}
		}
		return count;
	}
	
	private static void calculate(String s, int length){
		int cnt = countOnes(s, length);
		if (cnt%3!=0) {
			System.out.println("-1");
			return;
		}
		String s1 = new String();
		String s2 = new String();
		String s3 = new String();
		
		int oneCountforEach = cnt/3;
//		System.out.println(cnt);
		int onCount=0;
		int i = 0;
		for (i = length-1; i>0 && onCount<oneCountforEach; i--) {
			s3 = s.charAt(i)+s3;
			if (s.charAt(i)=='1') {
				onCount++;
			}
		}
		s = s.substring(0, i);
//		System.out.println(s3+" ::: "+s);
		int stIndex = s.indexOf(s3);
		int startIndexs2 = stIndex+s3.length();
		s1 = s.substring(stIndex, startIndexs2);
		s2 = s.substring(startIndexs2,s.length());
		if (!(s1.contains(s3) && s2.contains(s3))) {
			System.out.println("-1");
			return;
		}
		System.out.println(BinaytoDecimal(s3));
	}
	
    private static int BinaytoDecimal(String s){
    	int decimal=0,p=0;
        int n = s.length();
		for(int i=n-1; i>=0; i--){
            decimal+=(Integer.parseInt(String.valueOf(s.charAt(i)) )*Math.pow(2,p));
            decimal = decimal % 1000000007;
            p++;
        }
        return decimal;
    }

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int i = 0; i < t; i++) {
			try {
				int len = sc.nextInt();
				String s = "";
				for (int j = 0; j < len; j++) {
					s = s+sc.next();
				}
	
				calculate(s,len);
			} catch (Exception e) {
				
			}
		}
		sc.close();
	}
}
