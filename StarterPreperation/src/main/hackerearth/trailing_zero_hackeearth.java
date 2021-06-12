import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class TestClass_Trailing 
{
    public static void main(String args[] ) throws Exception 
    {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int j,count=0;
        for (int i = 1; i <= N; i++) 
        {
        	j=i;
            while(j%5==0)
            {
            	j=j/5;
            	count++;
            }
        } 
        System.out.println(count);
    }
}