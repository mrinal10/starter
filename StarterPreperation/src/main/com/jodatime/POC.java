package com.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class POC {
	public static void main(String[] args) {
		DateTimeZone localTimeZone = DateTimeZone.forID("Asia/Kolkata");
		 
		DateTime utcTime = new DateTime(2018, 02, 24, 11, 40,
		        DateTimeZone.UTC);
		DateTime localTime = utcTime.withZone(localTimeZone);
		         
		System.out.println(utcTime);
		System.out.println(localTime);
	}
}
