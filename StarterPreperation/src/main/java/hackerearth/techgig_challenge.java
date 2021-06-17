import java.io.*;
import java.util.*;

public class techgig_challenge 
{
	static int[][] quicksort(int x[][],int first,int last)
	{
	    int pivot,j,temp0,temp1,temp2,i;
	
	     if(first<last)
		 {
	         pivot=first;
	         i=first;
	         j=last;
	
	         while(i<j)
			 {
	             while(x[i][2]<=x[pivot][2]&&i<last)
	                 i++;
	             while(x[j][2]>x[pivot][2])
	                 j--;
	             if(i<j)
				 {
	                  temp0=x[i][0];
	         		  x[i][0]=x[j][0];
	         		  x[j][0]=temp0;
	         		  temp1=x[i][1];
	         		  x[i][1]=x[j][1];
	         		  x[j][1]=temp1;
	         		  temp2=x[i][2];
	         		  x[i][2]=x[j][2];
	         		  x[j][2]=temp2;
	             }
	         }
	
	         temp0=x[pivot][0];
	         x[pivot][0]=x[j][0];
	         x[j][0]=temp0;
	         temp1=x[pivot][1];
	         x[pivot][1]=x[j][1];
	         x[j][1]=temp1;
	         temp2=x[pivot][2];
	         x[pivot][2]=x[j][2];
	         x[j][2]=temp2;
	                 
	         quicksort(x,first,j-1);
	         quicksort(x,j+1,last);	
	    }
	    return x;
	}

    public static void main (String[] args) throws Exception
    {
    	Scanner sc=new Scanner(System.in);    	
    	String inp=sc.next();
    	int timeframe[]=new int [24];
    	int timelength[]=new int [23];
    	
    	int len=inp.length();
    	//System.out.println (len);
    	//System.out.println (inp.charAt(0));
    	String inp1=inp.substring(1,len-1);
    	//System.out.println (inp1);
    	StringTokenizer st=new StringTokenizer(inp1,",");
    	int tokenCount=st.countTokens();
    	//System.out.println (tokenCount);
    	int tab[][]=new int[tokenCount][3];
    	
    	for(int i=0;i<tokenCount;i++)
    	{    		
    		String s=st.nextToken();
    		//System.out.println (s);
    		StringTokenizer st1=new StringTokenizer(s,"#");
    		for(int j=0;j<=st1.countTokens();j++)
    		{
    			String temp=st1.nextToken();
    			//System.out.println (temp);
    			int len1=temp.length();
	    		if(temp.charAt(len1-2)=='A')
	    		{
	    			tab[i][j]=Integer.parseInt(temp.substring(0,temp.length()-2));
	    			//System.out.print (tab[i][j]+" ");
	    		}
	    		else if(temp.charAt(len1-2)=='P')
	    		{
	    			tab[i][j]=Integer.parseInt(temp.substring(0,temp.length()-2))+12;
	    			//System.out.print (tab[i][j]+" ");
	    		}
    		}
    		tab[i][2]=tab[i][1]-tab[i][0];
    		//System.out.println ();   	
    	}
    	tab=quicksort(tab,0,tokenCount-1);
    /*	for(int k=0;k<tokenCount;k++)
    	{
    		for(int l=0;l<3;l++)
    			System.out.print (tab[k][l]+" ");
    		System.out.println ();
    	} */  	
    	int count=0;
    	//System.out.println ("tcount :"+tokenCount);
    	for(int i=0;i<=tokenCount-1;i++)
    	{
    		int flag=0;
    		int stime=tab[i][0];
    		int etime=tab[i][1];
    		//System.out.println ("i = "+i);
    		for(int j=stime;j<etime;j++)
    		{
    			if(timelength[j]!=0)
    			{
    				flag=1;
    				break;
    			}
    		}
    		
    		if(flag==1)
    		{
    			//System.out.println ("------");
    			continue;
    		}
    		else
    		{
    			//System.out.println ("considered");
    			count++;
    			for(int j=stime;j<=etime;j++)
    			{
    				timeframe[j]=1;
    			} 
    			for(int j=stime;j<etime;j++)
    			{
    				timelength[j]=1;
    			}    			
    		}
    		
    		//System.out.println ("flag :"+flag);
    	}
    	
    	
    /*	for(int i=0;i<24;i++)
    	{
    		System.out.print(timeframe[i]+" ");
    	}
    	System.out.println ();
    	for(int i=0;i<23;i++)
    	{
    		System.out.print(timelength[i]+" ");
    	}*/
    	System.out.println(count*500);
    	//int v=(count*500);
    	//return v;
    }   
}