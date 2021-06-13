package com.leetcode.microsoft.arrays_strings;

import java.util.Stack;

public class validpaenthesis {

    public boolean isValid(String s) {
        char[] parentArr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i=0;
        while(i<parentArr.length) {
            char cur = parentArr[i];
            if(cur == '}' || cur == ']' || cur == ')') {
                if(stack.isEmpty()){
                    return false;
                }
                char prev = stack.pop();
                if(cur == '}' && prev != '{') {
                    return false;
                } else if(cur == ']' && prev != '['){
                    return false;
                } else if(cur == ')' && prev != '('){
                    return false;
                }
            } else {
                stack.push(cur);
            }
            i++;
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()";

        validpaenthesis vp = new validpaenthesis();
        System.out.println(vp.isValid(s));
    }
}
