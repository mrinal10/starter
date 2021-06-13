package com.java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestStream {
	private static String servicingProviderName;
	public static void main(String[] args) {
		servicingProviderName = "MATTHEW null SIMONS";
		System.out.println(getServicingProviderName());
	}	
	
	public static String getServicingProviderName() {
		String[] proViderName = servicingProviderName.split(" "); 
		return String.join(" ", Arrays.asList(proViderName).stream()
				.filter(line -> !"null".equals(line)).collect(Collectors.toList()));
	}
	
	
	private String getNullOmittedValue(String toBeFiltered) {
		String[] valueArr = toBeFiltered.split(" "); 
		return  String.join(" ", Arrays.asList(valueArr).stream()
				.filter(line -> !"null".equals(line)).collect(Collectors.toList()));
	}
}
