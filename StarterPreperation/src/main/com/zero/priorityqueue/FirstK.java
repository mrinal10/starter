package com.zero.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FirstK {
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] p;
	static int lvl=0;
	void firstKHlpr(int level, int curVal){
		if(level>10 || pq.size()>lvl){
			return;
		}
		if(level==lvl){
			return;
		}
		for (int i = 0; i < p.length; i++) {
			int temp = curVal*p[i];
			if (!pq.contains(temp)) {
				pq.add(temp);
			}
			firstKHlpr(level+1, curVal*p[i]);
		}
	}
	
	List<Integer> firstK(int p1, int p2, int p3, int k) {
		lvl = k;
		p = new int[3];
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		Arrays.sort(p);
      	List<Integer> list = new ArrayList<Integer>();
        firstKHlpr(0, 1);
        for (int i = 0; i < k; i++) {
			list.add(pq.poll());
		}
        return list;
    }
	
	public static void main(String[] args) {
		FirstK kk = new FirstK();
		List<Integer> allList = kk.firstK(3, 11, 7, 50);
		for (int i = 0; i < 50; i++) {
			System.out.print(allList.get(i)+" ");
		}
	}

}
