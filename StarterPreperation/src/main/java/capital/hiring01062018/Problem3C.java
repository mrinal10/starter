package capital.hiring01062018;

import java.util.HashMap;
import java.util.Scanner;

public class Problem3C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int t = sc.nextInt();
		StringBuilder s1 = new StringBuilder("");
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			if (n>0) {
				s1.append(s.substring(0, n+1));
			}else{
				s1.append(s.substring(Math.abs(n), s.length()));
			}
		}
		HashMap<Integer, Character> map = getCharacteratIndex(s1);
		
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			if (map.get(k)!=null) {
				System.out.println(map.get(k));
			}else{
				System.out.println("-1");
			}
		}
		
		sc.close();
	}
	
	private static HashMap<Integer, Character> getCharacteratIndex(StringBuilder s){
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' ||s.charAt(i) == 'e' || s.charAt(i) == 'i'
					|| s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				count++;
				map.put(count, s.charAt(i));
			}
		}
		return map;
	}
}
