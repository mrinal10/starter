import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution_Euler1 {

    public static void main(String[] args) throws Exception
    {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String l=br.readLine();
        int n=Integer.parseInt(l);
        int total=0;
        for(int i=3;i<n;i+=3)
        {
        	total=total+i;
        }
        for(int i=5;i<n;i+=5)
        {
        	total=total+i;        	
        }
        System.out.println (total);
    }
}