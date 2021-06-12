package com.hiring.hsbc22062019;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList1 extends Thread{
	static CopyOnWriteArrayList hck = new CopyOnWriteArrayList(); 
	  
    public void testhack() 
    { 
        hck.add("K"); 
    } 
    
//     public static void main(String[] args) 
//        throws InterruptedException 
//    { 
//        hck.add("H"); 
//        hck.add("A"); 
//        hck.add("C"); 
//        CopyOnWriteArrayList1 t = new CopyOnWriteArrayList1(); 
//        t.testhack(); 
//  
//        Thread.sleep(1000); 
//        Iterator test1 = hck.iterator(); 
//        while (test1.hasNext()) { 
//            String s = (String)test1.next(); 
//            System.out.println(s); 
//            Thread.sleep(1000); 
//        } 
//        System.out.println(hck); 
//    }
    
    public static void main(String args[]) {
        Thread t = Thread.currentThread();
        System.out.println(t);        
    }

}
