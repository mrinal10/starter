package com.zero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsNum {

	int stringToInt(String s)
	{
		int n = -1;
		try {	
			n = Integer.parseInt(s);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}

	int firstUniqueCharIdx(char s[]) {
		List<Character> list = new ArrayList();
		Set<Character> set = new HashSet();
		for(int i=0; i<s.length; i++){
			if(!set.contains(s[i])){
				set.add(s[i]);
				list.add(s[i]);
			}else if (list.contains(s[i])){
				list.remove(s[i]);
			}
		}
		if(list.isEmpty()){
		return -1;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
