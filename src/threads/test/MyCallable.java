package threads.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Callable c1 = new MyCallable();
        Future f1 = pool.submit(c1);
        System.out.println(f1.get());
        pool.shutdown();
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		
		return Integer.valueOf(sum);		
	}

}
