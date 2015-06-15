import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class onLineTest {
	private static int levelIndex = 2;
	
	public static void countIf1File(File javaFile) {
		StringBuilder resultString = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(javaFile));
			String tempLine = null;
			int curLineNum = 0;
			int sumIf = 0;
			HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
			Pattern regex = Pattern.compile("\\sif\\s");
			Matcher matcher = regex.matcher("");
			
			while ((tempLine = reader.readLine()) != null) {
				curLineNum++;
				matcher.reset(tempLine);
                while(matcher.find()) {
                	sumIf ++;
                	positions.put(curLineNum, matcher.start() + 2);
                	break;
                }
			}
			
			resultString.append("Totally " + "in file " + javaFile.toString() + ": " + sumIf + "\n");
			for (Integer lineNum : positions.keySet()) {
				resultString.append("Position : (" + lineNum + ", " + positions.get(lineNum) + ")" + "\n");
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resultString);
	}
	
	
	public static void countNestIf(File javaFile) {
		StringBuilder resultString = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(javaFile));
			String tempLine = null;
			int curLineNum = 0;
			int levelIf = -1;
			int sumNestIf = 0;
			HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
			Pattern regex = Pattern.compile("\\sif\\s");
			Matcher matcher = regex.matcher("");
			
			Stack<String> stack = new Stack<String>();
			
			
			while ((tempLine = reader.readLine()) != null) {
				curLineNum++;
				
                if (tempLine.contains("}") && !stack.empty() && stack.peek().equals("{")) {
                	stack.pop();
                	
                	if (stack.peek().contains("if")) {                		
                		String[] levelInfo = stack.peek().split(":");
                		String levelStr = levelInfo[levelIndex];
                		int level = Integer.valueOf(levelStr);
                		if (level > 0) {
                			sumNestIf++;
                			resultString.append(stack.peek() + "\n");
                			stack.pop();
                			levelIf--;
                		}
                	    
                	}
                }
				
				matcher.reset(tempLine);
				
                while(matcher.find()) {
                	levelIf ++;
                	positions.put(curLineNum, matcher.start() + 2);
                    stack.push("if " + "Position : (" + curLineNum + ", " + (matcher.start() + 2) + ")" + "Level :" + levelIf); 
                    if ( tempLine.contains("{")) {
						stack.push("{");
                    }
                	break;
                }	
			}
			
			resultString.append("Totally nesting if number in file " + javaFile.toString() + " is : " + sumNestIf + "\n");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resultString);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        if (args == null || args.length == 0) System.out.println("Please input one Java File !");
        if (args.length == 1) {
        	File inputFile = new File(args[0]);
        	countIf1File(inputFile);
        	countNestIf(inputFile);
        } else if (args.length > 1) {
        	File resultFile = new File("D:\\MyData\\result.log");
        	for (final String file : args) {
        		new Thread () {
        			public void run() {
        				countIf1File(new File(file));
        				countNestIf(new File(file));
        			}
        		}.start();
        	}	
        }
	}

}

