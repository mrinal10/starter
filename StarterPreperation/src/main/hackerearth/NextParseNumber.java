import java.util.Random;

class NextParseNumber{
	
	public static int getRandom(int N){
		Random rand = new Random();
		int  n = 0;
		if (N>0) {
			n = rand.nextInt(N);			
		}
		if (n==0) {
			return 1;
		}		
		return n;
	}
	
	public static int nextSparseNumber(int inputNum) {
        int origNum = inputNum;
        int copy = inputNum;
        int count = 0;
        while (copy > 0) {
            if ((copy & 3) == 3) {
                int x = (1) << (count);
                inputNum = (inputNum) + ((1) << (count));
                copy = inputNum >> count;
            }
            count++;
            copy = copy >> 1;
        }

        if (!(inputNum == origNum)) {
            int c = inputNum;
            int cnt = 0;
            while (c > 0) {
                if ((c & 1) > 0) {
                    int tmp = (inputNum) ^ (1 << cnt);
                    if (tmp > origNum)
                        inputNum = tmp;
                    else
                        break;
                }
                c >>= 1;
                cnt++;
            }
            return inputNum;
        }
        return inputNum;
    }
	
	public static boolean checkSparse(int n)
	{
		if ((n & n>>1) ==0){			
			return true;
		}
		return false;		
	}
	
	public static int solution(int N) {
		//System.out.println(getRandom(N)+" :: input value :::: "+N);
		int l = N/getRandom(10);
		//System.out.println("l::::"+l);
		l = getRandom(l);
		//System.out.println("l::::"+l);
		if (l==0) {
			return -1;
		}
		
		int sparsenum = 0;
		for (int j = l; j < N; j++) {
			sparsenum = nextSparseNumber(j);
			while (sparsenum>N) {
				//System.out.println("generated sparse number is greater than input :: "+sparsenum);
				sparsenum = nextSparseNumber(N/getRandom(10));
			}
			if ((N-sparsenum)>0 && checkSparse(N-sparsenum)) {
				//System.out.println(sparsenum+":::::::::::"+(N-sparsenum));
				break;
			}else{
				j = sparsenum;
			}
		}
		if (sparsenum==0) {
			return -1;
		}
		if (getRandom(100)%2 == 0) {
			return sparsenum;	
		}
		return (N-sparsenum);	
	}
	
	public static void main(String[] args) {
		int[] N = {0,1023,1166,561892,26,74901729,216188401,536870912,908509580,1000000000};
		for (int i : N) {
			long startTime = System.currentTimeMillis();
			System.out.println(solution(i));
			long stopTime = System.currentTimeMillis();
			double elapsedTime = stopTime - startTime;
			System.out.println("elapsed Time : "+elapsedTime/1000);
		}
	}
}	