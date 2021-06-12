package com.hackerearth.hourstorm;

import java.io.*;
import java.util.*;


public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] inp = br.readLine().split(" ");
        int[] profit=new int[N];
        int i;
        for(i=0;i<N;i++) 
        {
            profit[i] = Integer.parseInt(inp[i]);
        }
        int Q= Integer.parseInt(br.readLine().trim());
        for(i=0;i<Q;i++)
        {
            String[] temp= br.readLine().split(" ");
            int l=Integer.parseInt(temp[0]);
            int r=Integer.parseInt(temp[1]);
            long out_ = solve(N,profit,l,r);
            System.out.println(out_);
        }
        
        wr.close();
        br.close();
    }
    static long solve(int N, int[] profit,int l,int r){
        int ct  = 0;
        for(int i=0; i<profit.length; i++){
            if(profit[i]<=r && profit[i]>=l){
                ct += 1;
            }
        }
        return ct;
    }
}