import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass_climbing_Stairs
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        int A = Integer.parseInt(line);
        
        String str = br.readLine();
        System.out.println (line);
        
        int B = Integer.parseInt(str);
        
        line = br.readLine();
        int N = Integer.parseInt(line);
        
        if(A-B!=0)
        	System.out.println(Math.floor(N/(A-B))+1);
    }
}
