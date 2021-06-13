package com.leetcode.microsoft.arrays_strings;

import java.util.*; 

public class Reverse_each_Words {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");
        List<String> allWordsList = new ArrayList<String>();

        while(st.hasMoreTokens()){
            allWordsList.add(st.nextToken());
        }

        for(int i = allWordsList.size()-1; i >=0 ; i--){
            sb.append(allWordsList.get(i));
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
