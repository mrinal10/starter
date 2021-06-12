package com.interviewbit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class PrimefACTORIZATION {
	private static Set<Integer> getPrimeFactors(int n){
		SortedSet<Integer> factorSet = new TreeSet<>();
		for(int  i=2; i<=n/2; i++){
			if(n%i == 0 && isPrime(i)){
				factorSet.add(i);
			}
		}
	    factorSet = new TreeSet<Integer>(factorSet).descendingSet();
		return factorSet;
	}
	
	private static boolean isPrime(int n){
		for(int  i=2; i<Math.sqrt(n); i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
	
	private static int Operate(HashMap<Integer, Integer> intMap, int n, int k){
		Set<Integer> primeFactorSet = getPrimeFactors(n);
		Iterator<Integer> it = primeFactorSet.iterator();
		while(it.hasNext()){
			int curV = it.next();
			int countMod = 0;
			for(Entry<Integer, Integer> entry : intMap.entrySet()){
				int value = entry.getValue();
				countMod = countMod+(curV-value);
			}
			
			if(k >= countMod){
				return curV;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i = 0;i < n; i++){
				arr[i] = sc.nextInt();
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i = 0;i < n; i++){
				int cnt = 1;
				if(map.containsKey(arr[i])){
					cnt += map.get(arr[i]);
				}
				map.put(arr[i], cnt);
			}
			
			System.out.println(Operate(map, n, k));
		}
		sc.close();
	}
	
}
