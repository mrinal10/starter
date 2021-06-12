package com.hackerearth.practice;

//import java.util.LinkedHashMap;
import java.util.Scanner;

public class HarryandString {
	static int isSubstring(String s1, String s2){
        int M = s1.length();
        int N = s2.length();
     
        for (int i = 0; i <= N - M; i++) {
            int j;
     
            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;
     
            if (j == M)
                return i;
        }
     
        return -1;
    }
	static void findTypeOfString(String s) {
//		LinkedHashMap<Character, Integer> linkedMap = new LinkedHashMap<>();
		String vowels = "aeiou";
		s = s.toLowerCase();
		char[] arr = s.toCharArray();
		String deduced = "";
		char prev = 'l';
		for (int i = 0; i < arr.length; i++) {
			if((arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') && prev!=arr[i]){
				prev = arr[i];
				deduced = deduced+arr[i];
			}
		}
		System.out.println(deduced);
		String revVowel = "uoiea";
		if (isSubstring(vowels, deduced)!=-1) {
			System.out.println("Good");
		}else if(isSubstring(revVowel, deduced)!=-1){
			System.out.println("Worst");
		}else{
			System.out.println("Bad");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			findTypeOfString(s);
		}
		sc.close();

	}

}
