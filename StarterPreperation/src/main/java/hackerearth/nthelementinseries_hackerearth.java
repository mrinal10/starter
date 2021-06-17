import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass_nThElement
{
    public static void main(String args[] ) throws Exception 
    {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) 
        {
        	int a[]=new int[5];
        	int b[]=new int[5];
        	for(int j=0;j<5;j++)
        	{
        		line = br.readLine();
        		a[j] = Integer.parseInt(line);
        	}
        	line = br.readLine();
        	int t=Integer.parseInt(line);
        	int count=4;
        	if(t>4)
        	{
        		b[4]= 5;
        	}
        }
        System.out.println("Hello World!");
    }
}
