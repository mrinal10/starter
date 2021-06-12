package com.monocept10022018;
//The string has an odd length (i.e, L is odd) and all characters of T are same except the middle character, for example, 
//aabaa
import java.util.Scanner;

class Problem1{

   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   String s = sc.nextLine();
	   checkSpecial(s);
   }
   
   
   public static void checkSpecial(String s){
	   int couter = 0;
	   int increase = 0;
	   StringBuffer tempString = new StringBuffer();
	   StringBuffer tempS = new StringBuffer();
	   for(int i = 0; i<s.length()-1; i=i+1+increase) {
		   System.out.println("i ++++++ "+i);
		   try {
			   increase = 0;
			   tempString.delete(0, tempString.length());
			   tempS.delete(0, tempS.length());
			   
			   char startCharacter = s.charAt(i);
			   tempString.append(String.valueOf(startCharacter));
			   while (i+increase+1 < s.length()) {
				   if(startCharacter==s.charAt(i+increase+1)) {
					   increase++;
					   tempString.append(String.valueOf(startCharacter));
//					   tempS.append(String.valueOf(startCharacter))
				   } else if(startCharacter==s.charAt(i+increase+2)){
				   }
				   else {
					   break;
				   }
			   }
		       couter = couter+increase;
			   System.out.println("couter :: "+couter);
			   System.out.println("tempString :: "+tempString);
		   } catch (Exception e) {
				e.printStackTrace();
		   }
	   }
	   System.out.println(couter);
   }
}
