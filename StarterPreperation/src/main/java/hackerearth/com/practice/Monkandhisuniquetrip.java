package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Monkandhisuniquetrip {
	static class fastreader {
		BufferedReader br;
		StringTokenizer st;
 
		public fastreader() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			this.br = br;
		}
 
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException ie) {
				}
			}
			return st.nextToken().toString();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	static Stack<Integer> st1;
	static int visited[],comp[],count[];
    
	@SuppressWarnings("unchecked")
	void run() {
		fastreader fr=new fastreader();
		int n=fr.nextInt();
		int m=fr.nextInt();
		st1=new Stack<>();
		visited=new int[n+1];
		ArrayList<Integer> gr[]=new ArrayList[n+1];
		ArrayList<Integer> grt[]=new ArrayList[n+1];
		for(int i=0;i<n+1;i++){gr[i]=new ArrayList<>();grt[i]=new ArrayList<>();}
		for(int i=0;i<m;i++){
			int x=fr.nextInt();
			int y=fr.nextInt();
			gr[x].add(y);
			grt[y].add(x);
		}
			for(int i=1;i<=n;i++){
				if(visited[i]==0)dfs1(i,gr);
			}
		 count=new int[n+1];
			 comp=new int[n+1];
			int c=0;
			visited=new int[n+1];
			while(!st1.isEmpty()){
				int temp=st1.pop();
				if(visited[temp]==1){
				continue;	
				}
				c++;
				dfs2(temp,grt,c);
			}
			ArrayList<Integer> grfinal[]=new ArrayList[n+1];
			for(int i=0;i<n+1;i++){grfinal[i]=new ArrayList<>();}
			for(int i=1;i<=n;i++)
			{
				for(int x:gr[i]){
					if(comp[i]!=comp[x]){
						grfinal[comp[i]].add(comp[x]);
						}
				}
			}
			int ans=0;
			visited=new int[n+1];
			for(int i=1;i<=n;i++){
				if(visited[i]==0){
					dfs1(i,grfinal);
				}
			}
			int dist[]=new int[n+1];
			while(!st1.isEmpty()){
				int temp=st1.pop();
				for(int x:grfinal[temp])
						dist[x]=Math.max(dist[x],dist[temp]+1);
				}
				for(int i=1;i<=n;i++){
					ans=Math.max(ans,dist[i]);
				}
			System.out.println(ans);			
		}
	
		static int dfs3(int i,ArrayList<Integer> gr[]){
			 int ans=0;
			 for(int x:gr[i]){
				 if(visited[x]==0){
					 ans+=dfs3(x,gr);
				 }
			 }
			 return ans+1;
		}
		
		static void dfs1(int v,ArrayList<Integer> gr[]){
			visited[v]=1;
			for(int u:gr[v]){
				if(visited[u]==0)
				dfs1(u,gr);
			}
			st1.add(v);
		}
		
		static void dfs2(int v,ArrayList<Integer> gr[],int c){
			visited[v]=1;
			comp[v]=c;
			count[c]++;
			for(int u:gr[v]){
				if(visited[u]==0)
					dfs2(u,gr,c);
			}
		}
		
		public static void main(String args[]){
			new Thread(null, new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new Monkandhisuniquetrip().run();
				}
			}, "1",1<<26).start();
		}
}