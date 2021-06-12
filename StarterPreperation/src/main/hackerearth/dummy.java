/* IMPORTANT: class must not be public. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
class TestClass_Dummy {
    public static void main(String args[] ) throws Exception 
    {       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String line = br.readLine();
        
        int N = Integer.parseInt(line);
        char ss[][]=new char[N][2];
        for (int i = 0; i < N; i++) 
        {
            String s=br.readLine();
            System.out.println (s);
            ss[i][0]=s.charAt(0);
            ss[i][1]=s.charAt(2);
        }
        String s1=br.readLine();
		for(int i=0;i<s1.length();i++)
		{
			int flag=0;
			for(int j=0;j<N;j++)
			{
				if(s1.charAt(i)==ss[j][0])
				{
					System.out.print (ss[j][1]);
					flag=1;
					break;
				}
				else if(s1.charAt(i)==ss[j][1])
				{
					System.out.print (ss[j][0]);
					flag=1;
					break;
				}				
			}
			if(flag!=1)
			{
				System.out.print (s1.charAt(i));
			}
		}
    }
}