package com.zero.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PasswordGuessing {

	static Set<String> allPasswords = new HashSet<>();

	private static void genPass(char[] derivedPwd, int i) {
		String pwd = "";
		for (int j = 0; j < derivedPwd.length; j++) {
			pwd += derivedPwd[j];
		}
		allPasswords.add(pwd);

		if (i >= derivedPwd.length) {
			return;
		}
		if (((int) derivedPwd[i] >= 97 && (int) derivedPwd[i] <= 122)) {
			genPass(derivedPwd, i + 1);
			derivedPwd[i] = (char) (derivedPwd[i] - 32);
			genPass(derivedPwd, i + 1);
		} else if (((int) derivedPwd[i] >= 65 && (int) derivedPwd[i] <= 90)) {
			genPass(derivedPwd, i + 1);
			derivedPwd[i] = (char) (derivedPwd[i] + 32);
			genPass(derivedPwd, i + 1);
		} else {
			genPass(derivedPwd, i + 1);
		}
	}

	private static void passwordGen(char[] pwd) {
		genPass(pwd, 0);
		List<String> passWordList = new ArrayList<>();
		for (Iterator<String> passWorditr = allPasswords.iterator(); passWorditr.hasNext();) {
			String uniquePwd = passWorditr.next();
			passWordList.add(uniquePwd);
		}
		Collections.sort(passWordList);
		Collections.reverse(passWordList);
		for (Iterator<String> iterator = passWordList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			String password = sc.next();
			passwordGen(password.toCharArray());
		}
		sc.close();
	}

}
