package com.prep.stringmanupulation;

public class LongestCommonAnagram {
	public static void main(String[] args) {
		String str1 = "abdacp"; 
        String str2 = "ckamb"; 

        System.out.print("Length = " +  
        		getLongestCommonAnagramLength(str1, str2)); 
	}
	
	private static int getLongestCommonAnagramLength(String a, String b) {
		int[] aArr = new int[26];
		int[] bArr = new int[26];
		
		for (int i = 0; i < a.length(); i++) {
			aArr[(int)a.charAt(i)-(int)'a']++;
		}
		
		for (int i = 0; i < b.length(); i++) {
			bArr[(int)a.charAt(i)-(int)'a']++;
		}
		
		int len = 0;
		for (int i = 0; i < bArr.length; i++) {
			len += Math.min(aArr[i], bArr[i]);
		}
		return len;
	}
}
