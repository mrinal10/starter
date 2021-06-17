import java.io.*;
import java.util.*;

class julka_spoj {

    public static void main (String[] args) {
    	int TOT,MORE;
    	Scanner sc=new Scanner(System.in);
    	  
    		
    	int testcase,klaudia,natalia;
    	
    	for(int i=0;i<10;i++)
    	{
    		TOT=sc.nextInt();
    		MORE=sc.nextInt(); 
    		natalia=(TOT-MORE)/2; 
    		klaudia=natalia+MORE;
    		
    		System.out.println (klaudia);
    		System.out.println (natalia);
    	}
    }    
}