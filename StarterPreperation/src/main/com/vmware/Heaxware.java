package com.vmware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MultiValueMap{
	private String key;
	private List<Integer> multiList;
	
	public void addList(int value){
		multiList.add(value);
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Integer> getMultiList() {
		return multiList;
	}
	public void setMultiList(List<Integer> multiList) {
		this.multiList = multiList;
	}
}

public class Heaxware {

	static HashMap<String, MultiValueMap> multiMapListX = new HashMap<String, MultiValueMap>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalNumbPSpace = sc.nextInt();
		
		int row = sc.nextInt();
		int column = sc.nextInt();
		column = 5;
		
		for (int i = 0; i < row; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int price = sc.nextInt();
			
			for (int j = x1; j <= x2; j++) {
				for (int j2 = y1; j2 <= y2; j2++) {
					String key = String.valueOf(j)+","+String.valueOf(j2);
					if (multiMapListX.get(key) != null) {
						MultiValueMap map = multiMapListX.get(key);
						
						map.addList(price);
					} else {
						MultiValueMap map = new MultiValueMap();
						map.setKey(key);
						List<Integer> multiList = new ArrayList<Integer>();
						multiList.add(price);
						map.setMultiList(multiList);
					}
				}
			}
			int count = 0;
	        for (Map.Entry<String,MultiValueMap> entry : multiMapListX.entrySet()) {
	            MultiValueMap map = entry.getValue();
	            List<Integer> list  = map.getMultiList();
	            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					count += integer;
				}
			}
		
			System.out.println(count);
		}
	}

}
