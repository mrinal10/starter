import java.util.Arrays;

public class LIS {
	public static void main(String[] args) {
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(longestIncrSS(A));
	}

	
	private static int longestIncrSS(int[] a) {
		int[] reference = new int[a.length];
		reference[0] = 1;
		for(int i=1; i<a.length; i++) {
			for(int j=0; j<i; j++) {
				if(a[j]<a[i] && reference[j]>reference[i]) {
					reference[i] = reference[j];
				}
			}
			reference[i]++;
		}
		return Arrays.stream(reference).max().getAsInt();
	}
}
