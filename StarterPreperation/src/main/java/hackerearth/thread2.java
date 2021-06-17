class newthread extends Thread{
	newthread(){
		super("Demo Thread");
		System.out.println ("child Thread: "+this);
		start();
	}
	
	public void run(){
		try{
			for(int i=0;i<5;i++){
				System.out.println ("child thread:"+i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println ("Exception");
		}
	}
}

class extendthread{
	public static void main (String[] args) {
		new newthread();
		
	}
}