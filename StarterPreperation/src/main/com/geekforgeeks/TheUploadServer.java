package com.geekforgeeks;

import java.util.Scanner;

class Main{

    private static boolean isValidName(String name){
		try {
			long l = Long.parseLong(name);
			return false;
		} catch (Exception e) {
		}
		name = name.trim();
		if (name.length()<1 && name.length()>15) {
			return false;
		}
		return true;
	}
	
	private static boolean isANumber(String s){
	    //System.out.println(s+" ::::::: "+s.length());
		//if (s.length()>33 || s.length()<1) {
		//	return false;
		//}
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int asciiValue = (int) c[i];
			if (asciiValue<48 || asciiValue>57) {
				return false;
			}
		}
		int dtartingIndx = 0;
		for (int i = 0; i < c.length; i++) {
			if ( Integer.parseInt(String.valueOf(c[i]))==0 ) {
				dtartingIndx++;
			}else{
				break;
			}
		}
		if (dtartingIndx==c.length) {
			return false;
		}
		for (int i = dtartingIndx; i < c.length; i++) {
			int asciiValue = (int) c[i];
			if (asciiValue<48 || asciiValue>57) {
				return false;
			}
		}
		return true;
	}
	
    public static void process_data(String a, String b){
        /*
            Complete this function to check if the data is a music or not
        */
        if( (isValidName(a) && isANumber(b)) || (isValidName(b) && isANumber(a))){
            System.out.println("M");
        }else{
            System.out.println("N");
        }
    }

    public static void process_data(String a, String b, String c){
        /*
            Complete this function to check if the data is a video or not
        */
        if( (isValidName(a) && isANumber(b) && isANumber(c)) ||
            (isValidName(b) && isANumber(a) && isANumber(c)) ||
            (isValidName(c) && isANumber(b) && isANumber(a)) ){
            System.out.println("V");
        }else{
            System.out.println("N");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String s = sc.nextLine();
		while(n-->0){
			s = sc.nextLine();
			s = s.trim();
			String[] strArray = s.split(" ");
			if (strArray.length!=2 && strArray.length!=3) {
				System.out.println("N");
			}else if(strArray.length==2){
				process_data(strArray[0], strArray[1]);
			}else{
				process_data(strArray[0], strArray[1], strArray[2]);
			}
		}
		sc.close();    
    }
}