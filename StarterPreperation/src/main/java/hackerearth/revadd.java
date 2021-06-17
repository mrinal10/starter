
import java.io.*;
import java.util.*;

class revadd {
	revadd()
	{
	}

    public int add(int a,int b)
    {
    	int c=a+b;
    	return c;
    }
    public int rev(int n) {
    	while(n%10==0){
    		n=n/10;
    	}
    	int temp=n;
    	n=0;
    	while(temp>0)
    	{
    		n=(n*10)+(temp%10);
    		temp=temp/10;
    	}
    	return n;
    }   
}

class test1{
	public static void main (String[] args) {
		int testcase,a,b;
		Scanner sc=new Scanner(System.in);
		testcase=sc.nextInt();
		for(int i=0;i<testcase;i++){
			revadd r=new revadd();
			a=sc.nextInt();
			b=sc.nextInt();
			a=r.rev(a);
			b=r.rev(b);
			a=r.add(a,b);
			a=r.rev(a);
			System.out.println (a);
		}
		
	}
}