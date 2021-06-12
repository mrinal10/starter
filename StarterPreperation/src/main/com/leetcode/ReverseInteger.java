package com.leetcode;

public class ReverseInteger {

	static int getLen(int s){
        String x = String.valueOf(s);
        return x.length();
    }
    
    public static int reverse(int x) {
        if(x<-2147483646){
            return 0;
        }
        int ans = 0;
        boolean flag = false;
        if(x<0){
            flag = true;
            x = Math.abs(x);
        }
        int len = getLen(x);
        
        if(len>=10 && x%10>2){
            return 0;
        }else{
            ans = 0;
            while(x!=0){
                ans = ans*10+(x%10);
                x = x/10;
            }
            if(flag){
                ans = ans*(-1);
            }
        }
        if (!flag && ans<0) {
			return 0;
		}else if (flag && ans>0) {
			return 0;
		}
        return ans;
    }
    
	public static void main(String[] args) {
		int i = 1563847412;
		System.out.println(reverse(i));
	}

}
