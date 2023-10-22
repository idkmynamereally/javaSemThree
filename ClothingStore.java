package ClothingStore;
import java.util.ArrayList;
import java.util.Scanner;

class Store {
	static String name;
	static ArrayList <Clothes> mensWear = new ArrayList<Clothes>();
	static ArrayList <Clothes> womensWear = new ArrayList<Clothes>();
	static ArrayList <Clothes> kidsWear = new ArrayList<Clothes>();
	private Store() {};
	
	static {		// EXAMPLE CREATOR
		for (int i = 0; i < 20; i++) {
			String name = "Item" + (i + 1);
			int price = (i+1)*500;
			int size = 6*(i+1)%64;
			String color = "Black";
			String type;
			if (i % 2 == 0) {
				type = "mens";
			}
			else {
				type = "womens";
			}
			addCloth(name, price, type, size, color);
		}
	}
	
	static void addCloth() {
		Scanner sc = new Scanner(System.in);
		String name;
		int price;
		String type;
		int size;
		String color;
		Clothes temp;
		System.out.print("Enter Item Name : ");
		name = sc.nextLine();
		System.out.print("Enter Price : ");
		price = sc.nextInt();
		System.out.print("Enter Type : ");
		sc.nextLine();
		type = sc.nextLine();
		System.out.print("Enter Size : ");
		size = sc.nextInt();
		System.out.print("Enter Color : ");
		sc.nextLine();
		color = sc.nextLine();
		addCloth(name, price, type, size, color);
		sc.close();
	}
	
	static void addCloth(String name, int price, String type, int size, String color) {
		Clothes temp = new Clothes(name, price, type, size, color);
		if (type.equalsIgnoreCase("mens")) {
			mensWear.add(temp);
		}
		else if (type.equals("womens")) {
			womensWear.add(temp);
		}
		else if (type.equals("kid")) {
			kidsWear.add(temp);
		}
	}
	
	static int getTotalUnits() {
		int totalUnits;
		totalUnits = mensWear.size() + womensWear.size() + kidsWear.size(); 
		return totalUnits;
	}
	
	static int getTotalPrice() {
		int totalPrice = 0;
		for (int i = 0; i < mensWear.size(); i++) {
			totalPrice = totalPrice + mensWear.get(i).getPrice();
		}
		for (int i = 0; i < womensWear.size(); i++) {
			totalPrice = totalPrice + womensWear.get(i).getPrice();
		}
		for (int i = 0; i < kidsWear.size(); i++) {
			totalPrice = totalPrice + kidsWear.get(i).getPrice();
		}
		return totalPrice;
	}
	
	static Clothes getItem() {
		String name = null;
		String type = null;
		Clothes temp = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Item Name : ");
		name = sc.nextLine();
		System.out.print("Enter Item Type : ");
		type = sc.nextLine();
		
		if (type.equalsIgnoreCase("mens")) {
			for(int i = 0; i < mensWear.size(); i++) {
				if (mensWear.get(i).getName() == name) {
					temp = mensWear.get(i);
				}
			}
		}
		
		if (type.equalsIgnoreCase("womens")) {
			for(int i = 0; i < mensWear.size(); i++) {
				if (womensWear.get(i).getName() == name) {
					temp = womensWear.get(i);
				}
			}
		}
		
		if (type.equalsIgnoreCase("kids")) {
			for(int i = 0; i < kidsWear.size(); i++) {
				if (kidsWear.get(i).getName() == name) {
					temp = kidsWear.get(i);
				}
			}
		}
		
		return temp;
	}
	
	static void applySale() {
		System.out.print("Enter Sale Amount : ");
		Scanner sc = new Scanner(System.in);
		int sale = sc.nextInt();
		mensWear.forEach((n) -> n.appSale(sale));
		womensWear.forEach((n) -> n.appSale(sale));
		kidsWear.forEach((n) -> n.appSale(sale));
	}
}

abstract class Product{
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	private String name;
	private int price;
	
	String getName() {
		return name;
	}
	
	int getPrice() {
		return price;
	}
	
	void appSale(int sale) {
		price = price * (sale/100);
	}
}
		
class Clothes extends Product{
	Clothes(String name, int price, String type, int size, String color){
		super(name,price);
		this.type = type;
		this.size = size;
		this.color = color;
	}
	private String type;
	private int size;
	private String color;
	
	String getType() {
		return type;
	}
	
	int getSize() {
		return size;
	}
	
	String getColor() {
		return color;
	}
	
	@Override public String toString() {
		String ret;
		ret = "\nName : " + this.getName() + "\nType : " + this.getType() + "\nPrice : " + this.getPrice() + "\nSize : " + this.size + "\nColor : " + this.getColor();
		return ret;
	}
}


class ClothingStore{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		printLogo();
		int input = 1;
		int menu = 1;
		boolean check = true;
		System.out.print("1 for DevMenu\n2 for UserMenu\nChoice : ");
		menu = sc.nextInt();
		//	Dev3 Menu
		if (menu == 1) {
			while (check) {
				printMenu();
				System.out.print("Choice : ");
				input = sc.nextInt();
				switch(input) {
					case 1: Store.addCloth();
							break;
					case 2: printStats();
							break;
					case 3: Store.getItem();
							break;
					case 4: Store.applySale();
							break;		
					case 5: check = false; 
				}
			}
		}
		//User Menu
		if (menu == 2) {
			while (check) {
				printMenuUser();
				System.out.print("Choice : ");
				input = sc.nextInt();
				switch(input) {
					case 1: printItemsUser();
							break;
					case 2: Store.getItem();
							break;
					case 3: check = false; 
				}
			}
		}
		
	}
	static void printLogo() {
	
		System.out.print("\n\n\t|------------CLOTHING STORE MANAGEMENT APP------------|\t\n\n");
	}
	
	static void printStats() {
		System.out.println("\nTotal Units : " + Store.getTotalUnits());
		System.out.println("Total Cost : " + Store.getTotalPrice() + "\n");
	}
	
	static void printMenu() {
		System.out.println("1. Add Cloth");
		System.out.println("2. Show Statistics");
		System.out.println("3. Remove Cloth");
		System.out.println("4. Apply Sale");
		System.out.println("5. Exit");
	}
	
	static void printMenuUser() {
		System.out.println("\n1. Print Items");
		System.out.println("2. Get Item");
	}
	
	static void printItemsUser() {
		System.out.println("1. Print Men's Wear Items");
		System.out.println("2. Print Women's Wear Items");
		System.out.println("3. Print Kid's Wear Items");
		int input = 1;
		System.out.print("Enter Choice : ");
		input = sc.nextInt();
		if (input == 1) {
			for (int i = 0; i < Store.mensWear.size(); i++) {
				System.out.println(Store.mensWear.get(i));
			}
		}
		if (input == 2) {
			for (int i = 0; i < Store.mensWear.size(); i++) {
				System.out.println(Store.womensWear.get(i));
			}
		}
		if (input == 3) {
			for (int i = 0; i < Store.mensWear.size(); i++) {
				System.out.println(Store.kidsWear.get(i));
			}
		}
	}
}
