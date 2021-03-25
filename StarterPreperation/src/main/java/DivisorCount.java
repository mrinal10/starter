import java.util.Arrays;
import java.util.HashMap;

public class DivisorCount {

	static int findSubarraySum(int arr[], int n, int K) {
		HashMap<Integer, Integer> prevSum = new HashMap<Integer, Integer>();

		int res = 0;
		int currsum = 0;

		for (int i = 0; i < n; i++) {
			currsum += arr[i];
			if (currsum == K) {
				res++;
			}
			if (prevSum.containsKey(currsum - K)) {
				res += (prevSum.get(currsum - K));
			}
			if (prevSum.containsKey(currsum))
				prevSum.put(currsum, prevSum.get(currsum) + 1);
			else
				prevSum.put(currsum, 1);
		}
		return res;
	}

	static int subArraylen(int arr[], int n, int K) {
		int start = -1;
		int end =-1;
		int min = Integer.MAX_VALUE;
		K=2;
		for(int i=0; i<n; i++) {
			int curSum = 0;
			for(int j=0; j<n && (j-i+1)<min; j++) {
				curSum += arr[]
			}
		}
	}

	// Function to count the subarray with K primes
	static void countSubarray(int arr[], int n, int K) {
		for (int i = 0; i < n; i++) {
			if (divCount(arr[i]) % 2 == 1) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}

		System.out.print(findSubarraySum(arr, n, K));
	}

	static int divCount(int n) {
		boolean hash[] = new boolean[(int)n + 1];
		Arrays.fill(hash, true);
		for (int p = 2; p * p < n; p++)
			if (hash[p] == true)
				for (int i = p * 2; i < n; i += p)
					hash[i] = false;

		int total = 1;
		for (int p = 2; p <= n; p++) {
			if (hash[p]) {
				int count = 0;
				if (n % p == 0) {
					while (n % p == 0) {
						n = n / p;
						count++;
					}
					total = total * (count + 1);
				}
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0,1,0,1};
		System.out.println(subArraylen(arr, 5, 2));
	}
}
