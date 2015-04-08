package practice.test;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		for (int i = 1; i < 6; i++) {
			stack.push(String.valueOf(i));
		}
		
		iteratorThroughRandomAccess(stack);
		
		int pos = stack.search("2");
		System.out.println("The position of 2 is:" + pos);
		
		stack.pop();
		iteratorThroughRandomAccess(stack);
		
		String val = (String)stack.peek();
		System.out.println("peek: " + val);
		iteratorThroughRandomAccess(stack);
		
		iteratorThroughIterator(stack);
	}

	public static void iteratorThroughRandomAccess(List list){
	    String val = null;
	    for (int i = 0; i < list.size(); i ++) {
	    	val = (String)list.get(i);
	    	System.out.print(val+" ");
	    }
	    System.out.println();
	}
	
	
	public static void iteratorThroughIterator (List list){
	    String val = null;
	    for (Iterator iter = list.iterator();iter.hasNext();) {
	    	val = (String) iter.next();
	    	System.out.print(val+" ");
	    }
	    System.out.println();
	}
 }
