package com.leetcode.microsoft.arrays_strings;

public class Reverse_String {

    public void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++) {
            int start = i;
            int end = s.length-1-i;

            char temp = s[start];

            s[start] =s[end];
            s[end] = temp;

        }
    }

    public static void main(String[] args) {
        
    }
}
