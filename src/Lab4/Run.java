package Lab4;


import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Lab10.SaveAndReadFile;



public class Run {
	
	
	
	private static Scanner input;
	private static ArrayList<Worker> listWorker = new ArrayList<Worker>();
	private static Worker worker;
	
	public void menu() {
		System.out.println("============ Worker Management ===============");
		System.out.println("1.Add worker");
		System.out.println("2.Up salary ");
		System.out.println("3.Down salary ");
		System.out.println("4.Display information salary");
		System.out.println("5.Exit");
		System.out.println("6.Save file");
		System.out.println("7.read file ");
		System.out.println("Enter 1 to add worker, 2 to increase salary, "
				+ "3 to decrease salary, 4 to export information salary, 5 to exit, 6 to save file, 7 to read file");
		
	}
	public static void main(String[] args) {
		Run r = new Run();
		int choose = 0;
		while(true) {
			try {
				r.menu();
				input = new Scanner(System.in);
				choose = input.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
				case 1:
					addWoker();
					break;
				case 2:
					upSalary();
					break;
				case 3:
					downSalary();
					break;
				case 4:
					showInformation();
					break;
				case 5:
					System.out.println("Sayonara ! Goodbye! Tam biet !");
					System.exit(0);
					break;
				case 6:
					saveList();
					break;
				case 7:
					readList();
					break;
				default:
					break;
				}
			
		}
	
	}
	private static void readList() {
		ArrayList<Worker> listRead = SaveAndReadFile.readfile("D://listworker1.txt");
		System.out.println("================= Worker list ============");
		for(Worker w : listRead) {
			System.out.println(w);
		}
		System.out.println("=========================================");
		
	}
	private static void saveList() {
		boolean check = SaveAndReadFile.savefile(listWorker, "D://listworker1.txt");
		if(check == true) {
			System.out.println("Save file successfully! ");
			
		}else {
			System.out.println("Save file faifully!");
		}
		
		
	}
	private static void showInformation() {
		for(Worker w: listWorker) {
			w.print();
			
		}
		
	}
	private static void downSalary() {
		 Date date = Calendar.getInstance().getTime();  
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
         String strDate = dateFormat.format(date);  
		
		int salary;
		String id;
		input = new Scanner(System.in);
		System.out.println("Enter ID needed to decrease salary: ");
		id = input.nextLine();
		while(true) {
			try {
				input = new Scanner(System.in);
				System.out.println("Enter mount of decreasing salary: ");
				salary = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter number !");
			}
		}
		for(Worker w : listWorker) {
			if(w.getId().equalsIgnoreCase(id)) {
				w.setSalary(w.getSalary() - salary);
				w.setState("DOWN");
				w.setDateChange(strDate);
				break;
			}else {
				continue;
			}
		}
		
		for(Worker w: listWorker) {
			System.out.println(w);
		}
	}
	private static void upSalary() {
		Date date = Calendar.getInstance().getTime();  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    String strDate = dateFormat.format(date);  
		int salary;
		String id;
		input = new Scanner(System.in);
		System.out.println("Enter ID needed to increase salary: ");
		id = input.nextLine();
		while(true) {
			try {
				input = new Scanner(System.in);
				System.out.println("Enter mount of increasing salary: ");
				salary = input.nextInt();
				//adding state
				
				break;
			} catch (Exception e) {
				System.out.println("Please enter number !");
			}
		}
		for(Worker w : listWorker) {
			if(w.getId().equalsIgnoreCase(id)) {
				w.setSalary(salary + w.getSalary());
				w.setState("UP");
				w.setDateChange(strDate);
				break;
			}else {
				continue;
			}
		}
		
		for(Worker w: listWorker) {
			System.out.println(w);
		}
	}
	private static void addWoker() {
		int count = 0;
		while(count<3) {
			worker = new Worker();
			checkId();
			System.out.println("Enter NAME: ");
			String name = input.nextLine();
			worker.setName(name);
			checkAge();
			checkSalary();
			input = new Scanner(System.in);// remember
			System.out.println("Enter WORKLOCATION: ");
			String workLocation = input.nextLine();
			worker.setWorkLocation(workLocation);
			
			listWorker.add(worker);
			count++;
		}
		
	}
	private static void checkSalary() {
		int salary;
		while(true) {
			try {
				input = new Scanner(System.in);
				System.out.println("Enter SALARY: ");
				salary = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Enter Number!");
			}
		}
		if(salary < 0) {
			System.out.println("Salary hava to greater 0! ");
			checkSalary();
		}
		else {
			worker.setSalary(salary);
		}
			

		
	}
	private static void checkAge() {
		int age;
		while(true) {
			try {
				input = new Scanner(System.in);
				System.out.println("Enter AGE: ");
				age = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}

		}
		
		if(age <18 || age >50) {
			System.out.println("Please make sure age must be greater than 18 and less than 50");
			checkAge();
		}
		else {
			worker.setAge(age);
		}
		
		
	}
	private static void checkId() {
		while(true) {
			input = new Scanner(System.in);// remember initialation scanner
			System.out.println("Enter ID:");
			String id = input.nextLine();
			try {
				if( Duplicated(id) || isNull(id)) {
					throw new Exception();
				}else {
					worker.setId(id);
				}
				break;
			} catch (Exception e) {
				System.out.println("Plese check null and duplicated !");
			}
		}
		
	}
	private static boolean Duplicated (String id) {
		for(Worker w : listWorker) {
			if(w.getId().equalsIgnoreCase(id)) 
				return true;
		}
		return false;
	}
	private static boolean isNull (String id) {
		if(id.isEmpty()) {
			return true;
		}
		return false;
	} 
	
	

}
