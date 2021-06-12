package com.zero;

public class BitFlipsRequired {
	int countsetBits(int v){
		int setBitCnt = 0;
		while(v!=0){
			setBitCnt += v&1;
			v = v>>1;
		}
		return setBitCnt;
	}
	int bitFlipsRequired(int a, int b) { 
		return (countsetBits(a^b));
	}
	public static void main(String[] args) {
		BitFlipsRequired breq = new BitFlipsRequired();
		System.out.println(breq.bitFlipsRequired(20,30));
	}
}
