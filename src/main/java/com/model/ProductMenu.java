package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private ProuductManager pManager;

    public ProductMenu(ProuductManager productManager) {
    	this.pManager=productManager;
    }
     

    public void startProductMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Add a product");
            System.out.println("2. Update product details");
            System.out.println("3. Delete a product");
            System.out.println("4. View a product's details");
            System.out.println("5. Display all products");
            System.out.println("6. exit to the main menu");

            int productChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (productChoice) {
                case 1:
                    pManager.add();
                    break;
                case 2:
                    pManager.update();
                    break;
                case 3:
                    pManager.delete();
                    break;
                case 4:
                    pManager.view();
                    break;
                case 5:
                    pManager.viewAll();
                    break;
                case 6:
                    System.out.println("Exiting product manager...");
                    return; 
                default:
                    System.out.println("Invalid input, please re-enter!");
            }
        }
    }
}