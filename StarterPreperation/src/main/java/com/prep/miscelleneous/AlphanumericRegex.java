package com.prep.miscelleneous;

import java.util.regex.*;  


public class AlphanumericRegex {

	public static String getMatched(String[] s) {
		for(int i=0; i<s.length; i++) {
			Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,20}$");// represents String with only alphanumeric value  
			Matcher m = p.matcher(s[i]);  
			if(m.matches()) {
				return s[i];
			}
		}
		return "";  
	}
	
	public static void main(String[] args) {
		String s = "Hi Javid,this is your pan ID bgapm8674,";
	
		System.out.println(getMatched(s.split(" ")));
	}

}
