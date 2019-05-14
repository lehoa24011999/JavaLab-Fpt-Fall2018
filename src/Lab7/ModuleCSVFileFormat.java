package Lab7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;





public class ModuleCSVFileFormat {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<DataCSV> lsData = new ArrayList<DataCSV>();
	private static Scanner lineScan;
	public static void main(String[] args) throws IOException {
		
		while(true) {
			System.out.println("========== Format CSV Program ===========");
			System.out.println("1.Import CSV");
			System.out.println("2.Format Address");
			System.out.println("3.Format Name");
			System.out.println("4.Export CSV");
			System.out.println("5.Exit");
			int choose=0;
			try {
				input = new Scanner(System.in);
				choose = input.nextInt();
				input.nextLine();
				
			} catch (Exception e) {
				System.out.println("Please enter number !");
			}
			switch (choose) {
			case 1:
				importCSV();
				break;
			case 2:
				formatAddress();
				break;
			case 3:
				formatName();
				break;
			case 4:
				exportCSV();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				break;
			}
			
			
		}
	}
	private static void exportCSV() {
		
		while(true) {
			System.out.println("Enter Path: ");
			String path = input.nextLine();
			
			try {
				savefile(lsData,path);
				break;
			} catch (Exception e) {
				System.out.println("Please Check path again !");
			}
			
		}

		
	}
	private static void formatName() {
//		 in = new Scanner(System.in);
//	     System.out.print("Input a Sentence: ");
//		 String line = in.nextLine();
		for(DataCSV data: lsData) {
			 String line=data.getName();//get name to format
			 String upper_case_line = ""; 
		       lineScan = new Scanner(line); 
		         while(lineScan.hasNext()) {
		             String word = lineScan.next(); 
		             upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " "; 
		         }
		         data.setName(upper_case_line);
		         System.out.println(upper_case_line.trim()); 
		      
		}
		
		System.out.println("Done");
		
	}
	private static void formatAddress() {
		for(DataCSV data :lsData) {
			  StringTokenizer st = new StringTokenizer(data.getAddress(),"-");
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
					data.setAddress(result);
		           	System.out.println(result); 
		      }
		System.out.println("Done!");
		
	}
	private static void importCSV()  {
		
		//CASE ONE: USE bufferedReader to read a file
		
		System.out.println("Enter Path: ");
		String path = input.nextLine();
//		// We need to provide file path as the parameter: 
//		  // double backquote is to avoid compiler interpret words 
//		  // like \test as \t (ie. as a escape sequence) 
//		  File file = new File(path); 
//		  
//		  BufferedReader br = new BufferedReader(new FileReader(file)); 
//		  
//		  String st; 
//		  while ((st = br.readLine()) != null) 
//		    System.out.println(st); 
		
		//CASE TWO : Using FileReader class to read file
//		
//		 FileReader fr = 
//			      new FileReader("C:\\Users\\pankaj\\Desktop\\test.txt"); 
//			  
//			    int i; 
//			    while ((i=fr.read()) != -1) 
//			      System.out.print((char) i); 
		
		//CASE THREE : Using Scanner class to read file
		
//		
//		File file = new File(path); 
//			    Scanner sc = new Scanner(file); 
//			  
//			    while (sc.hasNextLine()) 
//			      System.out.println(sc.nextLine()); 
		readfile(path);
		for(DataCSV data: lsData) {
			System.out.println(data);
		}
		
		
		
	}
	public static ArrayList<DataCSV> readfile (String path){
		lsData= new ArrayList<DataCSV>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line!= null) {
				String arr[] = line.split(",");
				if(arr.length==5) {
					DataCSV kh =new DataCSV(arr[0], arr[1], arr[2], arr[3], arr[4]);
					lsData.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsData;
	}
	public static boolean savefile(ArrayList<DataCSV>dskh, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for(DataCSV kh : dskh) {
				String line = kh.getCode()+";"+kh.getName()+";"+ kh.getEmail()+";"
				+ kh.getPhone()+";"+kh.getAddress();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}

}
