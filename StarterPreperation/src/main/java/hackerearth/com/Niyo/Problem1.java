package com.Niyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class MobileBean {
	private String OperatingSystem;
	private int ram, memorySpace, price, rating;
	
	public MobileBean(String Os, int r, int m, int p, int ratin) {
		OperatingSystem = Os;
		ram = r;
		memorySpace = m;
		price = p;
		rating = ratin;
	}
	
	public String getOperatingSystem() {
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getMemorySpace() {
		return memorySpace;
	}
	public void setMemorySpace(int memorySpace) {
		this.memorySpace = memorySpace;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}

class RatingComparator implements Comparator<MobileBean>{  
	public int compare(MobileBean o1,MobileBean o2){  
		MobileBean m1=(MobileBean)o1;  
		MobileBean m2=(MobileBean)o2;  
		  
		if(m1.getRating()==m2.getRating())  
			return 0;  
		else if(m1.getRating() > m2.getRating())  
			return 1;  
		else  
			return -1;  
	}  
}  

class PriceComparator implements Comparator<MobileBean>{  
	public int compare(MobileBean o1,MobileBean o2){  
		MobileBean m1=(MobileBean)o1;  
		MobileBean m2=(MobileBean)o2;  
		  
		if(m1.getPrice()==m2.getPrice())  
			return 0;  
		else if(m1.getPrice() > m2.getPrice())  
			return 1;  
		else  
			return -1;  
	}  
}

class MemoryComparator implements Comparator<MobileBean>{  
	public int compare(MobileBean o1,MobileBean o2){  
		MobileBean m1=(MobileBean)o1;  
		MobileBean m2=(MobileBean)o2;  
		  
		if(m1.getMemorySpace()==m2.getMemorySpace())  
			return 0;  
		else if(m1.getMemorySpace() > m2.getMemorySpace())  
			return 1;  
		else  
			return -1;  
	}  
}

class RamComparator implements Comparator<MobileBean>{  
	public int compare(MobileBean o1,MobileBean o2){  
		MobileBean m1=(MobileBean)o1;  
		MobileBean m2=(MobileBean)o2;  
		  
		if(m1.getRam() == m2.getRam() )  
			return 0;  
		else if(m1.getRam() > m2.getRam() )  
			return 1;  
		else  
			return -1;  
	}  
} 


public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<MobileBean> mobileList = new ArrayList<MobileBean>();
		for (int i = 0; i < n; i++) {
			try {
				
				String osName = sc.next();
				int ram = sc.nextInt();
				int memory = sc.nextInt();
				int price = sc.nextInt();
				int rating = sc.nextInt();
				
				mobileList.add(new MobileBean(osName, ram, memory, price, rating));

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		filteringData(mobileList);
		
		sc.close();
	}
	
	private static void filteringData(List<MobileBean> mArr) {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		for (int j = 0; j < nn; j++) {
			try {
				
				String OSNAME = sc.next();
				int ram = sc.nextInt();
				int mem = sc.nextInt();
				int price = sc.nextInt();
				
				ArrayList<MobileBean> mBwan = new ArrayList<MobileBean>();
				for (int i = 0; i < mArr.size(); i++) {
					MobileBean temp = mArr.get(i);
					if (temp.getPrice()<=price && temp.getRam()>=ram && temp.getMemorySpace()>=mem 
							&& temp.getOperatingSystem().equals(OSNAME)) {
						mBwan.add(temp);
					}
				}
				if (mBwan.size()>0) {
					Collections.sort(mBwan, new RatingComparator());
					System.out.println(mBwan.get(0).getRating());
				} else {
					System.out.println("-1");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sc.close();
	}
}
