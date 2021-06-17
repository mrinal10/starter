/**
 * @(#)thread.java
 *
 *
 * @author 
 * @version 1.00 2014/12/23
 */
 
 class threadnew implements Runnable{
 	Thread t;
 	
 	threadnew()
 	{
 		t=new Thread(this,"Demo Thread");
 		t.start();
 	}
 	
 	public void run()
 	{
 		try{
 			for(int i=5;i>0;i--)
 			{
 				System.out.println ("Child Thread: "+i);
 				Thread.sleep(500);
 			}
 		}
 		catch(InterruptedException e)
 		{
 			System.out.println ("Interrupt");
 		}
 		System.out.println ("Exiting Child Thread");
 	}
 }
 
 class Thde{
 	public static void main (String[] args) {
 		new threadnew();
 		try{
 		for(int i=5;i>0;i--)
 		{
 			System.out.println ("main Thread: "+i);
 			Thread.sleep(1000);
 		}
 		}
 		catch(InterruptedException e){
 			System.out.println ("Main Thread Interrupted");
 		}
 		System.out.println ("Exiting main Thread");
	}
 }