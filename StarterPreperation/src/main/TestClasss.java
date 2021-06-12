
public class TestClasss {
	static String[] dir = {"North", "South", "East", "North", "South", "West"};
		//{ "North", "East", "West", "South", "East", "East" };
	static int flag = 0;
	static void removeValues() {
		int len = flag;
		for (int i = 0; i < dir.length - 1; i++) {
			if ((dir[i].equals("North") && dir[i + 1].equals("South")) || (dir[i + 1].equals("North") && dir[i].equals("South") )) {
				remove(i);
				remove(i);
			} else if ((dir[i].equals("East") && dir[i + 1].equals("West") ) || (dir[i + 1].equals("East") && dir[i].equals("West") )) {
				remove(i);
				remove(i);
			}
		}

		if (len != flag) {
			removeValues();
		}
		return;
	}

	static void remove(int i) {
		int indx = 0;
		for (indx = i; indx < dir.length-1; indx++) {
			dir[indx] = dir[indx + 1];
		}
		
		dir[indx] = "";
		flag++;
	}
	static void printArray(){
		System.out.println();
		for(int i=0; i<dir.length; i++){
			System.out.print(dir[i]+" ");
		}
	}
	public static void main(String[] args) {
		removeValues();
		printArray();
	}

}
