package Lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
interface DateMatcher2 {
	boolean matches(String date);
}
public class RunExpense{

	private static Scanner input=new Scanner(System.in);
	private static int choose;
	private static int countId=1;
	private static LinkedList<Expense> listExpense=new LinkedList<Expense>();
	private static Pattern DATE_PATTERN = Pattern.compile(
			"^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
					+ "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
					+ "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
					+ "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
	public static void main(String[] args){

		while(true) {
			try {
				System.out.println("============ Expensing Management ===============");
				System.out.println("1.Add an expense");
				System.out.println("2.Display all expense ");
				System.out.println("3.Remove an expense ");
				System.out.println("4.Exit");

//				input = new Scanner(System.in);
				choose = Integer.parseInt(input.nextLine());

			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				addExpense();
				break;
			case 2:
				displayExpense();
				break;
			case 3:
				removeExpense();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				break;
			}

		}

	}

	private static void removeExpense() {
		int flag=0;
			try {
				System.out.println("Please enter id you want to remove!");
				int id=Integer.parseInt(input.nextLine());
				for(Expense ex: listExpense) {
					if(ex.getId()==id) {
						listExpense.remove(ex);
						displayExpense();
						flag=1;
						break;
					}else {
						continue;
					}
				}
				if(flag==0) {
					System.out.println("Delete expense failed!.");
				}

			} catch (Exception e) {
				System.out.println("Please id must be the number!");
			}

	}



	private static void displayExpense() {
		System.out.println("|-------------------------------------------------------------------------------------------|");
		System.out.println("|                   	                 The Expense                                        |");
		System.out.println("|-------------------------------------------------------------------------------------------|");
		System.out.println("| ID |\t\t\t Date \t\t\t|     Amount of money    |      Content     |");
		System.out.println("|----|------------------------------------------|------------------------|------------------|");
		for(Expense ex: listExpense) {
			System.out.println(ex);
		}
		System.out.println("|----|------------------------------------------|------------------------|------------------|");


	}

	private static void addExpense() {
		Expense charge=new Expense();
		id(charge, countId);
		content(charge);
		number(charge);
		date(charge);
		countId++;
		listExpense.add(charge);

	}

	private static void number(Expense charge) {
		while(true) {

			try {
				System.out.println("Enter amount of money: ");
				int number=Integer.parseInt(input.nextLine());
				charge.setNumber(number);
				break;
			} catch (Exception e) {
				System.out.println("Please the amount of money must be number!");
			}
		}

	}

	private static void content(Expense charge) {
		System.out.println("Please enter content of charge: ");
		charge.setContent(input.nextLine());

	}

	private static void date(Expense charge) {
		/*Get current time
		 * */
		//		Date date = Calendar.getInstance().getTime();  
		//	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		//	    String strDate = dateFormat.format(date);  

		// Get time from user
		while(true) {

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
			System.out.println("Please enter date of charge: (yyyy-MM-dd)");
			String strDate=input.nextLine();
			if(isValidDate(strDate)) {
				Date date;
				try {
					date = sdf.parse(strDate);
					charge.setDate(date);// if the parsing ok then the charge object would be saved time
					break;
				} catch (ParseException e) {
					System.out.println("Please should be followed the partern time !");
				}
			} else
				try {
					throw new Exception();
				} catch (Exception e) {
					System.out.println("Please enter correctly date!");


				}
		}

	}
	public static boolean isValidDate(String date) {
		return DATE_PATTERN.matcher(date).matches();
	}


	private static void id(Expense charge, int countId) {
		System.out.println("My system would be count automatically id!(^_^)");
		charge.setId(countId);
		System.out.println("The id of charge is: "+ countId);
	}


}
