package threads.test;

public class threadOddEven {
	
	volatile int target = 1;
	
	public synchronized void printOdd () {
		for (int i = 1; i < 100; i = i+2) {
			while (target == 2) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
			target = 2;
			notifyAll();
		}
	}
	
	public synchronized void printEven () {
		for (int i = 2; i < 100; i = i+2) {
			while (target == 1) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " "  + i);
			target = 1;
			notifyAll();
		}
	}
	
}
