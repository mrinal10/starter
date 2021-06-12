package com.pramata.hiring03082018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Users{
	private int totalScore;
	private int totalSubmissionTime;
	private String name;
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getTotalSubmissionTime() {
		return totalSubmissionTime;
	}
	public void setTotalSubmissionTime(int totalSubmissionTime) {
		this.totalSubmissionTime = totalSubmissionTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


class SortSubmissions implements Comparator<Users>{

	@Override
	public int compare(Users o1, Users o2) {
		if(o1.getTotalScore()==o2.getTotalScore()){
			if(o1.getTotalSubmissionTime()==o2.getTotalSubmissionTime()){ 
				return o1.getName().compareTo(o2.getName());  
			}
			else if(o1.getTotalSubmissionTime()<o2.getTotalSubmissionTime())  
				return -1;  
			else  
				return 1;
		}else if(o1.getTotalScore()>o2.getTotalScore())  
			return -1;  
		else  
			return 1;  
	}
	
}



public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Users> userMap = new HashMap<>();
			
		int numOfSubmissions = sc.nextInt();
		while (numOfSubmissions-->0) {
			String userName = sc.next();
			int sbmissionTym = sc.nextInt();
			if (userMap.containsKey(userName)) {
				int userScore = userMap.get(userName).getTotalScore();
				userScore+=100;
				int userSubmissionTym = userMap.get(userName).getTotalSubmissionTime();
				userSubmissionTym += sbmissionTym;
				Users user = userMap.get(userName);
				user.setTotalScore(userScore);
				user.setTotalSubmissionTime(userSubmissionTym);
			}else{
				Users user = new Users();
				user.setName(userName);
				user.setTotalScore(100);
				user.setTotalSubmissionTime(sbmissionTym);
				userMap.put(userName, user);
			}
		}
		List<Users> allUserSubmission = new ArrayList<Users> (userMap.values());
		Collections.sort(allUserSubmission, new SortSubmissions());
		int rank = 1;
		for (Iterator<Users> iterator = allUserSubmission.iterator(); iterator.hasNext();) {
			Users users = iterator.next();
			System.out.println(rank+" "+users.getName());
			rank++;
		}
		sc.close();
	}
}
