/**
 * @(#)bestBrowser.java
 *
 *
 * @author 
 * @version 1.00 2015/1/21
 */
import java.util.StringTokenizer;
import java.util.Scanner;
public class bestBrowser 
{
    public static void main (String[] args) 
    {
 		int t;
 		Scanner sc=new Scanner(System.in);
 		t=sc.nextInt();
 		
 		while(t!=0)
 		{
 			t--;
 			int i=0,count=0;
 			String abc=sc.next();
 			//StringTokenizer st=new StringTokenizer(abc,".");
 			int length=abc.length();
 			while(i<length-4)
 			{
 				char kk=abc.charAt(i+4);
 				if(kk=='a' || kk=='e' || kk=='i' || kk=='o' || kk=='u')
 				{
 					count++;
 				}
 				i++;
 			}
 			System.out.println ((length-count-3)+ "/"+ length);
 		}
	}      
}