package threads.test;

public class Job implements Runnable {

	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Going to print a job\n", Thread.currentThread()
				.getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", Thread
				.currentThread().getName());
	}

}
