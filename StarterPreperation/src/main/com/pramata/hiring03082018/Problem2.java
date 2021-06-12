package com.pramata.hiring03082018;

import java.math.BigInteger;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 
        int t = s.nextInt();
        BigInteger max = new BigInteger("0");
        int cnt = 0;
        for(int i=0; i<n; i++){
            BigInteger temp = s.nextBigInteger();
            if(cnt<t){
                if(max.compareTo(temp)<0){
                    max = temp;
                }
                cnt++;
            }
        }
        System.out.println(max);
        s.close();
    }
}