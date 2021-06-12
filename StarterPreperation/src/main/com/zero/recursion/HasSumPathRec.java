package com.zero.recursion;

public class HasSumPathRec {

	boolean hasSumPathHelper(int[][] a, int r, int c, int rlim, int clim,int sum){
		sum -= a[r][c];
		if(r==rlim && c == clim){
			if(sum ==0){
				return true;
			}else{
				return false;
			}
		}
		boolean dn =false;
				boolean rh = false;
		if(r>=rlim){
			rh =  hasSumPathHelper(a, r, c+1, rlim, clim, sum);
		}
		else if(c>=clim){
			dn =  hasSumPathHelper(a, r+1, c, rlim, clim, sum);
		}else{
			dn =  hasSumPathHelper(a, r+1, c, rlim, clim, sum);
			rh =  hasSumPathHelper(a, r, c+1, rlim, clim, sum);
		}
		return dn||rh;
	}
	boolean hasSumPath(int a[][], int sum) 
	{
		int r = a.length-1;
		int c = a[0].length-1;
		if(hasSumPathHelper(a, 0,0,r,c,sum))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		HasSumPathRec hassumpath = new HasSumPathRec();
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

		System.out.println(hassumpath.hasSumPath(mat, 25));
	}

}
