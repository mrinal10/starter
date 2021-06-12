import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution_euler2 {

    public static void main(String[] args) throws Exception
    {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String l=br.readLine();
        int t=Integer.parseInt(l);
        int total=0;
        for(int j=0;j<t;j++)
        {
        	l=br.readLine();
        	int n=Integer.parseInt(l);
        	total=0;
        	for(int i=3;i<n;i+=3)
	        {
	        	total=total+i;
	        }
	        for(int i=5;i<n;i+=5)
	        {
	        	total=total+i;        	
	        }
        }       
        System.out.println (total);
    }
}