import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass_Factorial
{
    public static void main(String args[] ) throws Exception 
    {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int fact=1;
        int N = Integer.parseInt(line);
        for (int i = 1; i <= N; i++) 
        {
			fact=fact*i;//            System.out.println("hello world");
        }
        System.out.println (fact);
        System.out.println("Hello World!");
    }
}
