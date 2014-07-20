package java_intermediate_training;

public class MyThreadSyn extends Thread {

	private int threadId;
	private TargetClass target;

	public MyThreadSyn(int threadId, TargetClass target){
		this.threadId = threadId;
		this.target = target;
	}

	@Override
	public void run() {
		int iterations = 5;

		synchronized (target) {
			try {
				sleep(2000);

			} catch (InterruptedException e) {
				System.err.println("Thread Interrupted.");
			}

			target.call(threadId);
		}


	}

}
