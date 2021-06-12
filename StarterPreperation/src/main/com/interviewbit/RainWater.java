package com.interviewbit;

public class RainWater {
	public int trap(final int[] A) {
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int maxSoFar = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            if(maxSoFar<A[i]){
                maxSoFar=A[i];
            }
            if(i==0 || i==A.length-1){
                maxLeft[i] = Integer.MIN_VALUE;    
            }else{
                maxLeft[i] = maxSoFar;
            }
        }
        
        maxSoFar = Integer.MIN_VALUE;
        for(int i=A.length-1; i>=0; i--){
            if(maxSoFar<A[i]){
                maxSoFar=A[i];
            }
            if(i==0 || i==A.length-1){
                maxRight[i] = Integer.MIN_VALUE;    
            }else{
                maxRight[i] = maxSoFar;
            }
        }
        int rainwater = 0;
        for(int i=1; i<A.length-1; i++){
            int water = Math.min(maxLeft[i],maxRight[i])-A[i];
            if(water<0)
                water = 0;
            rainwater += water;
        }
        return rainwater;
    }
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		RainWater rainWater = new RainWater();
		System.out.println(rainWater.trap(arr));
	}
}
