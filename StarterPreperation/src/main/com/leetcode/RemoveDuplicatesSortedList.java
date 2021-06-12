package com.leetcode;

public class RemoveDuplicatesSortedList {

	public static void main(String[] args) {

	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode fast = head.next;
        while(cur!=null && fast!=null){
        	if (cur.val == fast.val) {
                cur.next = fast.next;
            }else{
                cur = cur.next;
            }
            fast = fast.next;
        }
        return head;
    }
    
    

}
