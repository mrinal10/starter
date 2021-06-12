package com.RBS.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class TestClass1 {
	private static final String FILENAME = "C:\\Users\\MRINAL\\Desktop\\result.txt";

	public static void main(String[] args){
		DataExtractor de = new DataExtractor(FILENAME); 
		de.gettopTenStudents();
	}
}

class Master {
	private String name;
	private String uID;
	private String dOB;
	private String gender;
	private String TOE;
	private String resultStatus;
	private StringPair subjectdetails;	
	public StringPair getSubjectdetails() {
		return subjectdetails;
	}

	public void setSubjectdetails(StringPair subjectdetails) {
		this.subjectdetails = subjectdetails;
	}

	private String NTY;
	private String SCD;
	private String Res_ID;	
	private String motherName;
	private String fatherName;
	
	private List<StringPair> subjectList;
	
	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getTOE() {
		return TOE;
	}

	public void setTOE(String tOE) {
		TOE = tOE;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNTY() {
		return NTY;
	}

	public void setNTY(String nTY) {
		NTY = nTY;
	}

	public String getSCD() {
		return SCD;
	}

	public void setSCD(String sCD) {
		SCD = sCD;
	}

	public String getRes_ID() {
		return Res_ID;
	}

	public void setRes_ID(String res_ID) {
		Res_ID = res_ID;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public List<StringPair> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<StringPair> subjectList) {
		this.subjectList = subjectList;
	}
}


class DataProcessor {
	
