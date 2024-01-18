package com.ibm.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ibm.example.model.Guitar;
import com.ibm.example.model.GuitarType;
import com.ibm.example.repo.GuitarRepository;
import com.ibm.example.repo.Inventory;

public class App {
	private static Scanner sc = null;
	private static GuitarRepository guitarRepository;
	static {
		guitarRepository = new Inventory();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		int choice = 0;
		while(true) {
			System.out.println("**** MAIN MENU ****");
			System.out.println("1. Add A New Guiter.");
			System.out.println("2. Search A Guiter.");
			System.out.println("3. Get Guiter.");
			System.out.println("4. Show All");
			System.out.println("5. Show Guitar group by types");
			System.out.println("6. Update Guitar");
			System.out.println("7. Exit.");
			System.out.print("enter your choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				double p = 20;
				try {
					System.out.print("Enter Guiter Price: ");
					p = sc.nextDouble();

				} catch (InputMismatchException e) {
					System.out.println("invalid price");
					
				}
				System.out.print("Enter Builder Name: ");
				String b = sc.next();
				System.out.print("Enter Model: ");
				String m = sc.next();
				System.out.print("Enter Guiter Type: ");
				String t = sc.next();
				GuitarType gType=GuitarType.Acoustics;
				try {
					gType = GuitarType.valueOf(t);
				} catch (IllegalArgumentException e) {
					System.out.println("invalid guiter type");
				}
				System.out.print("Enter Back Wood: ");
				String bw = sc.next();
				System.out.print("Enter TopWood: ");
				String tw = sc.next();
				guitarRepository.addGuitar(new Guitar(UUID.randomUUID().toString(), p, b, m, gType, bw, tw));
				break;
			case 2:
				System.out.print("Enter Serial Number: ");
				String s = sc.next();
				Guitar guitar = guitarRepository.getGuitar(s);
				if (guitar != null) {
					System.out.println("Found: " + guitar);
				} else {
					System.out.println("Guiter not found");
				}
				break;
			case 3:
				try {
					System.out.print("Enter Serial Number: ");
					String s1 = sc.next();
					Guitar g = guitarRepository.getGuitar(s1);
					Guitar g1 = guitarRepository.searchGuiter(g);
					if (g1 == null) {
						System.out.println("invalid guiter object");
					} else {
						System.out.println(g1);
					}
				} catch(NullPointerException e) {
					System.out.println("Invalid Input, please enter a valid serial number.");
				}
				break;
			case 4:
				List<Guitar> sortedGuitar = guitarRepository.getAllGuitars();
				for(Guitar g : sortedGuitar) {
					System.out.println(g);
				}
				break;
			case 5:
				System.out.print("Enter Your Types: ");
				String type = sc.next();
				List<Guitar> sortedByType = guitarRepository.getByTypes(type);
				for(Guitar g : sortedByType) {
					System.out.println(g);
				}
				break;
			case 6:
				try {
					System.out.print("Enter Serial Number: ");
					String serialNumber = sc.next();
					Guitar guitar1 = guitarRepository.getGuitar(serialNumber);
					if(guitar1!=null) {
						boolean cond = true;
						while(cond) {
							System.out.println("What you want to update : ");
							System.out.println("1. Price");
							System.out.println("2. Builder");
							System.out.println("3. Model");
							System.out.println("4. Type");
							System.out.println("5. Backwood");
							System.out.println("6. TopWood");
							System.out.println("7. Back");
							int updateChoice = sc.nextInt();
							switch(updateChoice) {
								case 1:
									System.out.print("Enter price : ");
									guitar1.setPrice(sc.nextDouble());
									break;
								case 2:
									System.out.print("Enter Builder : ");
									guitar1.setBuilder(sc.next());
									break;
								case 3:
									System.out.println("Enter Model : ");
									guitar1.setModel(sc.next());
									break;
								case 4:
									System.out.println("Enter Type : ");
									String type1 = sc.next();
									GuitarType gtype=GuitarType.Acoustics;
									try {
										gtype = GuitarType.valueOf(type1);
									} catch (IllegalArgumentException e) {
										System.out.println("invalid guiter type");
									}
									guitar1.setType(gtype);
									break;
								case 5:
									System.out.println("Enter BackWood : ");
									guitar1.setBackWood(sc.next());
									break;
								case 6:
									System.out.println("Enter Top Wood : ");
									guitar1.setTopWood(sc.next());
									break;
								case 7: cond = false; break;
								default: System.out.println("Invalid Option!!!"); break;
							}
						}
					} else {
						System.out.println("Guitar Not Found.");
					}
					
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("Thanks for visiting :)");
				System.exit(0);
			
			default:
				System.out.println("Invalid choice..");
				break;
			}

		}

	}
}