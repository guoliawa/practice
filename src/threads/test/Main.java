package threads.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// {
		// Deque<Event> deque = new ArrayDeque<Event>();
		// WriterTask writer = new WriterTask(deque);
		// for (int i = 0; i < 3; i++) {
		// Thread thread = new Thread(writer);
		// thread.start();
		// }
		//
		// CleanerTask cleaner = new CleanerTask(deque);
		// cleaner.start();
		//
		// ThreadGroup tg = new ThreadGroup("haha");
		// }
		
//		{
//			PrintQueue printQueue = new PrintQueue();
//			Thread thread[] = new Thread[10];
//			for (int i = 0; i < 10; i++) {
//				thread[i] = new Thread(new Job(printQueue), "Thread" + i);
//			}
//
//			for (int i = 0; i < 10; i++) {
//				thread[i].start();
//			}
//
//		}
		
		{

			Integer a = 1;
			Integer b = 2;
			Integer c = 3;
			Integer d = 3;
			Integer e = 321;
			Integer f = 321;
			Long g = 3L;
			System.out.println(c == d);
			System.out.println(e == f);
			System.out.println(c == (a + b));
			System.out.println(c.equals(a + b));
			System.out.println(g == (a + b));
			System.out.println(g.equals(a + b));
			
			String s1 = "abc";
			String s2 = new String("abc");
			System.out.println(s1 == s2);

		}
	}

}
