package Lab8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import Lab7.DataCSV;

public class RunStudent {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Student> listStudent = new ArrayList<Student>();
	private static LinkedList<Student> listStudent1 = new LinkedList<Student>();
	private static HashMap<String , Student> mapStudent = new HashMap<>();
	private static Scanner lineScan;
	
	public static void main(String[] args) throws IOException {

		while(true) {
			System.out.println("========== Managing Student ===========");
			System.out.println("1.Add Student");
			System.out.println("2.Report");
			System.out.println("3.Exit");
			System.out.println("=======================================");

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
				add();
				break;
			case 2:
				display();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				break;
			}


		}
	}



	private static void display() {
//		LinkedList<Student> lsStudent = readfile("D://listStudent.txt");
//		Collections.sort(lsStudent);
//		System.out.println("After sort list student: ");
//		for(Student stu: lsStudent) {
//			System.out.println(stu);
//		}
		for(Map.Entry x:mapStudent.entrySet()){  
			System.out.println(x.getKey()+" "+x.getValue());  
		}  
	}


	private static void add() {
	
			Student s=new Student();
			System.out.println("Enter ID: ");
			
			String id = input.nextLine(); 
//			s.setCode(input.nextLine());
			System.out.println("Enter NAME: ");
			s.setName(input.nextLine());
			checkEmail(s);
			checkPhone(s);
			System.out.println("Enter ADDRESS:");
			s.setAddress(input.nextLine());
//			listStudent1.add(s);// dd
			mapStudent.put(id, s);
			if (savefile(listStudent1, "D://listStudent.txt")) {
				System.out.println("SAVED! ");
			}else {
				System.out.println("FAILD!");
			}
	

	};


	private static void checkPhone(Student s) {
		
		while(true) {
			try {
				System.out.println("Enter PHONE:");
				String phone = input.nextLine();
				if(isNumber(phone) && phone.length()==10) {
					s.setPhone(phone);
					break;
				}else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Please phone must be number and must be 10 digits");
			}
			
		}
		
	}



	private static boolean isNumber(String phone) {
		try {
			double d = Double.parseDouble(phone);
			return true;
		} catch (Exception e) {
			return false;
		}
	}



	private static void checkEmail(Student s) {
		String email;
		while(true) {
			try {
				System.out.println("Enter EMAIL: ");
				email = input.nextLine();
				if(isValid(email)) {
					s.setEmail(email);
					break;
				}
				else throw new Exception();
				
			} catch (Exception e) {
				System.out.println("Please check again email (ex: hoa@gmail.com)");
			}
			
			
			
		}

	
	}
	
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 



	public static LinkedList<Student> readfile (String path){
		listStudent1= new LinkedList<Student>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line!= null) {
				String arr[] = line.split(";");
				if(arr.length==5) {
					Student kh =new Student(arr[0], arr[1], arr[2], arr[3], arr[4]);
					listStudent1.add(kh);
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStudent1;
	}
	public static boolean savefile(LinkedList<Student>dskh, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for(Student kh : dskh) {
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
