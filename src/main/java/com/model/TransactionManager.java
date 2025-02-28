package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactionList;
    private ProuductManager productManager;

    public TransactionManager(ProuductManager productManager) {
        this.productManager = productManager;
        this.transactionList = new ArrayList<>();
    }

    public void addStock(int productId, int quantity) {
        Product product = productManager.findProductById(productId);
        if (product == null) {
            System.out.println("Error: Product not found.");
            return;
        }

        product.setQuantity(product.getQuantity() + quantity);

        Transaction transaction = new Transaction(
                generateTransactionId(),
                productId,
                "ADD_STOCK",
                quantity,
                new Date()
        );

        transactionList.add(transaction);
        System.out.println("Stock added successfully.");
    }

    public void removeStock(int productId, int quantity) {
        Product product = productManager.findProductById(productId);
        if (product == null) {
            System.out.println("Error: Product not found.");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Error: Insufficient stock.");
            return;
        }

        product.setQuantity(product.getQuantity() - quantity);

        Transaction transaction = new Transaction(
                generateTransactionId(),
                productId,
                "REMOVE_STOCK",
                quantity,
                new Date()
        );

        transactionList.add(transaction);
        System.out.println("Stock removed successfully.");
    }

    public void viewTransactionHistory(int productId) {
        boolean found = false;
        System.out.println("Transaction history for Product ID: " + productId);
        for (Transaction t : transactionList) {
            if (t.getProductId() == productId) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found for this product.");
        }
    }

    private int generateTransactionId() {
        return transactionList.size() + 1;
    }
}