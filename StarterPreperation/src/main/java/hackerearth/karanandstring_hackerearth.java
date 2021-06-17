import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass_Karand {
    public static void main(String args[] ) throws Exception 
    {
    	String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) 
        {
            str=br.readLine();
            for(int j=0;j<str.length();j++)
            {
            	if(j==0 || str.charAt(j-1)!=str.charAt(j))
            	{
            		System.out.print (str.charAt(j));
            	}
            	
            }
            System.out.println ();
        }
    }
}