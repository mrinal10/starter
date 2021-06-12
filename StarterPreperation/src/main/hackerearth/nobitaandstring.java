/**
 * @(#)nobitaandstring.java
 *
 *
 * @author : Mrinal
 * @version 1.00 2015/1/26
 */
import java.util.Scanner;

public class nobitaandstring
{
	public static void main(String[] args) {
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		String reverse="";
		while(t>0)
		{
			t--;
			String str=sc.next();
			int length = str.length();
	 
		    for ( int i = length - 1 ; i >= 0 ; i-- )
		         reverse = reverse + str.charAt(i);
		}
	}
}