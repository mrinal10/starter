import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MemoriseMe {
	public static void main(String[] args) {
		HashMap<Integer, Integer> kvPair = new HashMap<>();
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				int k = sc.nextInt();
				Integer value=kvPair.get(new Integer(k));
			
				if ( value!= null) {
					int vaLue = (int) value;
					vaLue+=1;
					kvPair.put(new Integer(k), new Integer(vaLue));
				
				} else {
					kvPair.put(new Integer(k), new Integer(1));
					
				}
				//System.out.println(k);
			}
			
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int k = sc.nextInt();
				Integer value=kvPair.get(new Integer(k));
				
				if ( value!= null) {
					System.out.println((int)value);
				} else {
					System.out.println("NOT PRESENT");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * Sample Input
 * 
 * 6
1 1 1 2 2 0
6
1
2
1
0
3
4
SAMPLE OUTPUT 
3
2
3
1
NOT PRESENT
NOT PRESENT

 * 
 * */
