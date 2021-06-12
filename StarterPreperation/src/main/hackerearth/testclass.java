
import java.io.*;
import java.util.*;

class testclass_t 
{
    public static void main (String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	int t;
    	t=sc.nextInt();
    	while(t>0)
    	{
    		int flag=1,flag1=1;
    		t--;
    		String mailid=sc.next();
    		StringTokenizer st=new StringTokenizer(mailid,"@");
    		if(st.countTokens()==2)
    		{
    			String userid=st.nextToken();
    			String hostid=st.nextToken();
    			if(userid.length()<=16)
    			{
    				for(int i=0;i<userid.length();i++)
    				{
    					int charno=userid.charAt(i);
    					if(!((charno>=65 && charno<=90) || (charno>=97 && charno<=122) ||  (charno>=48 && charno<=57) ))
    					{
    						flag=0;
    						break;
    					}    					
    				}
    			}
    			
    			if(flag==1)
    			{
    				
    				if(hostid.length()<=16)
	    			{
	    				for(int i=0;i<hostid.length();i++)
	    				{
	    					int charno=(hostid.charAt(i));
	    				}
	    			}
    			}
    		}
    	}
	}   
}