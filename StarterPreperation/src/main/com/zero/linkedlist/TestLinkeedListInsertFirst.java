package com.zero.linkedlist;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class LinkedListFunctions
{
	void printList(LLNode head)
    {
        LLNode temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	LLNode insertInBeginning(LLNode head, int data)
    {
        LLNode newNode = new LLNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }
}
public class TestLinkeedListInsertFirst
{
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
      	LinkedListFunctions llf = new LinkedListFunctions();
      	while(t--!=0)
        {
          LLNode head = null;
          int n = sc.nextInt();
          while(n--!=0){
              head = llf.insertInBeginning(head, sc.nextInt());
          }
          llf.printList(head);
        }
    }
}