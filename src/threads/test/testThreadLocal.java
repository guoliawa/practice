package threads.test;

public class testThreadLocal implements Runnable{

	private ThreadLocal<Integer> threadLocal =
            new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testThreadLocal sharedRunnableInstance = new testThreadLocal();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		threadLocal.set( (int) (Math.random() * 100D) );
		
        for (int i = 0; i < 100; i++) {
        	System.out.println(Thread.currentThread().getName() + "will output " + threadLocal.get());
        }
	}

}
