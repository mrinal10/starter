package com.Bima;
//
////public class TestClass1 {
////	static String value = "testify";
////    static int value1=25;
////    static {
////        value1=50;
////        System.out.println(value);
////    System.out.println(value1); }
////    public static void main(String args[])
////    { 
////    	
////    	
////    }
////    {
////        System.out.println("value");
////    }
////}
//
//
////abstract class A1 {
////    protected int i;
////    abstract void display();
////}    
////class B1 extends A1 {
////    int j=30;
////    void display() {
////        int j=10;
////        System.out.println(j);
////    }
////}    
////public class TestClass1 {
////    public static void main(String args[])
////    {
////        B1 obj = new B1();
////        obj.j=20;
////        obj.display();    
////    }
////}
//
//
//class TestClass1 
//{
////    public static void main(String [] args) 
////    {
////    	TestClass1 p = new TestClass1();
////        p.start();
////    }
//
//    void start() 
//    {
//        String s1 = "step";
//        String s2 = fix(s1);
//        System.out.println(s1 + " " + s2);
//    }
//
//    String fix(String s1) 
//    {
//        s1 = s1 + "steem";
//        System.out.print(s1 + " ");
//        return "steem";
//    }
//}


import java.util.Scanner;

class TestClass1 {
    public static void main(String args[] ) throws Exception {
    	Scanner s = new Scanner(System.in);
    	try {
		    int N = s.nextInt();
	        int[] ar = new int[N];
	        int Q = s.nextInt();
	        for (int i = 0; i < Q; i++) {
	        	int X = s.nextInt();
	        	if(allocate(ar,X)){
	        		System.out.println("YES");
	        	}else{
	        		System.out.println("NO");
	        	}
	        }
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			s.close();
		}
    }
    
    private static boolean allocate(int[] ar, int val){
    	try {
			
    	
	    	int startPoint = findmin(ar.length,val);
	    	startPoint = startPoint-1;
	    	for (int i = startPoint; i < ar.length; i++) {
				if (ar[i]==findmin(ar[i],val)) {
					ar[i]=val;
					return true;
				}
			}
	    	for (int i = 0; i < val; i++) {
	    		if(ar[i]==val){
	    			return false;
	    		}
	    		if (ar[i]==findmin(ar[i],val)) {
					ar[i]=val;
					return true;
				}
	    	}

		} catch (Exception e) {
			// TODO: handle exception
		}
    	return false;
    }
    
    private static int findmin(int a,int b){
    	if (a<b) {
			return a;
		}
    	return b;
    }
}


