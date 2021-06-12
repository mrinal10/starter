package com.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
 
public class Comrades2 {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 
		
		Thread t=new Thread(null,null,"LargeStackThread",100000000)
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				InputReader ir = new InputReader(System.in);
				Print p = new Print();
	 
				int T = ir.nextInt();
	 
				for (int i = 0; i < T; i++) {
					int n = ir.nextInt();
					CustomHashTable<Integer, Integer> ht = new CustomHashTable<Integer, Integer>();
	 
					for (int j = 1; j <= n; j++) {
						int key = ir.nextInt();
						ht.add(key, j);
					}
					
					
					ht.calculateHandShake(ht.getEntry(0));
					
					long handShake = ht.getHandShake();
					long nFactorial=((long)n * (long)(n - 1));
					long combinations= nFactorial/ 2;
					long bumpFist = combinations - handShake;
	 
					bumpFist = bumpFist < 0 ? -bumpFist : bumpFist;
	 
					try {
						p.println(handShake + " " + bumpFist);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 
				}
				
				try {
					p.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		t.start();
	}
 
	static class InputReader {
 
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			int res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
 
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			long res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
 
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
 
	static class Print {
		private final BufferedWriter bw;
 
		public Print() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}
 
		public void print(Object object) throws IOException {
			bw.append("" + object);
		}
 
		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}
 
		public void close() throws IOException {
			bw.close();
		}
	}
 
}
 
class CustomHashTable<K, V> {
	private int TABLE_SIZE = 100003;// prime
	private Entry[] buckets;
	private long handShake;
 
	public CustomHashTable() {
		// TODO Auto-generated constructor stub
		buckets = new Entry[TABLE_SIZE];
	}
 
	public V add(K key, V val) {
		int hashCode = key.hashCode();
		int index = hashCode % TABLE_SIZE;
 
		/*
		 * for(Entry<K,V> first=buckets[index];first!=null;first=first.next) {
		 * if(first.hash==hashCode&&first.key.equals(key)) { V oldVal=first.val;
		 * first.setVal(val); return oldVal; } }
		 */
 
		buckets[index] = new Entry<K, V>(hashCode, key, val, buckets[index]);
 
		return null;
	}
 
	public Entry getEntry(int pos) {
		return buckets[pos];
	}
	
 
	public long getHandShake() {
		return handShake;
	}
 
	public int calculateHandShake(Entry node) {
		if (node == null) {
			return 1;
		}
 
		int l = 0;
 
		for (Entry n = node; n != null; n = n.next) {
			l = l + calculateHandShake(buckets[(Integer) n.val]);
		}
 
		if (buckets[0] == node)
			return l;
		handShake = handShake + l;
		return 1 + l;
	}
 
	public void clear() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			buckets[i] = null;
		}
	}
 
	private static class Entry<K, V> {
 
		public int hash;
		private K key;
		private V val;
		private Entry next;
 
		Entry(int hash, K key, V val, Entry next) {
			this.hash = hash;
			this.key = key;
			this.val = val;
			this.next = next;
		}
 
		public int getHash() {
			return hash;
		}
 
		public K getKey() {
			return key;
		}
 
		public V getVal() {
			return val;
		}
 
		public Entry getNext() {
			return next;
		}
 
		public void setHash(int hash) {
			this.hash = hash;
		}
 
		public void setKey(K key) {
			this.key = key;
		}
 
		public void setVal(V val) {
			this.val = val;
		}
 
		public void setNext(Entry next) {
			this.next = next;
		}
 
	}
}