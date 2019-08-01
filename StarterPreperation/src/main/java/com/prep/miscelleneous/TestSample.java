package com.prep.miscelleneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSample {

	public static void main(String[] args) {

		// DataBase Configurations
		Map<String, Object> environmentMap = new HashMap<>();
		environmentMap.put("QA", (Object) "[fxbs9, fxbs9]");
		environmentMap.put("Test",
				(Object) "[qxbs2, qxbs2, gxbs1, gxbs1, qxbs1, qxbs1, pxcf1, pxcf1, uxbs2, uxbs2, hxbs2, hxbs2, hxbs3, hxbs3, qxbs1s, qxbs1s, qxbs3, qxbs3, uxbs1, uxbs1]");
		environmentMap.put("Dev",
				(Object) "[dxbs1, dxbs1, bxbs1, bxbs1, dxbs3, dxbs3, dxbs4, dxbs4, qxbs5, qxbs5, dxbs8, dxbs8, gxbs3, gxbs3, axbs1, axbs1, dxbs7, dxbs7, hxbs4, hxbs4, uxbs5, uxbs5, dxbs2, dxbs2]");
		environmentMap.put("Prod", (Object) "[pxbs1, pxbs1]");

		//Search Params
		String environmentNameToSearch = "Test";
		String dbNameToSearch = "gxbs1";
		
		
		
		boolean dbFound = false;
		if (!environmentMap.containsKey(environmentNameToSearch)) {
			System.out.println("Invalid Environment");
		} else {
			String dbNames = (String) environmentMap.get(environmentNameToSearch);
			String[] dbName = dbNames.substring(1, dbNames.length() - 1).split(",");
			List<String> dbNamesList = Arrays.asList(dbName);
			for(String dbNam : dbNamesList) {
				if (dbNam.trim().equals(dbNameToSearch)) {
					System.out.println("DB Found");
					dbFound = true;
					break;
				}
			}
			if(!dbFound)
				System.out.println("This DB doesn't exists");
		}
	}
}