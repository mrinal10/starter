

class Person { public int number; }

class Test_Person{
	public void doIt(int i , Person p){
		i = 5;
		p.number = 8;
	}

	public static void main(String args[]){
		int x = 0;
		Person p = new Person();
		new Test_Person().doIt(x, p);
		System.out.println(x + " " + p.number);
	
	}
}