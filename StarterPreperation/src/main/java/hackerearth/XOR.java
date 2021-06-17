
import java.io.IOException;
import java.util.Scanner;

public class XOR {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int t_i=0; t_i<n; t_i++)
        {  
            ar[t_i] = sc.nextInt();
        } 
        int T = sc.nextInt();//Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {  
            int a = sc.nextInt();//Long.parseLong(br.readLine().trim());
            int b = sc.nextInt();//Long.parseLong(br.readLine().trim());
            int c = sc.nextInt();//Long.parseLong(br.readLine().trim());
            if (a==0) {
				System.out.println(query1(ar,b,c));
			}else{
				query2(ar,b,c);
			}
         }       
    }
    static int query1(int[] ar,int b, int c){
    	int a=ar[b-1];
    	for(int i=b;i<c;i++){    		
    		a ^= ar[i];
    	}
		return a;
    }
    
    static void query2(int[] ar,int b, int c){
    	ar[b-1] ^= c;
    }
}

