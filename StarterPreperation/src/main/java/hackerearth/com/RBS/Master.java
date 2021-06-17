package com.RBS;

import java.util.List;


public class Master {
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
