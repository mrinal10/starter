package com.zero.exam;

public class FirstUniqueCharacter {
	public static void main(String[] args) {
		String s = "thisisreallygreat";
		System.out.println(firstUniqueCharIdx(s.toCharArray()));
	}
	
	static int firstUniqueCharIdx(char s[]) {
		
		for(int i=0; i<s.length-1; i++){
			int cnt = 0;
			for(int j=i+1; j<s.length; j++){
				if((s[i]!='@')&&(s[i]==s[j])){
					cnt++;
					s[j] = '@';
				}else if(s[i]=='@'){
					cnt++;
				}
			}
			if(cnt == 0){
				return i;
			}
		}
		if(s[s.length-1] != '@'){
			return s.length-1;
		}
		
		return -1;
	}
}
