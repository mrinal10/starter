package com.practice.optum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
	public static void main(String[] args) {
				
		List<String> inp = Arrays.asList("# Cars", "Cars came into global use during the 20th century", "Most definitions of car say they run primarily on roads",
		"## Sedan", "Sedan's first recorded use as a name for a car body was in 1912",			
		"## Coupe", "A coupe is a passenger car with a sloping rear roofline and generally two doors",			
		"## SUV", "The predecessors to SUVs date back to military and low-volume models from the late 1930s",			
		"There is no commonly agreed definition of an SUV, and usage varies between countries",
		"# Bus", "## Traveller");
		
		List<String> arr = tableOfContents(inp);
		for(String s : arr) {
			System.out.println(s);
		}
	}
	
	public static List<String> tableOfContents(List<String> lines) {
		List<String> output = new ArrayList<String>();
		int chapterNumber = 0;
		int verseNumber = 0;
		for(int i=0; i<lines.size(); i++) {
			if(lines.get(i).startsWith("##")) {
				verseNumber++;
				output.add(chapterNumber+"."+verseNumber+". "+lines.get(i).substring(3, lines.get(i).length()));
			} else if(lines.get(i).startsWith("#")) { //chapter
				verseNumber = 0;
				chapterNumber++;
				output.add(chapterNumber+". "+lines.get(i).substring(2, lines.get(i).length()));
			}
		}
		return output;
	}
}
