class MiddleChar {

	public static void main(String args[]){
		MiddleChar obj = new MiddleChar();
		char result = obj.middle('+','+','+');
		System.out.println(result);
	}
	
	public char middle(char ch1, char ch2, char ch3){
		int a1=(int) ch1;
		int a2=(int) ch2;
		int a3=(int) ch3;
		System.out.println (a1);
		System.out.println (a2);
		System.out.println (a3);
		int fl=0;
        if(a1>a2 && a1>a3)
        {
            if(a2>a3)
            {
               fl=a2; 
            }
            else
            {
                fl=a3;
            }
        }
        else if(a2>a1 && a2>a3)
        {
            if(a1>a3)
            {
               fl=a1; 
            }
            else
            {
                fl=a3;
            }
        }
        else if(a3>a2 && a3>a1)
        {
            if(a2>a1)
            {
               fl=a2; 
            }
            else
            {
                fl=a1;
            }
        }
        char s=(char)fl;
        System.out.println (s);
        return s;
	}
	
}