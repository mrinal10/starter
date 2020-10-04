import java.util.ArrayList;

public final class TestClass {
	private final int abc;
	private final ArrayList<Integer> alist;
	
	TestClass(int value, ArrayList<Integer> bList) {
		abc = value;
		alist = bList;
	}
	
	public int getAbc() {
		return abc;
	}
	public ArrayList<Integer> getAlist() {
		return alist;
	}	
	
}

class T{
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(50);
		
		TestClass t = new TestClass(1, a);
		
		ArrayList<Integer> newList = t.getAlist();
		newList.add(300);
	}
}
