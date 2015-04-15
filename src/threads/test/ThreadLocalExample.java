package threads.test;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalExample obj = new ThreadLocalExample();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(obj, "" + i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread name = " + Thread.currentThread().getName()
				+ " default Formatter = " + formatter.get().toPattern());
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		formatter.set(new SimpleDateFormat());

		System.out.println("Thread Name= " + Thread.currentThread().getName()
				+ " formatter = " + formatter.get().toPattern());
	}
}
