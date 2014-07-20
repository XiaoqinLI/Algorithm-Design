package java_intermediate_training;

public class MainMultiThreading {

	public static void extendingThreadClass(){
		int iterations = 3;
		 
		MyThread thread = new MyThread();		 
		thread.start();	
		 
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
		System.out.println("Called interrupt()");
		 
		 MyRunnable runnable = new MyRunnable();
		 new Thread(runnable).start();
		 
		 try {
			for (int i = 0; i < iterations; i++){
				 System.out.println("from main process");
				 Thread.sleep(3000);
			 }
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
	// preventing these thread from using shared resources simultaneously
	public static void synchronizingThread(){
		
		TargetClass target = new TargetClass();
		
		MyThreadSyn t1 = new MyThreadSyn(1, target);
		MyThreadSyn t2 = new MyThreadSyn(2, target);
		MyThreadSyn t3 = new MyThreadSyn(3, target);
		
		t1.start();
		t2.start();
		t3.start();

	}
	
	public static void main(String[] args) {
		System.out.println("-------------extendingThreadClass-----------");
		extendingThreadClass();
		System.out.println("-------------synchronizingThread-----------");
		synchronizingThread();
	 
	}

}
