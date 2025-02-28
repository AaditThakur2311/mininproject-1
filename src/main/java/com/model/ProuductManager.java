package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProuductManager implements IInventory {

    private List<Product> productList;
    private Scanner scanner;

    public ProuductManager(List<Product>productList) {
        this.productList =(productList!=null)? productList :new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public ProuductManager() {
        this(new ArrayList<>());
    }

    public void add() {
        System.out.println("Enter the name of the product to be added:");
        String name = scanner.nextLine();

        System.out.println("Enter the quantity of the product you want to purchase:");
        int quantity = scanner.nextInt();

        System.out.println("Enter the product ID:");
        int productId = scanner.nextInt();

        System.out.println("Enter the price of the product:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        for (Product p : productList) {
            if (p.getId() == productId) {
                System.out.println("This product ID already exists. Please re-enter.");
                return;
            }
        }

        Product product = new Product(productId, name, quantity, price);
        productList.add(product);
        System.out.println("Product added successfully.");
    }

    @Override
    public void update() {
        System.out.println("Enter the product ID to update:");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product productToUpdate = findProductById(productId);
        if (productToUpdate == null) {
            System.out.println("The product was not found.");
            return;
        }

        System.out.println("Enter the updated name:");
        String name = scanner.nextLine();

        System.out.println("Enter the updated quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Enter the updated price:");
        double price = scanner.nextDouble();

        productToUpdate.setName(name);
        productToUpdate.setPrice(price);
        productToUpdate.setQuantity(quantity);

        System.out.println("The product has been successfully updated.");
    }

    @Override
    public void delete() {
        System.out.println("Enter the product ID to delete:");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product productToRemove = findProductById(productId);
        if (productToRemove == null) {
            System.out.println("Could not find the product.");
            return;
        }

        productList.remove(productToRemove);
        System.out.println("Product deleted successfully.");
    }

    @Override
    public void view() {
        System.out.println("Enter the product ID to view:");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product productToView = findProductById(productId);
        if (productToView == null) {
            System.out.println("Could not find the product.");
            return;
        }

        System.out.println(productToView);
    }

    @Override
    public void viewAll() {
        if (productList.isEmpty()) {
            System.out.println("No products to view. The list is empty.");
            return;
        }

        for (Product allProducts : productList) {
            System.out.println(allProducts);
        }
    }

    public void saveProduct() {
        SerialisationProduct.serialiseProduct(productList);
    }

    public Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}