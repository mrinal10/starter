package com.java8;

import java.util.ArrayList;
import java.util.List;

class User{
	private String userName;
	private String userId;
	private Integer salary;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
public class TestSet {
	public static void main(String[] args) {
		User user1 = new User();
		user1.setUserName("Mrinal");
		user1.setUserId("u1");
		user1.setSalary(400);
		
		User user2 = new User();
		user2.setUserName("Mrinal2");
		user2.setUserId("u2");
		user2.setSalary(4000);
		
		User user3 = new User();
		user3.setUserName("Mrinal3");
		user3.setUserId("u3");
		user3.setSalary(4008);
		
		List<User> userList = new ArrayList<>();
		
	}
}
