package com.spoj.dynamicproblems;

import java.util.Scanner;

public class ACODE {
	static String inp;

	private static int getCombinationCount(int index) {
		

		int retVal = 0;
		boolean flag = false;
		int value2 = 0;
		int value1 = 0;
		
		if (index == inp.length()-1) {
			return 1;
		}
		value1 = Integer.parseInt(inp.substring(index, index+1));
		if (value1 != 0) {
			System.out.println("singleValue :: "+value1);
			retVal = getCombinationCount(index + 1);
		}
		
		if(index + 2 >= inp.length()){
			return retVal;
		}
		value2 = Integer.parseInt(inp.substring(index, index + 2));
		
		if (value2 <= 26) {
			flag = true;
			System.out.println("value >> "+value2);
			retVal = retVal+getCombinationCount(index + 2);
		}
		if(flag){
			return 1+retVal;
		}
		return retVal;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		inp = sc.next();
		while (!inp.equals("0")) {
			System.out.println(getCombinationCount(0));
			inp = sc.next();
		}
		sc.close();
	}

}
