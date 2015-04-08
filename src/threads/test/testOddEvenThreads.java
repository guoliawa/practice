package threads.test;


public class testOddEvenThreads {
	
	public static void main(String[] args) {
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
	}
}
