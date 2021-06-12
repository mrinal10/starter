package com.leetcode;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '  && i+1<s.length()  && s.charAt(i+1)!=' '){
                cnt = 0;
            }else if(s.charAt(i)!=' ')
                cnt++;
        }
        return cnt;
    }

}
