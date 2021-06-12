package com.geekforgeeks;

public class AllSubsetOfSet {

	static void printSubsets(char set[]) {
		int n = set.length;

		for (int i = 0; i < (1 << n); i++) {
			System.out.print("{ ");

			for (int j = 0; j < n; j++)

				if ((i & (1 << j)) > 0){
//					System.out.println("j :: "+(1 << j));
//					System.out.println("and value :: "+(i & (1 << j)) );
					System.out.print(set[j] + " ");
				}

			System.out.println("}");
		}
	}

	// Driver code
	public static void main(String[] args) {
		char set[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		printSubsets(set);
	}
}