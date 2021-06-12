package com.hackerearth.greedy;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MotuPatlu {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int ii = 0;
		while(ii<t){
			int n = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			int countM = 0;
			int countP = 0;
			int indxM = 0;
			int indxP = n-1;
			arr[n-1] = arr[n-1]*2;
			int timerM = 0;
			int timerP = 0;
			int prevP = 0;
//			System.out.println(indxP);
			while(indxM<=indxP) {
//				System.out.println(indxP+" ::indxP    indxM:: " +indxM);
				if (indxM == indxP){
//					System.out.println("index of both of themm are equal!!! ");
//					System.out.println("timerP >> "+timerP);
					if(timerP>0) {
						countP++;
					} else{
						countM++;
					}
					break;
				}else{
					if (timerM == arr[indxM]) {
						countM++;
						indxM++;
						timerM=0;
					} else {
						timerM++;
					}
					if (timerP == arr[indxP]) {
						countP++;
						indxP--;
						arr[indxP] = arr[indxP]*2;
						timerP=0;
					} else {
						timerP++;
					}
				}
//				System.out.println("timerM :: "+timerM);
//				System.out.println("timerP :: "+timerP);
				
				
//				Thread.sleep(1000);
//				System.out.println("M >>>> "+countM);
//				System.out.println("P >>>> "+countP);
				
			}
			System.out.println(countM+" "+countP);
			if (countM>countP) {
				System.out.println("Motu");
			} else if(countM<countP){
				System.out.println("Patlu");
			} else{
				System.out.println("Tie");
			}
			ii++;
		}
	}
}
