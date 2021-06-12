package com.spoj.dynamicproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class COINS {
	static Map<Long, Long> dp;

	private static long numBerofCoins(long n) {
		if (n <= 4) {
			return n;
		} else if (dp.containsKey(n)) {
			return dp.get(n);
		} else {
			dp.put( n, Math.max((numBerofCoins(n / 2) + numBerofCoins(n / 3) + numBerofCoins(n / 4)), n));
			return dp.get(n);
		}

	}

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        while ((line = in.readLine()) != null) {
        	if(line.trim().length()<1){
        		break;
        	}
            long n = Integer.parseInt(line);
            dp = new HashMap();       
            out.println(numBerofCoins(n));
        }
        out.flush();
    }
}