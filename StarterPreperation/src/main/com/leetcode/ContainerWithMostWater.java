package com.leetcode;

//two pointer approach
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int maxWaterContent = (height.length-1)*(Math.min(height[height.length-1], height[0]));
		int leftSide = 0;
		int rightSide = height.length-1;
		while (leftSide<rightSide) {
			if (height[leftSide]<height[rightSide]) {
				leftSide++;
			}else{
				rightSide--;
			}
			int width = rightSide-leftSide;
			int volume = Math.min(height[rightSide] , height[leftSide]);
			
			if (maxWaterContent<width*volume) {
				maxWaterContent = width*volume;
			}
		}
		return maxWaterContent;
	}

	public static void main(String[] args) {
		
	}

}
