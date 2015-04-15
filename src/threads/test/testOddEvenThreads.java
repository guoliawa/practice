package threads.test;


public class testOddEvenThreads {
	
	public static void main(String[] args) throws Exception {
		final threadOddEven tOE = new threadOddEven();
		
        Thread tO = new Thread () {
			public void run() {
				tOE.printOdd();
			}
        };
        
        Thread tE = new Thread () {
			public void run() {
				tOE.printEven();
			}
        };
        
        tO.start();
        tE.start();
        
		tO.join();
		tE.join();
        
        System.out.println(Thread.currentThread().getName() + " end now!");
	}
}
