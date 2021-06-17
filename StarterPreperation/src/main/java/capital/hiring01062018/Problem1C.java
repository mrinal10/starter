package capital.hiring01062018;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Problem1C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int ar[] = new int[n];
		try {
			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextInt();
			}
			int currentCount = 1;
			int longCOunt = currentCount;
			for (int i = 0; i < ar.length-1; i++) {
				boolean flag = checkCommondigits(ar[i], ar[i+1]);
				if (!flag) {
					currentCount++;
					if (longCOunt<currentCount) {
						longCOunt = currentCount;
					}
				}else{
					currentCount=1;
				}
				
			}
			System.out.println(longCOunt);
		} catch (Exception e) {
		}
		sc.close();
	}
	
	private static boolean checkCommondigits(int first, int second){
		String s = String.valueOf(first);
		Set resultSet1 = convertToSet(s);
		
		
		String s2 = String.valueOf(second);
		Set resultSet2 = convertToSet(s2);
		resultSet1.retainAll(resultSet2);
		
		for (Iterator iterator = resultSet1.iterator(); iterator.hasNext();) {
			Character object = (Character) iterator.next();
			System.out.println("res2 >>>>>>"+object);
		}
		return resultSet1.isEmpty();
	}
	
	  public static Set convertToSet(String string) {
		  Set resultSet = new HashSet();
	      for (int i = 0; i < string.length(); i++) {
	          resultSet.add(new Character(string.charAt(i)));
	      }
	      return resultSet;
	  }

}
