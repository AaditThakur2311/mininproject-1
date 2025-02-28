package com.model;

import java.util.Scanner;

public class SupplierMenu {

	private SupplyManager sManager;

	public SupplierMenu(SupplyManager sManager) {
		super();
		this.sManager = sManager;
	}

	public void startSupplierMenu() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nSupplier Menu:");
			System.out.println("1. Add Supplier");
			System.out.println("2. Update Supplier");
			System.out.println("3. Delete Supplier");
			System.out.println("4. View Supplier");
			System.out.println("5. View All Suppliers");
			System.out.println("6. Exit to the main menu");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Clear buffer

			switch (choice) {
			case 1:
				sManager.add();
				System.out.println("supplier has been added succesfully");
				break;
			case 2:
				sManager.update();
				System.out.println();
				break;
			case 3:
				sManager.delete();
				break;
			case 4:
				sManager.view();
				break;
			case 5:
				sManager.viewAll();
				break;
			case 6:
				System.out.println("Exiting Supplier Menu.");
				return;
			default:
				System.out.println("Invalid input. Please enter a valid choice.");
			}
		}
	}
}
