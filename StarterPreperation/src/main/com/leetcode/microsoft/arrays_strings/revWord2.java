package com.leetcode.microsoft.arrays_strings;

public class revWord2 {
    public void reverseWords(char[] s) {
        int len = s.length;
        char[] arr = new char[len];
        int indx2 = len-1;
        int startIndx = 0;
        while(s[startIndx]==' '){
            startIndx++;
        }

        if(startIndx>=len){
            return;
        }
        int endindx = startIndx;
        for(int i=startIndx; i<len; i++) {
            while( i < len && s[i]!=' ') {
                i++;
            }
            endindx = i-1;

            for(int j = endindx; j>=startIndx; j--) {
                arr[indx2] = s[j];
                indx2--;
            }
            indx2--;
            while(i<len && s[i]==' ') {
                i++;
            }
            startIndx = i;

        }

        for(int i=0; i<len; i++){
            s[i] = arr[i];
        }

    }

    public static void main(String[] args) {
        char[] s = {'a',' ','b'};//{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        revWord2 we2 = new revWord2();
        we2.reverseWords(s);
        System.out.println(s);
    }
}
