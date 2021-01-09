package com.hackerrank.problemsolving.linkedlist;

class RemoveDuplicates {
    class SinglyLinkedListNode {
             int data;
             SinglyLinkedListNode next;
         }
        
       static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
           SinglyLinkedListNode cur = head;
           while(cur!=null){
               while(cur.next!=null && cur.data == cur.next.data){
                   cur.next = cur.next.next;
               }
               cur=cur.next;
           }
           return head;
       }
}
