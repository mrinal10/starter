/**
 * @(#)farmers.java
 *
 *
 * @author 
 * @version 1.00 2014/11/21
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class farmers{
	private int n,m,ar[][];
	private String s;
	
	farmers(int N,int M){
		n=N;
		m=M;
		ar=new int[n][m];
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<n;i++){
			s=sc.next();
			for(int j=0;j<m;j++){
				ar[i][j]=(int)s.charAt(j)-48;
			}
		}
	}	
		
	public void getBarn()	
	{
		int i,j,count=0,flag=0;
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				
				for(int i1=0;i1<n-i;i1++){
					for(int j1=0;j1<m-j;j1++){
						
						int i2,j2;
						for(i2=i1;i2<=i1+i;i2++){
							for(j2=j1;j2<=j1+j;j2++){
								
							//	System.out.print (ar[i2][j2]+" ");
							//	System.out.println ("i2= "+i2+" j2=" +j2);
								if(ar[i2][j2]==0){
									flag=1;
									break;
								}
								if(flag==1){
									break;
								}
							}
						//	System.out.println ();
							if(flag==0){
								count++;
							}
						}						
						flag=0;
					}					
				}
				System.out.print(count+" ");
				count=0;
			}		
			System.out.println ();
		}				
	}
}

class Solution_Farmers {

    public static void main(String[] args) {
        int N,M;
        try{
        	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			String s = br.readLine();
			N = Integer.parseInt(br.readLine());
	       	s = br.readLine();
	        M = Integer.parseInt(br.readLine());
	        farmers fms=new farmers(N,M);
	        fms.getBarn();
        }
        catch(Exception e){
        	System.out.println ("error");
        }
        
        
    }
}