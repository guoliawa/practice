package practice.test;

import java.util.LinkedList;

public class LinkedListTest {
	private static void testLinkedListAPIs() {
		String val = null;
		LinkedList llist = new LinkedList();
		llist.add("1");
		llist.add("2");
		llist.add("3");
		
		llist.add(1,"4");
		System.out.println("\nTest \"addFirst(), removeFirst(), getFirst()\"");
		llist.addFirst("10");
		System.out.println("llist:" + llist);
		System.out.println("llist.removeFirst():" + llist.removeFirst());
		System.out.println("llist:" + llist);
		System.out.println("llist.getFirst():" +llist.getFirst());
		
		System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");
		llist.offerFirst("10");
		System.out.println("llist:" + llist);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testLinkedListAPIs();
	}

}