	public static List<Master> returnObjList(String FILENAME){
		BufferedReader br = null;
		FileReader fr = null;
		List<StringPair> subjectPairs = null;
		List<Master> objList = new ArrayList<Master>();
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			String[] sCurrentLineArr = null;
			
			String name;
			String uID;
			String dOB;
			String gender;
			String NTY;
			String SCD;
			String Res_ID;
			
			String motherName;
			String fatherName;
			String TOE;
			
			
			int lNo = 0;
			int lineNo = -1;
			int objCount = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				lineNo++;
				lNo = lineNo%4;
				if (lineNo!=0) {
					if (lNo==1) {
						subjectPairs = new ArrayList<StringPair>();
						
						
						objList.add(new Master());
						objCount++;	
						sCurrentLineArr = sCurrentLine.split(" ");
						//System.out.println(sCurrentLine);
						uID = sCurrentLineArr[0];
						//System.out.println(objList.get(objCount-1)+"::uID ::"+uID);
						objList.get(objCount-1).setuID(uID);
						name = sCurrentLineArr[1]+" "+sCurrentLineArr[2];
						objList.get(objCount-1).setName(name);
						dOB = sCurrentLineArr[3];
						objList.get(objCount-1).setdOB(dOB);
						gender = sCurrentLineArr[4];
						objList.get(objCount-1).setGender(gender);
						TOE = sCurrentLineArr[5];
						objList.get(objCount-1).setTOE(TOE);
						NTY = sCurrentLineArr[6];
						objList.get(objCount-1).setNTY(NTY);
						SCD = sCurrentLineArr[7];
						objList.get(objCount-1).setSCD(SCD);
						try {
							Res_ID = sCurrentLineArr[10];
							objList.get(objCount-1).setRes_ID(Res_ID);
						} catch (Exception e) {
						} finally {
							
						}
					} else if(lNo == 2){
						sCurrentLine=sCurrentLine.replace(" - ", "-");
						//System.out.println(sCurrentLine);
						sCurrentLineArr = sCurrentLine.split(" ");
						int j = 0;
						for (int i = 0; i < sCurrentLineArr.length-2; i++) {
							
							String[] subjL = sCurrentLineArr[i].split("-");
							subjectPairs.add(new StringPair());
							if (subjL.length==1) {
								String[] subjL1 = sCurrentLineArr[i+1].split("-");
								subjectPairs.get(j).setSubjectName(subjL[0]+" "+subjL1[0]);
								subjectPairs.get(j).setGrade(subjL1[1]);
								subjectPairs.get(j).setPercentage(Integer.parseInt(subjL1[2]));
								i++;
							}else{
								subjectPairs.get(j).setSubjectName(subjL[0]);
								subjectPairs.get(j).setGrade(subjL[1]);
								subjectPairs.get(j).setPercentage(Integer.parseInt(subjL[2]));
							}
							j++;
						}
						//System.out.println("objCount :: "+objCount);
						objList.get(objCount-1).setSubjectList(subjectPairs);
						for (int i = sCurrentLineArr.length-2; i < sCurrentLineArr.length; i++) {
							if (i == sCurrentLineArr.length-1) {
								objList.get(objCount-1).setResultStatus(sCurrentLineArr[sCurrentLineArr.length-1]);
							}else{
								StringPair pair = new StringPair();
								pair.setSubjectName(sCurrentLineArr[sCurrentLineArr.length-2].split(":")[0]);
								pair.setGrade(sCurrentLineArr[sCurrentLineArr.length-2].split(":")[1]);
								objList.get(objCount-1).setSubjectdetails(pair);;
							}
							j++;
						}
						
					}  else if(lNo == 3){
						sCurrentLine=sCurrentLine.replace("/ ", "/");
						//System.out.println(sCurrentLine);
						sCurrentLineArr = sCurrentLine.split(" ");
						fatherName = sCurrentLine.substring(sCurrentLine.indexOf("of ")+3, sCurrentLine.length()).trim();
						motherName = fatherName.split("and")[0].trim();
						fatherName = fatherName.split("and")[1].trim();
						objList.get(objCount-1).setFatherName(fatherName);
						objList.get(objCount-1).setMotherName(motherName);
					}
									
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
		return objList;
	}
}

class Max10Bean {
	String name;
	String UID;
	int number;
	int rank;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}


class max10comparator implements Comparator<Max10Bean>{
	@Override
	public int compare(Max10Bean o1, Max10Bean o2) {
	    if(o1.getNumber()<o2.getNumber()){
	    	return 1;
	    } else if(o1.getNumber()==o2.getNumber()){
	    	return 0;
	    }
	    return -1;
	}

}


class DataExtractor {
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
			try {
				data1.add(new Max10Bean());
				Master master = (Master) iterator.next();
				int requiredMarks = getmarksinENGand4Subjects(master.getSubjectList());
				data1.get(i).setNumber(requiredMarks);
				data1.get(i).setName(master.getName());
				data1.get(i).setUID(master.getuID());
			} catch (Exception e) {
			}
			i++;
		}
		Collections.sort(data1, new max10comparator());
		int rank = 1;
		int numberob = 10000;
		for (int j = 0; j < 10; j++) {
			try {
				System.out.println(data1.get(j).getUID()+","+data1.get(j).getName()+","+rank);
				if (data1.get(j).getNumber()<numberob) {
					numberob = data1.get(j).getNumber(); 
					rank++;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public int getmarksinENGand4Subjects(List<StringPair> subjL){
		int marksinEnglish=0;
		try {
			List<Integer> subL = new ArrayList<Integer>();
			for (Iterator<StringPair> iterator = subjL.iterator(); iterator.hasNext();) {
				StringPair stringPair = (StringPair) iterator.next();
//				if(stringPair.getSubjectName().equalsIgnoreCase("ENG")){
//					marksinEnglish = stringPair.getPercentage(); 
//				} else {
					subL.add(stringPair.getPercentage());
			//	}			
			}
			Collections.sort(subL);
			for (int i = 0; i < subL.size(); i++) {
				marksinEnglish += subL.get(i); 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return marksinEnglish;
	}
}


class StringPair {
	private String subjectName;
	private String grade;
	private int Percentage;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPercentage() {
		return Percentage;
	}
	public void setPercentage(int percentage) {
		Percentage = percentage;
	}	
}

