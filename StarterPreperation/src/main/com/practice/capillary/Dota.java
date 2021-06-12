package com.practice.capillary;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
/**
 * Created by Sarika on 8/30/2015.
 */
class Dota {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int ms = scanner.nextInt();
        int mt = scanner.nextInt();
        int lt = scanner.nextInt();
 
        int n = scanner.nextInt();
 
        int[] creeps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            creeps[i] = scanner.nextInt();
        }
 
        Arrays.sort(creeps);
 
        int[] minMana = new int[n + 1];
        minMana[0] = 0;
 
        for (int i = 1; i <= n; i++) {
            // can use sun strike
            int sVal = ms + minMana[findNextSmallerIdx(creeps, i, creeps[i])];
            System.out.println("sVal >> "+sVal);
            // or tornado
            int tVal = mt + minMana[findNextSmallerIdx(creeps, i, creeps[i] - lt)];
            System.out.println("tVal >> "+tVal);
            minMana[i] = sVal < tVal ? sVal : tVal;
        }
        for (int i = 0; i < minMana.length; i++) {
        	System.out.print(minMana[i]+" ");
		}
        scanner.close();
    }
 
    /**
     * Return the index between 0 to i of maximum value that is less than cap
     * @param creeps
     * @param i
     * @param cap
     * @return
     */
    private static int findNextSmallerIdx(int[] creeps, int i, int cap) {
        int j = i-1;
        while (j > 0 && creeps[j] >= cap) {
            j--;
        }
        System.out.println(cap+" :: findNextSmallerIdx :: "+j);
        return j;
    }
}