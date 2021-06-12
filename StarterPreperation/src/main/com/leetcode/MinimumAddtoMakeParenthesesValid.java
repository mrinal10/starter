package com.leetcode;

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
    	int count = 0;
    	int balancer = 0;
    	for(int i=0; i<S.length(); i++){
    		if (S.charAt(i)=='(') {
    			balancer++;
			}else{
				balancer--;
			}
    		if (balancer<0) {
				count++;
				balancer = 0;
			}
    	}
        return count+balancer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
