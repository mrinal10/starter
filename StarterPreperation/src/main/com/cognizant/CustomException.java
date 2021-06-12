package com.cognizant;

import java.util.Scanner;
import java.lang.Exception;
class TestClass
{
	static void solve(int arr[]) throws Exception
	{
		int ans=0;
		
		for(int i=0;i<10;i++)
			for(int j=i+1;j<10;j++)
				ans+=arr[i]/arr[j];
		
		throw new MyException(ans);
	}
	public static void main(String args[])
	{
		try
		{
			Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			int []arr= new int[n];
			in.nextLine();
			
			for(int i=0;i<10;i++)
				arr[i]=Integer.parseInt(in.nextLine());
			
			String s=in.nextLine();
			System.out.println(s.charAt(10));
			
			solve(arr);
		} catch (FormatMismatchException e) {
			 System.out.println("Format mismatch");
		}  catch (InvalidDivisionException e) {
			System.out.println("Invalid division");
		} catch (InvalidIndexException e) {
			System.out.println("Index is invalid");
		} catch (InvalidArrayIndexException e){
			System.out.println("Array index is invalid");
		} catch (Exception e){
			System.out.println("Exception encountered");
		}
	}
}


class InvalidDivisionException extends Exception {

	private static final long serialVersionUID = -8413530613839623190L;
	
	public InvalidDivisionException(String message) {
        
    }
}

class FormatMismatchException extends Exception {

	private static final long serialVersionUID = -8413530613839623180L;
	
	public FormatMismatchException(String message) {
       
    }
}

class InvalidIndexException extends Exception {

	private static final long serialVersionUID = -8413530693839623190L;
	
	public InvalidIndexException(String message) {
        
    }
}

class InvalidArrayIndexException extends Exception {

	private static final long serialVersionUID = -8413550613839623190L;
	
	public InvalidArrayIndexException(String message) {
        System.out.println("Array index is invalid");
    }
}

class MyException extends Exception {
	private static final long serialVersionUID = -3835409875045406630L;

	public MyException (int param) {
        System.out.println("MyException["+param+"]");
    }
}

class AllotherExceptions extends Exception {
	private static final long serialVersionUID = -729008307006506516L;
	public AllotherExceptions (String message) {
        System.out.println("Exception encountered");
    }
}