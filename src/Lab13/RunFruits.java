package Lab13;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

public class RunFruits {
	private static Scanner input=new Scanner(System.in);
	private static Hashtable<String, ArrayList<Fruits>> customerTable=new Hashtable<String, ArrayList<Fruits>>();;
	private static ArrayList<Fruits> listFruits=new ArrayList<Fruits>();
	private static ArrayList<Fruits> listFruitsOfCustomer;
	public static void main(String[] args) {


		int choose=0;
		while(true) {
			System.out.println("============ FRUIT SHOP SYSTEM ===============");
			System.out.println("1.	Create Fruit");
			System.out.println("2.	View orders");
			System.out.println("3.	Shopping (for buyer) ");
			System.out.println("4.	Exit");
			System.out.println("Enter 1 to add fruits, 2 view orders, "
					+ "3 for shopping, 4 to exit");
			System.out.println("==============================================");
			try {
				choose=Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				addFruits();
				break;
			case 2:
				viewOrder();
				break;
			case 3:
				forBuyer();
				break;
			case 4:
				System.exit(0);

			default:
				break;
			}

		}

	}
	private static void viewOrder() {

		//		Customer: Marry Carie
		//		Product | Quantity | Price | Amount
		//		1. Apple       3	          1$	3$
		//		2. Mango     2               2$              4$
		//		Total: 7$
		for(Entry<String, ArrayList<Fruits>>  m:customerTable.entrySet()){  
			int sum=0;
			String name=m.getKey();
			ArrayList<Fruits> listOfThisName= m.getValue();
			System.out.println("Customer: "+name);
			for(Fruits f: listOfThisName) {
				sum+=f.getPrice()*f.getQuantity();
				System.out.println("Product | Quantity | Price | Amount");
				System.out.println(f.getName()+"\t"+f.getQuantity()+"\t"+f.getPrice()+"\t"+f.getPrice()*f.getQuantity());
			}
			System.out.println("Total: "+sum+" $");
			sum=0;

		}  
	}
	//	private static void printList(Fruits name) {
	//		for(Fruits f: listFruitsOfCustomer) {
	//			if(f.getName().equalsIgnoreCase(name.getName())) {
	//				System.out.println("Product | Quantity | Price | Amount");
	//				System.out.println(f.getName()+"\t"+f.getQuantity()+"\t"+f.getPrice()+"\t"+f.getPrice()*f.getQuantity());
	//				break;
	//			}
	//		}
	//
	//	}
	private static void forBuyer() {

		listFruitsOfCustomer =new ArrayList<Fruits>();
		int sum=0;

		while(true) {

			Fruits f=new Fruits();
			System.out.println("==============List Of Fruits========");
			System.out.println("|++ Item ++| ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
			for(Fruits fru: listFruits) {
				System.out.println(fru);
			}
			System.out.println("====================================");
			try {
				System.out.println("Enter id of item you want to buy: ");
				int c=0,flag=0;
				c=Integer.parseInt(input.nextLine());
				int max=0;
				for(Fruits fru: listFruits) {
					if(fru.getId()==c) {
						System.out.println(fru.getName()+" selected!");
						f.setName(fru.getName());
						f.setPrice(fru.getPrice());
						max=fru.getQuantity();

						flag=1;
						break;
					}else {
						continue;
					}

				}
				if(flag==0) {
					System.out.println("Not Found!");
					break;
				}
				while(true) {
					try {
						System.out.println("Please enter quantity: ");
						int quantity= Integer.parseInt(input.nextLine());
						if(quantity<max) {
							f.setQuantity(quantity);
							listFruitsOfCustomer.add(f);
							break;
						}else {
							System.out.println("Enter quantity less than "+max);
						}
					} catch (Exception e) {
						System.out.println("Please enter number!");
					}
				}

				System.out.println("Do you want to continue?(y/n)");
				String checkContinue=input.nextLine();
				if(checkContinue.equalsIgnoreCase("y")) {
					continue;
				}else {
					//					Product | Quantity | Price | Amount
					//					Coconut       3	          2$	6$
					System.out.println("Enter your name:");
					String name=input.nextLine();
					for(Fruits f1: listFruitsOfCustomer) {
						System.out.println("Product | Quantity | Price | Amount");
						System.out.println(f1.getName()+"\t"+f1.getQuantity()+"\t"+f1.getPrice()+" $"+
								"\t"+f1.getPrice()*f1.getQuantity()+" $");
						sum=sum+f1.getPrice()*f1.getQuantity();
					}
					System.out.println("Total: "+sum+" $");
					customerTable.put(name, listFruitsOfCustomer);	
					break;
				}


			} catch (Exception e) {
				System.out.println("Please enter number!");
			}

		}



	}
	private static void addFruits() {
		while(true) {
			/* Fruit Id, Fruit Name, Price, Quantity and Origin. */
			Fruits f=new Fruits();
			id(f);
			name(f);
			price(f);
			quantity(f);
			origin(f);
			System.out.println("Do you want to continue?(y/n)");
			String check=input.nextLine();
			listFruits.add(f);
			if(check.equalsIgnoreCase("y")) {
				continue;
			}else {
				printFruits(listFruits);
				break;
			}

		}	
	}
	private  static void printFruits(ArrayList<Fruits> listFruits) {
		for(Fruits fru: listFruits) {
			System.out.println("Id \t| Name \t| Price \t|  Quantity \t| Origin ");
			System.out.println(fru);
		}
	}
	private static void origin(Fruits f) {
		System.out.println("Enter origin:");
		f.setOrigin(input.nextLine());
	}
	private static void quantity(Fruits f) {
		while(true) {
			try {
				System.out.println("Enter quantity:");
				f.setQuantity(Integer.parseInt(input.nextLine()));
				break;
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}
		}

	}
	private static void price(Fruits f) {
		while(true) {
			try {
				System.out.println("Enter price:");
				f.setPrice(Integer.parseInt(input.nextLine()));
				break;
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}
		}

	}
	private static void name(Fruits f) {
		System.out.println("Enter name of fruit:");
		f.setName(input.nextLine());

	}
	private static void id(Fruits f) {
		while(true) {
			try {
				System.out.println("Enter id:");
				f.setId(Integer.parseInt(input.nextLine()));
				break;
			} catch (Exception e) {
				System.out.println("Please enter number!");
			}
		}

	}


}
