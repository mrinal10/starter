package com.greedy.activityselection;

import java.util.Arrays;
import java.util.Scanner;

public class RoomsSoln {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t!=0){
            t--;
	        int n=sc.nextInt();
	        long startTimeArray[] = new long[n];
	        long departureTime[] = new long[n];
	        for(int i=0;i<n;i++){
	            startTimeArray[i]=sc.nextLong();
	        }
	        for(int i=0;i<n;i++){
	            departureTime[i]=startTimeArray[i]+sc.nextLong();
	        }
	        Arrays.sort(startTimeArray);
	        Arrays.sort(departureTime);
	        int i=0;
	        int j=0;
	        int ans=0;
	        int count=0;
	        while(i<n && j<n){
	        	System.out.println("startTimeArray[i] :: "+startTimeArray[i]);
	        	System.out.println("departureTime[j] :: "+departureTime[j]);
	        	if(startTimeArray[i]<departureTime[j]){
		            count++;
		            if(count>ans) {
			            ans=count;
		            }
		            i++;
	            }
	            else{
	                count--;
	                j++;
	            }
	        	System.out.println("count :: "+count);
	        }
	        System.out.println(ans);
        }
        sc.close();
    }
}