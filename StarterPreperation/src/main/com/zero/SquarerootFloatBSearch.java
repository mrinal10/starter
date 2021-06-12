package com.zero;

public class SquarerootFloatBSearch {
	
	int bsearchIntPart(float n, int low, int lim){
		int l = low;
		int h = lim;
		int mid = (l+h)/2;
		if(l<h){
			if(((mid*mid) == n) || (((mid*mid)<n)&&((mid+1)*(mid+1)>n))){
				return mid;
			}else if((mid*mid)>n){
				return bsearchIntPart(n, l, mid);
			}else{
				return bsearchIntPart(n, mid, lim);
			}
		}
		return -1;
	}
	
	double squareRootOfFloat(float N){
		if (N==0.0) {
			return N;
		}
		int lim = (int) Math.floor(N);
		Double res;
	    int intValue = bsearchIntPart(N,0,lim);
	    double ans = intValue;
	    if (ans*ans == N) {
	    	res = convertToDecimalPlaces(ans);
	    	return res;
		}
		double increment = 0.1;
        for (int i = 0; i < 5; i++) {
            while (ans * ans <= N) {
                ans += increment;
            }
            ans = ans - increment;
            increment = increment / 10;
        }
        res = convertToDecimalPlaces(ans);
        return res;
	}
	
	double convertToDecimalPlaces(Double value){
		return Math.round(value*1000.0)/1000.0;
	}
	
	public static void main(String[] args) {
		SquarerootFloatBSearch squarerootFloatBSearch = new SquarerootFloatBSearch();
		System.out.println(squarerootFloatBSearch.squareRootOfFloat(4967));
	}
}
