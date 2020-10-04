package com.contest.techgig;

import java.util.List;

public class MakeItConsistent {
	public static void main(String[] args) {
		
	}
	
	//Rule 1. All the function must have open bracket “{“at the same line without any space.
	private static boolean isOpenBracketinOpeningLine(List<String> lineList) {
		String startLine = lineList.get(0);
		if (startLine.endsWith("{")) {
			int len = startLine.length();
			if(startLine.charAt(len-2)==' ') {
				return true;
			}
		}else {
			System.out.println("Invalid Ending ");
		}
		return false;
	}
	//Rule 2. Closing bracket “}” for any function should be vertically aligned with the start letter of the function.
	private static boolean isEndingVerticallyAligned(List<String> lineList) {
		String startLine = lineList.get(0);
		String endLine = lineList.get(lineList.size()-1);
		if (startLine.endsWith("{")) {
			int len = startLine.length();
			if(startLine.charAt(len-2)==' ') {
				return true;
			}
		}else {
			System.out.println("Invalid Ending ");
		}
		return false;
	}
	//Rule 3. Comparison with any constant values should be on the right-hand side in if statement.
	
	//Rule 4. Whole code should be indented, and indentation will follow rules 1tab = 4 spaces.
	
	//Rule 5: There should not be any heading and trailing white spaces.
	
	
}
