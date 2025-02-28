package com.model;

import java.util.Scanner;

public class TransactionMenu {
    private Scanner scanner;
    private ProuductManager productManager;
    private TransactionManager transactionManager;

    
    public TransactionMenu(ProuductManager productManager) {
        this.scanner = new Scanner(System.in);
        this.productManager = productManager; 
        this.transactionManager = new TransactionManager(productManager); 
    }

    public void startTransactionMenu() {
        while (true) {
            System.out.println("Press 1 to add stocks to the product");
            System.out.println("Press 2 to remove stocks from the product");
            System.out.println("Press 3 to view the transaction history");
            System.out.println("Press 4 to go back to the main menu");

            int transactionChoice = scanner.nextInt();

            switch (transactionChoice) {
                case 1:
                    addStockMenu();
                    break;

                case 2:
                    removeStockMenu();
                    break;

                case 3:
                    viewTransactionMenu();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Enter a valid number.");
            }
        }
    }

    private void addStockMenu() {
        System.out.println("Enter the product ID to add stock:");
        int productId = scanner.nextInt();

        System.out.println("Enter the quantity to add:");
        int quantity = scanner.nextInt();

        transactionManager.addStock(productId, quantity);
    }

    private void removeStockMenu() {
        System.out.println("Enter the product ID of the stock you want to remove:");
        int productId = scanner.nextInt();

        System.out.println("Enter the quantity of the stock you want to remove:");
        int quantity = scanner.nextInt();

        transactionManager.removeStock(productId, quantity);
    }

    private void viewTransactionMenu() {
        System.out.println("Enter the product ID of the transaction you want to view:");
        int productId = scanner.nextInt();

        transactionManager.viewTransactionHistory(productId);
    }
}
