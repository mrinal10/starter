package com.RBS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DataExtractor {
	private String dataPath;
	private List<Master> list;
	public DataExtractor(String FILENAME) {
		dataPath = FILENAME;
		list = DataProcessor.returnObjList(dataPath);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Master master = (Master) iterator.next();
		}
	} 
	
	public void gettopTenStudents(){
		List<Max10Bean> data1 = new ArrayList<Max10Bean>();
		int i=0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			data1.add(new Max10Bean());
			Master master = (Master) iterator.next();
			int requiredMarks = getmarksinENGand4Subjects(master.getSubjectList());
			data1.get(i).setNumber(requiredMarks);
			data1.get(i).setName(master.getName());
			data1.get(i).setUID(master.getuID());			
			i++;
		}
		Collections.sort(data1, new max10comparator());
		int rank = 1;
		int numberob = 10000;
		for (int j = 0; j < 10; j++) {
			System.out.println(data1.get(j).getUID()+","+data1.get(j).getName()+","+rank);
			if (data1.get(j).getNumber()<numberob) {
				numberob = data1.get(j).getNumber(); 
				rank++;
			}
		}
	}
	
	public int getmarksinENGand4Subjects(List<StringPair> subjL){
		int marksinEnglish=0;
		List<Integer> subL = new ArrayList<Integer>();
		for (Iterator<StringPair> iterator = subjL.iterator(); iterator.hasNext();) {
			StringPair stringPair = (StringPair) iterator.next();
			if(stringPair.getSubjectName().equalsIgnoreCase("ENG")){
				marksinEnglish = stringPair.getPercentage(); 
			} else {
				subL.add(stringPair.getPercentage());
			}			
		}
		Collections.sort(subL);
		for (int i = 1; i < subL.size(); i++) {
			marksinEnglish += subL.get(i); 
		} 
		return marksinEnglish;
	}
}
