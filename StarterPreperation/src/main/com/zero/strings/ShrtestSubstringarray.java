package com.zero.strings;

import java.util.*;

public class ShrtestSubstringarray {
	boolean isMatch(String subString, String B) {
		char[] charArry = subString.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < charArry.length; i++) {
			if (map.containsKey(charArry[i])) {
				map.put(charArry[i], map.get(charArry[i]) + 1);
			} else {
				map.put(charArry[i], 1);
			}
		}

		char[] charArryB = B.toCharArray();
		HashMap<Character, Integer> Bmap = new HashMap<>();
		for (int i = 0; i < charArryB.length; i++) {
			if (Bmap.containsKey(charArryB[i])) {
				Bmap.put(charArryB[i], Bmap.get(charArryB[i]) + 1);
			} else {
				Bmap.put(charArryB[i], 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : Bmap.entrySet()) {
			if (map.containsKey(entry.getKey()) && map.get(entry.getKey()) >= Bmap.get(entry.getKey())) {
				Bmap.put(entry.getKey(), 0);
			}
		}
		for (Map.Entry<Character, Integer> entry : Bmap.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

	String shortestSubstring(String A, String B) {
		int minSubStrngLength = Integer.MAX_VALUE;
		String stringToRet = "-1";
		for (int i = 0; i < A.length() - 1; i++) {
			for (int j = i + 1; j <= A.length(); j++) {
				String sbStrng = A.substring(i, j);
				if (sbStrng.length() < minSubStrngLength && isMatch(sbStrng, B)) {
					minSubStrngLength = sbStrng.length();
					stringToRet = sbStrng;
				}
			}
		}
		return stringToRet;
	}

	public static void main(String[] args) {
		// String A = "testing";
		// String B = "git";
		String A = "evcorexgrtxuqzckuhrykdvtndpaynlphnprygrcgetlmpehvfprgohuxfdqqftyfnobzvnqhhlwmzfydwlxwtgrrmobnkdkweljexlkupydkwfpqjhjgifshrxdxxwzxatjtpkwymnfulvbojshogdjtdgznglkouoahkberfcqwysknktkghwoacbpxaubqddoiykapyqiaqezgnqhacabhgvvpwvxxgfhdrmevbjnmeqrcawumooacazxqtgezwitocfyhlarshrqsngflctvverpemvevjrcjdmsnrwqujuiihiqmjwhuxktjvsthmvofzmbgrfecinxktjphgnygkzbehbbuzwnuqkxqbcrdycbrqmfoxapsqosslgiufmdowmmxivfevuhxdpwmnldigrnmoxyvqndtryaamvvhqmugczfrayeuhxkhyjkwzwnyfmzdcbtgstszjuknmjykwkmytrijflyybevzhyjqfngejtakoqsjusvmzmekdedxsmaasuntulkwsrjxbddfztnkmuoimagdonzkqlvrbjqtnwrj";
		String B = "coxqgkybvsucwnhgesscmotgykojfzx";
		ShrtestSubstringarray s = new ShrtestSubstringarray();
		System.out.println(s.shortestSubstring(A, B));
	}

}
