import java.util.Scanner;

public class Problem3 {
	private static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tot = sc.nextInt();
		int power = sc.nextInt();
		
		int lim = (int) Math.ceil(tot/power);
		for(int i = 1; i<=lim; i++){
			countCombinations(i, tot, power,lim);
		}
		System.out.println(count);
		sc.close();
	}
	
	private static void countCombinations(int startValue, int remainingValue, int power, int lim){
		if (remainingValue==0) {
			count++;
			return;
		}
		if (remainingValue<0 || startValue>lim) {
			return;
		}
		int diff = (int) Math.pow(startValue, power);
		remainingValue -= diff;
		countCombinations(startValue+1, remainingValue, power, lim);
		remainingValue += diff;
	}
}
