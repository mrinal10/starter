import java.util.ArrayList;
import java.util.Random;


public class Solution2 {
	
	public static int solution(int N) {
		
		ArrayList<Integer> arl = new ArrayList<>();
		for(int i=0;i<N/2;i++){
			String s = intToBinary(i);
			String s1 = intToBinary(N-i);
			if (!consecutiveOnes(s) && !consecutiveOnes(s1)) {
//				System.out.println(s+" added :: "+i);
				arl.add(i);
//				System.out.println(s+" added :: "+(N-i));
				arl.add(N-i);
			}
		}
//		System.out.println(getRandom(arl.size()));
		return arl.get(getRandom(arl.size()));		
	}
	
	public static int getRandom(int N){
		Random rand = new Random();
		if (N>0) {
			int  n = rand.nextInt(N);
			return n;
		}
		return N;
		
	}
	
	public static String intToBinary(int N){
		String s = Integer.toBinaryString(N);
		return s;
	}
	
	public static boolean consecutiveOnes(String s){
		boolean flag = false;
		for(int i=0;i<s.length()-1;i++){
			if (s.charAt(i)=='1' && s.charAt(i+1)=='1') {
				flag = true;
				return true;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {

		
		
		int[] N = {0,74901729,216188401,536870912,1000000000};
		for (int in : N) {
			long startTime = System.currentTimeMillis();
			System.out.println("Solution : "+solution(in));
			long stopTime = System.currentTimeMillis();
			double elapsedTime = stopTime - startTime;
			System.out.println("elapsed Time : "+elapsedTime/1000);
		}		
	}
}
