package com.RBS;

import java.util.Comparator;

public class max10comparator implements Comparator<Max10Bean>{
	@Override
	public int compare(Max10Bean o1, Max10Bean o2) {
	    if(o1.getNumber()<o2.getNumber()){
	    	return 1;
	    } else if(o1.getNumber()==o2.getNumber()){
	    	return 0;
	    }
	    return -1;
	}
}
