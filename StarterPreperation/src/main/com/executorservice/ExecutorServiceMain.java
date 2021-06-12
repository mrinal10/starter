package com.executorservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMain {
	public static void main(String[] args) {
		String[] allSites = {"http://www.google.com", "http://www.facebook.com", "http://www.netflix.com"};
        ExecutorService executor = Executors.newFixedThreadPool(allSites.length);  
        List<Future<String>> list = new ArrayList<Future<String>>();
        
        for(int i=0; i< allSites.length; i++){
        	CallableImpl callable = new CallableImpl(allSites[i]);
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                System.out.println(new Date()+ "::"+fut.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
	}
}
