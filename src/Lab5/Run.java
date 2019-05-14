package Lab5;

import java.util.LinkedList;
import java.util.Scanner;

public class Run {
	private static Scanner sinput = new Scanner(System.in);
	private static LinkedList<Dictionary> listDictionary = new LinkedList<Dictionary>();
	private static Dictionary dictionary ;
	private static String in;
	public void menu() {
		System.out.println("======== Dictionary program ========");
		System.out.println("1.	Add Word");
		System.out.println("2.	Delete Word");
		System.out.println("3.	Translate");
		System.out.println("4.	Exit");
		System.out.println("5.	Show");
		System.out.println("====================================");
	}
	public static void main(String[] args) {
		Run r = new Run();
		int choose=0;
		while(true) {
			r.menu();
			try {
//				choose = Integer.parseInt(sinput.nextLine());
				choose = sinput.nextInt();
				sinput.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}
			switch (choose) {
			case 1:
				addWord();
				break;
			case 2:
				deleteWord();
				break;
			case 3:
				translate();
				break;
			case 4:
				System.exit(0);
				break;
			case 5:
				show();
			default:
				break;
			}
			
		}
		
		
	}
	private static void show() {
		for(Dictionary dic : listDictionary) {
			System.out.println(dic);
		}
		
	}
	private static void translate() {
		System.out.println("Enter English :");
		in = sinput.nextLine();
		for(Dictionary dic: listDictionary) {
			if(dic.getWordEnglish().equalsIgnoreCase(in)) {
				System.out.println("Vietnamese: "+ dic.getWordVietnamese());
			}
		}
		
	}
	private static void deleteWord() {
		System.out.println("Enter English (to delete):");
		for(Dictionary dic : listDictionary) {
			if(dic.getWordEnglish().equalsIgnoreCase(sinput.nextLine())) {
				listDictionary.remove(dic);
			}else continue;
			
		}
		
	}
	private static void addWord() {
		int count=0;
		while(count < 2) {
			
			dictionary = new Dictionary();
			System.out.println("Enter English: ");
			in = sinput.nextLine();
			dictionary.setWordEnglish(in);
			
			System.out.println("Enter Vietnamese: ");
			in = sinput.nextLine();
			dictionary.setWordVietnamese(in);
			System.out.println("Successefully !");
			//add dictionary to linked list dictionary
			listDictionary.add(dictionary);
			count++;
		}
		
		
		
	}
}
