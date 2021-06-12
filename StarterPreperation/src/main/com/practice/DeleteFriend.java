package com.practice;

import java.util.LinkedList;
import java.util.Scanner;

public class DeleteFriend {
	

	
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int numFriend = sc.nextInt();
			int friendstoDelete = sc.nextInt();
			
			LinkedList<Integer> friendsLinkedList = new LinkedList<>();
			for (int j = 0; j < numFriend; j++) {
				friendsLinkedList.add(sc.nextInt());
			}
			
			int count = 0;
			while (count<friendstoDelete) {
				int initValue = friendsLinkedList.get(0);
				boolean flag = false;
				for (int j = 1; j < friendsLinkedList.size() && count<friendstoDelete; j++) {
					
					if (initValue<friendsLinkedList.get(j)) {
						
//						System.out.println("Removed :: "+friendsLinkedList.get(j-1));
						friendsLinkedList.remove(j-1);
						initValue = friendsLinkedList.get(j-1);
						count++;
						flag = true;
					}else{
						initValue = friendsLinkedList.get(j);
					}
				}
				if (!flag && count<friendstoDelete) {
//					System.out.println("Removed Last :: "+friendsLinkedList.get(friendsLinkedList.size()-1));
					friendsLinkedList.remove(friendsLinkedList.size()-1);
					count++;
				}
			}
			
			for (int j = 0; j < friendsLinkedList.size(); j++) {
				System.out.print(friendsLinkedList.get(j)+" ");
			}
		}
		sc.close();
	}
}
