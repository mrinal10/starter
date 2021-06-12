
package com.hiring.hsbc22062019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyString {
	private String val;

	public MyString(String val) {
		this.val = val;
	}

	public static void main(String args[]) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		String str1 = new String("Java OOPs!");
		String str2 = new String("Java OOPs");
		map1.put(str1, new Integer(10));
		map1.put(str2, new Integer(20));
		Map<MyString, Integer> map2 = new HashMap<MyString, Integer>();
		MyString str3 = new MyString(str1);
		MyString str4 = new MyString(str2);
		map2.put(str3, new Integer(10));
		map2.put(str4, new Integer(20));
		System.out.println(map1.get(str1));
		System.out.println(map2.get(str3));
	}
}

//class StrPerm {
//	 
//    public static void main(String args[]) {
// 
//        List<String> output = StrPerm.genPerm("AB");
//        output.stream().forEach(System.out::println); 
//    }
// 
//    public static List<String> genPerm(String input) 
//    {
//         List<String> strList = new ArrayList<String>();
//         StrPerm.permutations("", input, strList);
//         return strList;
//    }
// 
//    private static void permutations(String consChars, String str, List<String> opContainer){
// 
//            for(int i=0; i<str.length(); i++) {
//            permutations(consChars+str.charAt(i), str.substring(0,str.substring(i+1),opContainer);
//        }
//    }
//}