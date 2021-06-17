package september.circuits;

import java.util.*;

public class CItyTravel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int x = sc.nextInt();
		int n = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			map.put(k, v);
		}
		int days = 0;
		while (s>0) {
			days++;
			if (map.containsKey(days)) {
				s -= map.get(days);
			}else{
				s -= x;
			}
		}
		System.out.println(days);
		sc.close();
	}

}
