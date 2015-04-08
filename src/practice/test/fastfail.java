package practice.test;

import java.util.*;

public class fastfail {
	
	private static List list = new ArrayList();

	private static void printAll() {
		System.out.println("");
		String value = null;
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			value = (String) iter.next();
			System.out.print(value + ",");
		}
	}
	
	private static class ThreadOne extends Thread {
		public void run() {
			int i = 0;
			while (i < 6) {
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
		}
	}
	
	private static class ThreadTwo extends Thread {
		public void run() {
			int i = 10;
			while (i < 16) {
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ThreadOne().start();
        new ThreadTwo().start();
	}

}
