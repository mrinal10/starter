package com.hiring.tcs12102018;

import java.util.Scanner;

public class CountingVowelSubsequence {
	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U');
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int prev = 0;
		int next = 0;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (isVowel(cur)) {
				
				cnt += prev*next;
				prev = next;
				next = 0;
				cnt += prev;
				cnt+=1;
			}else{
				next++;
			}
		}
		if (next==0) {
			cnt += prev;
		}else
			cnt += prev*next;
		System.out.println(cnt);
		sc.close();
	}
}
