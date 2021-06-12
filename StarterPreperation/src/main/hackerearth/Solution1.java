
public class Solution1 {
	public static boolean solution(int[] A) {
		
		int flagT = isSorted(A);
		if (flagT==-1) {
			return true;
		} else{
			int indexOfSmallestElement = findsmallest(A, flagT, A.length);
			int temp = A[indexOfSmallestElement];
			A[indexOfSmallestElement] = A[flagT];
			A[flagT] = temp;
			
		}
		
		
		flagT = isSorted(A);
		if (flagT==-1) {
			return true;
		} else{
			return false;
		}
    }
	
	
	public static int findsmallest(int[] a,int f, int l) {
		int small = a[f];
		int index = f;
	    for (int i = f; i < l - 1; i++) {
	        if (small >= a[i + 1]) {
	           small = a[i + 1];
	           index = i + 1;
	        }
	    }
	    System.out.println("index of smallest element : "+index);
	    return index;
	}
	
	public static int isSorted(int[] a) {
	    for (int i = 0; i < a.length - 1; i++) {
	    	for(int j =i+1; j<a.length; j++) {
	    		if (a[i] > a[j]) {
		            return i; // It is proven that the array is not sorted.
		        }
	    	}
	    }
	    return -1; // If this part has been reached, the array must be sorted.
	}
	
	public static void main(String[] args) {
		int[] a = {8, 9, 9, 8};//{1,5,3,3,7,2};//
		System.out.println(solution(a));
	}
	
}
