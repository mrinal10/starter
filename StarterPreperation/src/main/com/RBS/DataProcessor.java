package com.RBS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
	
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
