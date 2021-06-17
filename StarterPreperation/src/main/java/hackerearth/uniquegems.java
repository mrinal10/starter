/**
 * @(#)uniquegems.java
 *
 *
 * @author MRINAL
 * @version 1.00 2015/1/23
 */
import java.util.*;

public class uniquegems 
{
    public static void main (String[] args) 
    {
		 int t;
		 Scanner sc=new Scanner(System.in);
		 t=sc.nextInt();
		 while(t>0)
		 {
		 	t--;
		 	String s=sc.next();
		 	int i,j,k,l,count=0,totalcount=0,tempval;
		 	String st="",st1="";
		 	int len=s.length();
		 	for(i=1;i<=len;i++)
		 	{
		 		for(j=0;j<=len-i;j++)
		 		{
		 			count=0;
		 			tempval=0;
		 			st=s.substring(j,j+i);		 		
		 			//System.out.println ("st : "+st);	
			 		for(l=0;l<=len-i;l++)
			 		{
			 			st1=s.substring(l,l+i);
			 			//System.out.println ("st1 : "+st1);
			 			if(st.equalsIgnoreCase(st1))
			 			{
			 				count++;			 				
			 			}	
			 		}
			 		//System.out.println ("count="+count);
			 		if(count==1)
			 			totalcount++;
			 	//	System.out.println ("total count="+totalcount);
		 		}
		 	}
		 	System.out.println (totalcount);
		 }
	}
}