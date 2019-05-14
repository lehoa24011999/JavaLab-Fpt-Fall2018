package Lab6;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {

	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		
		while(true) {
			
			System.out.println("================= Validate Program ===========");
			System.out.println("1.Check Phone");
			System.out.println("2.Check Email");
			System.out.println("3.Check Date");
			System.out.println("4.Exit");
			int choose = 0;
			try {
				 choose = input.nextInt();
				 input.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter number !");
			}
			switch (choose) {
			case 1:
				phone();
				break;
			case 2:
				email();
				break;
			case 3:
				date();
				break;
			case 4:
				System.exit(0);
				break;

			default:
				break;	
			}
		}
		
		
		
		
	}

	private static void date() {
		String date;
		while (true) {
			System.out.println("Enter Date: ");
			date = input.nextLine();
			if(isValidDate(date)) {
				System.out.println("Correct !");
				break;
			}
			else System.out.println("Please check again!");
		}
		
		
	}
	
	 public static boolean isValidDate(String d) 
	    { 
	        String regex = "(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	        Pattern pattern = Pattern.compile(regex); 
	        Matcher matcher = pattern.matcher((CharSequence)d); 
	        return matcher.matches(); 
	    } 
	private static void email() {
		String email;
		while(true) {
			System.out.println("Enter email: ");
			email = input.nextLine();
			if(isValid(email)) {
				System.out.println("Correct !!");
				break;
			}
			else System.out.println("Wrong !");
			
			
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

	private static void phone() {
		String phone;
		while(true) {
			System.out.println("Phone Number: ");
			phone = input.nextLine();
			if(!isNumber(phone)) {
				System.out.println("The phone number must be number");
				if(phone.length() != 10) {
					System.out.println("The phone number must be 10 digits");
				}
				else break;
			}else {
				if(phone.length() != 10) {
					System.out.println("The phone number must be 10 digits");
				}
				else break;
			}

			
		}
		
	}
	private static boolean isNumber(String phone) {
		
		try {
			Double.parseDouble(phone);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

}
