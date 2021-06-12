package com.hotstar.hiring06072018;

	import java.util.*;
	import java.io.*;

	public class ThreeParts implements Runnable {
	    long mod = (long)1e9 + 7;
	    long binaryToDecimal(String s) {
	        // Pre-calculate all powers of 2 modulo (10^9 + 7)..
	        long pow[] = new long[s.length()];
	        pow[0] = 1;
	        for(int i=1;i<s.length();i++) {
	            pow[i] = pow[i - 1] * 2L;
	            pow[i] %= mod;
	        }
	        long ans = 0;
	        int power = 0;
	        for(int i=s.length()-1;i>=0;i--) {
	            if(s.charAt(i) == '1') {
	                ans += pow[power];
	                ans %= mod;
	            }
	            power++;
	        }
	        return ans;
	    }
	    
	    void solve(InputReader in, PrintWriter w) {
	        int T = in.nextInt();
	        while(T-- > 0) {
	            int n = in.nextInt();
	            char c[] = new char[n];
	            for(int i=0;i<n;i++)
	                c[i] = in.next().charAt(0);
	            int count_1 = 0;
	            for(int i=0;i<n;i++)
	                if(c[i] == '1')
	                    count_1++;
	            if(count_1 % 3 != 0)
	                System.out.println("-1");
	            else if(count_1 == 0)
	                System.out.println("0");
	            else {
	                StringBuilder str1 = new StringBuilder();
	                StringBuilder str2 = new StringBuilder();
	                StringBuilder str3 = new StringBuilder();
	                int zeroes1 = 0, zeroes2 = 0, zeroes3 = 0;
	                int ind = 0;
	                int ones = count_1 / 3;
	                // remove the leading zeroes..
	                while(ind < n && c[ind] != '1')
	                    ind++;
	                // 1st part
	                int total1_1 = 0;
	                while(ind < n && total1_1 != ones) {
	                    str1.append(c[ind]);
	                    if(c[ind] == '1')
	                        total1_1++;
	                    ind++;
	                }
	                // count no of zeroes before the next '1'..
	                while(ind < n && c[ind] != '1') {
	                    zeroes1++;
	                    ind++;
	                }
	                // 2nd part
	                int total1_2 = 0;
	                while(ind < n && total1_2 != ones) {
	                    str2.append(c[ind]);
	                    if(c[ind] == '1')
	                        total1_2++;
	                    ind++;
	                }
	                // count no of zeroes before the next '1'..
	                while(ind < n && c[ind] != '1') {
	                    zeroes2++;
	                    ind++;
	                }
	                // 3rd part
	                int total1_3 = 0;
	                while(ind < n && total1_3 != ones) {
	                    str3.append(c[ind]);
	                    if(c[ind] == '1')
	                        total1_3++;
	                    ind++;
	                }
	                // count no of zeroes till last index..(there will be no-more 1s)
	                while(ind < n) {
	                    zeroes3++;
	                    ind++;
	                }
	                String val1 = str1.toString();
	                String val2 = str2.toString();
	                String val3 = str3.toString();
	                // check if all "val" we got are equal..
	                if(val1.equals(val2) && val2.equals(val3)) {
	                    // If 3rd part contains trailing zeroes then check..
	                    // If other parts have at-least that many trailing zeroes
	                    if(zeroes3 <= zeroes1 && zeroes3 <= zeroes2) {
	                        for(int i=0;i<zeroes3;i++)      // Add those required zeroes..
	                            val3 += "0";
	                        // Now, It is possible to divide it in 3 equal parts..
	                        // So just do the conversion now..
	                        System.out.println(binaryToDecimal(val3));
	                    }
	                    else        // We won't be able to divide it in 3 equal parts..
	                        System.out.println("-1");
	                }
	                // if not equal then print "-1"
	                else
	                    System.out.println("-1");
	            }
	        }
	    }
	    // ************* Code ends here ***************
	   
	    void init() throws Exception {
	        InputReader in;
	        PrintWriter w;
	        boolean online = false;
	        String common_in_fileName = "\\in";
	        String common_out_fileName = "\\out";
	        int test_files = 0;
	        for(int file_no = 0; file_no <= test_files; file_no++) {
	            String x = "" + file_no;
	            if (x.length() == 1) x = "0" + x;
	            String in_fileName = common_in_fileName + "" + x;
	            String out_fileName = common_out_fileName + "" + x;
	            if (online) {
	                //in = new Scanner(new File(in_fileName + ".txt"));
	                in = new InputReader(new FileInputStream(new File(in_fileName + ".txt")));
	                w = new PrintWriter(new FileWriter(out_fileName + ".txt"));
	            } else {
	                //in = new Scanner(System.in);
	                in = new InputReader(System.in);
	                w = new PrintWriter(System.out);
	            }
	            solve(in, w);
	            w.close();
	        }
	    }
	    
	    public void run() {
	        try {
	            init();
	        }
	        catch(Exception e) {
	            System.out.println(e);
	            e.printStackTrace();
	        }
	    }
	   
	    public static void main(String args[]) throws Exception {
	        new Thread(null, new ThreeParts(),"Sol",1<<28).start();
	    }
	    

	    static class InputReader {
	        private InputStream stream;
	        private byte[] buf = new byte[1024];
	        private int curChar;
	        private int numChars;
	        private SpaceCharFilter filter;
	        public InputReader(InputStream stream) {
	            this.stream = stream;
	        }
	        public int read() {
	            if (numChars == -1) {
	                throw new InputMismatchException();
	            }
	            if (curChar >= numChars) {
	                curChar = 0;
	                try {
	                    numChars = stream.read(buf);
	                } catch (IOException e) {
	                    throw new InputMismatchException();
	                }
	                if (numChars <= 0) {
	                    return -1;
	                }
	            }
	            return buf[curChar++];
	        }
	        public String nextLine() {
	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            String str = "";
	            try {
	                str = br.readLine();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return str;
	        }
	        public int nextInt() {
	            int c = read();
	            while (isSpaceChar(c)) {
	                c = read();
	            }
	            int sgn = 1;
	            if (c == '-') {
	                sgn = -1;
	                c = read();
	            }
	            int res = 0;
	            do {
	                if (c < '0' || c > '9') {
	                    throw new InputMismatchException();
	                }
	                res *= 10;
	                res += c - '0';
	                c = read();
	            } while (!isSpaceChar(c));
	            return res * sgn;
	        }
	        public long nextLong() {
	            int c = read();
	            while (isSpaceChar(c)) {
	                c = read();
	            }
	            int sgn = 1;
	            if (c == '-') {
	                sgn = -1;
	                c = read();
	            }
	            long res = 0;
	            do {
	                if (c < '0' || c > '9') {
	                    throw new InputMismatchException();
	                }
	                res *= 10;
	                res += c - '0';
	                c = read();
	            } while (!isSpaceChar(c));
	            return res * sgn;
	        }
	        public double nextDouble() {
	            int c = read();
	            while (isSpaceChar(c)) {
	                c = read();
	            }
	            int sgn = 1;
	            if (c == '-') {
	                sgn = -1;
	                c = read();
	            }
	            double res = 0;
	            while (!isSpaceChar(c) && c != '.') {
	                if (c == 'e' || c == 'E') {
	                    return res * Math.pow(10, nextInt());
	                }
	                if (c < '0' || c > '9') {
	                    throw new InputMismatchException();
	                }
	                res *= 10;
	                res += c - '0';
	                c = read();
	            }
	            if (c == '.') {
	                c = read();
	                double m = 1;
	                while (!isSpaceChar(c)) {
	                    if (c == 'e' || c == 'E') {
	                        return res * Math.pow(10, nextInt());
	                    }
	                    if (c < '0' || c > '9') {
	                        throw new InputMismatchException();
	                    }
	                    m /= 10;
	                    res += (c - '0') * m;
	                    c = read();
	                }
	            }
	            return res * sgn;
	        }
	        public String readString() {
	            int c = read();
	            while (isSpaceChar(c)) {
	                c = read();
	            }
	            StringBuilder res = new StringBuilder();
	            do {
	                res.appendCodePoint(c);
	                c = read();
	            } while (!isSpaceChar(c));
	            return res.toString();
	        }
	        public boolean isSpaceChar(int c) {
	            if (filter != null) {
	                return filter.isSpaceChar(c);
	            }
	            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	        }
	        public String next() {
	            return readString();
	        }
	        public interface SpaceCharFilter {
	            public boolean isSpaceChar(int ch);
	        }
	    }
	}