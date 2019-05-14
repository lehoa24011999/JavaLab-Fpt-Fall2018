package Lab7;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Test {
	
	private static Scanner in;
	private static Scanner lineScan;

	public static void main(String[] args) {
		//separating name by Scanner
//		
//		 in = new Scanner(System.in);
//	     System.out.print("Input a Sentence: ");
//		 String line = in.nextLine();
//		 String upper_case_line = ""; 
//	       lineScan = new Scanner(line); 
//	         while(lineScan.hasNextLine()) {
//	             String word = lineScan.nextLine(); 
//	             upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " "; 
//	         }
//	      System.out.println(upper_case_line); 
	      
		
		
	       StringTokenizer st = new StringTokenizer("      Cau Giay-Ha  Noi  -  Viet   Nam ","-");
	       StringTokenizer st1;
           String upper_case_line ="";
       		String result ="";
		while (st.hasMoreTokens()) {
        	   	String token = st.nextToken().toString();
        	   	st1 = new StringTokenizer(token);
        	   	while(st1.hasMoreTokens()) {
        	   		String token1 = st1.nextToken().toString();
    	   			upper_case_line += Character.toUpperCase(token1.charAt(0)) + token1.substring(1) + " "; 
    	   			System.out.println("Token1 is: " + token1);
        	   	}
        	   	System.out.println("After Token1: "+ upper_case_line);
        	   	if(st.countTokens() == 0) {// the last token in String_tokenizer cause its count down
        	   		result	+= upper_case_line + "";
        	   	}else {
            		result	+= upper_case_line + "- ";
            		upper_case_line="";
        	   	}

        	   	System.out.println("Token is: " + token);
	   		
           }
	           System.out.println(result); 
	           
	     }  


	}

