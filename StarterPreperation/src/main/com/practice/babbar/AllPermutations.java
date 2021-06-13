package com.practice.babbar;

public class AllPermutations {
	public void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i < r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	private String swap(String s, int l, int r) {
		char[] arr = s.toCharArray();
		char t = arr[l];
		arr[l] = arr[r];
		arr[r] = t;
		return String.valueOf(arr);
	}
	
	public static void main(String[] args) {
		AllPermutations ap = new AllPermutations();
		String str = "abcd";
		ap.permute(str, 0, str.length());
	}
}
