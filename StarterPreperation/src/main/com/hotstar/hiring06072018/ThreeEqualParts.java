package com.hotstar.hiring06072018;

import java.util.Scanner;

public class ThreeEqualParts {
    static long mod = (long)1e9 + 7;
	static long binaryToDecimal(String s) {
        // Pre-calculate all powers of 2 modulo (10^9 + 7)..
        long pow[] = new long[s.length()];
        pow[0] = 1;
        for(int i=1;i<s.length();i++) {
            pow[i] = pow[i - 1] * 2L;
            pow[i] %= mod;
        }
        long ans = 0;
        int power = 0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == '1') {
                ans += pow[power];
                ans %= mod;
            }
            power++;
        }
        return ans;
    }
	private static int createEqualThree(int[] arr, int lIndex, int rIndex){
		if(lIndex>=rIndex){
			return -1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int nlen = sc.nextInt();
			int[] arr = new int[nlen];
			
		}
		sc.close();
	}

}
