import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
           
            long n = sc.nextInt();//Long.parseLong(br.readLine().trim());
            long a = sc.nextInt();//Long.parseLong(br.readLine().trim());
            long b = sc.nextInt();//Long.parseLong(br.readLine().trim());
            long c = sc.nextInt();//Long.parseLong(br.readLine().trim());

            long out_ = divisibilty(n , a, c, b);
            System.out.println(out_);
         }       
    }
    static long divisibilty(long n, long a, long b, long c){
    	long hcf1 = lcmFind(a,b,c);
    	hcf1 = n / hcf1;
    	long hcf2 = lcmFind(a,b);
    	hcf2 = n / hcf2;
    	long hcf3 = lcmFind(a,c);
    	hcf3 = n / hcf3;
    	long hcf4 = lcmFind(c,b);
    	hcf4 = n / hcf4;
    	long kk = (n/a)+(n/b)+(n/c)-hcf1-hcf2-hcf3-hcf4;
		return kk;
    
    }
    
    public static long hcf(long a, long b) {
		if (b == 0)
			return a;
		else
			return hcf(b, a % b);
	}
    
    public static long lcmFind(long i, long y) {    	
    	long s = (i*y)/hcf(i,y);
        return (s);
    }
    
	public static long lcmFind(long a, long b, long c) {
		return lcmFind(lcmFind(a, b), c);

	}
}