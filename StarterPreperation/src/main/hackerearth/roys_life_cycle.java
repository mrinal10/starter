
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass21 {
    public static void main(String args[] ) throws Exception 
    {
    	int t=0,sum=0,temp=0,t1=0;    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        System.out.println (N);
        for (int i = 0; i < N; i++) 
        {   
        	line=br.readLine();
        	for(int j=0;j<line.length();j++)
        	{
        		if(line.charAt(j)=='C')
        		{
        			temp++;
        		}        		
        		else if(line.charAt(j)!='C')
        		{
        			if(t<temp)
        			{
        				t=temp;
        			}
        			temp=0;        				        				
        		}         		       		
        			if(t1<t)
        				t1=t;
        	}            
        }
        System.out.println(t1+" "+t);
    }
}
