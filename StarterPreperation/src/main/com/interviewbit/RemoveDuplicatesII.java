package com.interviewbit;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RemoveDuplicatesII {
	public ListNode deleteDuplicates(ListNode A) {
		if(A==null){
			return A;
		}
		
		ListNode newH = null;
		ListNode newPtr = A;

		Map<Integer, Integer> map = new LinkedHashMap();
		while(newPtr!=null){
			int cnt = 1;
			if(map.containsKey(newPtr.val)){
				cnt = map.get(newPtr.val);
				cnt++;
			}
			map.put(newPtr.val, cnt);
			newPtr = newPtr.next;
		}
		PriorityQueue<Integer> intPQ = new PriorityQueue<>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue()==1){
				intPQ.add(entry.getKey());
			}
		}
		ListNode cur = null;
		while (!intPQ.isEmpty()) {
			int vv = intPQ.poll();
			cur = new ListNode(vv);
			if(newH==null){
				newH = cur;
				newPtr = newH;
			}else{
				ListNode newNode = new ListNode(vv);
				newPtr.next = newNode;
				newPtr = newPtr.next;
			}
		}
		
		return newH;
    }
	
	
	public static void main(String[] args) {
		ListNode st = new ListNode(2);
		ListNode st2 = new ListNode(2);
		st.next = st2;
		ListNode st3 = new ListNode(2);
		st2.next = st3;
		ListNode st4 = new ListNode(3);
		st3.next = st4;
		ListNode st5 = new ListNode(4);
		st4.next = st5;
		RemoveDuplicatesII palinLL = new RemoveDuplicatesII();
		ListNode newHd = palinLL.deleteDuplicates(st);
		while (newHd!=null) {
			System.out.print(newHd.val+" .. ");
			newHd = newHd.next;
		}
}
}
