package com.RBS;

class TestClass {
    private static final String FILENAME = "C:\\Users\\MRINAL\\Desktop\\result.txt";

	public static void main(String[] args){
		DataExtractor de = new DataExtractor(FILENAME); 
		de.gettopTenStudents();
	}
}