package practice.test;

import java.util.*;

public class VectorTest {
	
	private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
        	 System.out.println("RandomAccess implemented!");
        } else {
        	 System.out.println("RandomAccess not implemented!");
        }
	}
	
	public static void iteratorThroughRandomAccess (List list) {
	    long startTime;
	    long endTime;
	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < list.size(); i++) {
	    	list.get(i);
	    }
	    endTime = System.currentTimeMillis();
	    long interval = endTime -startTime;
	    System.out.println("iteratorThroughRandomAccess: " + interval + "ms");  
	}
	
	public static void iteratorThroughIterator (List list) {
	    long startTime;
	    long endTime;
	    startTime = System.currentTimeMillis();
	    for (Iterator iter = list.iterator(); iter.hasNext(); ) {
	    	iter.next();
	    }
	    endTime = System.currentTimeMillis();
	    long interval = endTime -startTime;
	    System.out.println("iteratorThroughIterator: " + interval + "ms");  
	}
	
	public static void iteratorThroughFor2 (List list) {
	    long startTime;
	    long endTime;
	    startTime = System.currentTimeMillis();
	    for (Object obj: list) {
	    }
	    endTime = System.currentTimeMillis();
	    long interval = endTime -startTime;
	    System.out.println("iteratorThroughFor2: " + interval + "ms");  
	}
	
	public static void iteratorThroughEnumeration (Vector vec) {
	    long startTime;
	    long endTime;
	    startTime = System.currentTimeMillis();
	    for (Enumeration enu = vec.elements(); enu.hasMoreElements(); ) {
	    	enu.nextElement();
	    }
	    endTime = System.currentTimeMillis();
	    long interval = endTime -startTime;
	    System.out.println("iteratorThroughEnumeration: " + interval + "ms");  
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vec = new Vector();
		for (int i = 0; i < 100000; i ++) {
			vec.add(i);
		}
		iteratorThroughRandomAccess(vec);
		iteratorThroughIterator(vec);
		iteratorThroughFor2(vec);
		iteratorThroughEnumeration(vec);
	}

}
