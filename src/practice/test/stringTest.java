package practice.test;

public class stringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1 = "wgl";
        
        String s2 = " is good";
        String ss = null;
        String s3 = null;
        try {
        	s3 = s1 + ((ss == null) ? ss : ss.toUpperCase()) ;
        } catch (Exception e) {
        	
        }
        ss.toUpperCase();
        System.out.println("The result is: " + s3);
	}

}
