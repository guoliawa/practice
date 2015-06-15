package practice.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        ss.indexOf("s");
//        ss.toUpperCase();
//        System.out.println("The result is: " + s3);
        
        String line1 = "    if (";
        String line3 = "ift ";
        String line2 = " tif ()";
        
        Pattern regex = Pattern.compile("[\\s]if[\\s]");
        Matcher m = regex.matcher(line3); 
        while (m.find()) {  
        	System.out.println("The result is: " + m.group()); 
        }  
        
        System.out.println("The result is: " + line1.indexOf(" if "));        
        
	}

}
