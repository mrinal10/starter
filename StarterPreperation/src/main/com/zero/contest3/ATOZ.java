package com.zero.contest3;

	import java.util.*;

	class obj implements Comparator<obj>{
	    char a;
	    int in;
	    obj(char c, int k){
	        a = c;
	        in = k;
	    }
		@Override
		public int compare(obj o1, obj o2) {
			return o2.in-o1.in;
		}
	}
	
	class MComparator implements Comparator<obj> {

		public int compare(obj o1, obj o2) {
			return o1.in-o2.in;
		}
	}

	public class ATOZ  {
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String s = sc.next();
	        char[] cArr = s.toCharArray();
	        HashMap<Character, Integer> aMap = new HashMap();
	        for(int i=0; i<26; i++){
	            aMap.put(cArr[i], i);
	        }
	        String st = sc.next();
	        char[] cAr = st.toCharArray();
	        int[] cr = new int[st.length()];
	        for(int i=0; i<st.length(); i++){
	            cr[i] = aMap.get(cAr[i]);
	        }
	        Comparator<obj> comparator = new MComparator();
	        PriorityQueue<obj> pq = new PriorityQueue<obj>(st.length(), comparator);

	        
	        for(int i=0;i<st.length(); i++){
	        	obj oo = new obj(cAr[i], cr[i]);
	        	pq.add(oo);
	        }
	        for(int i=0;i<st.length(); i++){
	        	System.out.print(pq.poll().a);
	        }
	        
	        
	    }
	}