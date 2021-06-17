/* IMPORTANT: class must not be public. */
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Test_Class 
{
    public static void main(String args[] ) throws Exception 
    {       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String line = br.readLine();
        System.out.println (line);
        int N = Integer.parseInt(line);
        char ss[][]=new char[N][2];
        for (int i = 0; i < N; i++) 
        {
        	String s1=br.readLine();
            
            //System.out.println (s.charAt(2));
            ss[i][0]=s1.charAt(0);
            s1=br.readLine();
            ss[i][1]=s1.charAt(0);
        }
        String s1=br.readLine();
        
		for(int i=0;i<s1.length();i++)
		{
			System.out.print (s1.charAt(i));
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
			if(flag==0)
			{
				System.out.print (s1.charAt(i));
			}
		}
    }
}
