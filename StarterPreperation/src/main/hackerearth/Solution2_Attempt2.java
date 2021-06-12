import java.util.ArrayList;
import java.util.Random;


public class Solution2_Attempt2 {
	
	public static int solution(int N) {
		
		ArrayList<Integer> arl = new ArrayList<>();
		if (N==0) {
			return 0;
		}
		for(int i=0;i<N/2;i++){
			try {
				
				if (checkSparse(i) && checkSparse(N-i)) {
					arl.add(i);
					arl.add(N-i);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return arl.get(getRandom(arl.size()));		
	}
	
	public static int getRandom(int N){
		Random rand = new Random();
		int  n = rand.nextInt(N);
		System.out.println("n>>>"+n);
		return n;
	}
	
	public static boolean checkSparse(int n)
	{
		System.out.println(n+">>>> checkSparse >>>>");
		
		if ((n & n>>1) ==0){			
			return true;
		}
		System.out.println(n+" ::::: false ::::: "+Integer.toBinaryString(n));
		return false;		
	}
	
	public static void main(String[] args) {
		int[] N = {536870912};//{0,74901729,216188401,536870912,1000000000};
		for (int in : N) {
			long startTime = System.currentTimeMillis();
			System.out.println("Solution : "+solution(in));
			long stopTime = System.currentTimeMillis();
			double elapsedTime = stopTime - startTime;
			System.out.println("elapsed Time : "+elapsedTime/1000);
		}		
	}
}
