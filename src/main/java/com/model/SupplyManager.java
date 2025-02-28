package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupplyManager implements IInventory {

    private Supplier supplier;
    private List<Supplier> supplyList;
    private Scanner sc = new Scanner(System.in);


    public SupplyManager(Supplier supplier) {
        this.supplier = supplier;
        this.supplyList = new ArrayList<>();
    }

    
    public SupplyManager(List<Supplier> supplyList) {
        this.supplyList = (supplyList != null) ? supplyList : SerialisationSupplier.deserialiseSuppliers();
        if (this.supplyList == null) {
            this.supplyList = new ArrayList<>(); 
        }
    }


    public void add() {
        if (supplyList == null) {
            supplyList = new ArrayList<>();  
        }

        System.out.println("Enter the name of the supplier:");
        String supplierName = sc.nextLine();

        System.out.println("Enter the supplier ID:");
        int supplierId = sc.nextInt();

        System.out.println("Enter the contact details of the supplier:");
        int supplierContact = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Check if supplier ID already exists
        for (Supplier s : supplyList) {
            if (s.getSupplierId() == supplierId) {
                System.out.println("This supplier ID already exists. Please re-enter.");
                return;
            }
        }

       
        Supplier supplier = new Supplier(supplierId, supplierName, supplierContact);
        supplyList.add(supplier);
        System.out.println("The supplier has been added successfully.");
    }

    @Override
    public void update() {
        System.out.println("Enter the Supplier ID to update:");
        int supplierId = sc.nextInt();
        sc.nextLine();

        Supplier supplierToUpdate = findSupplierById(supplierId);
        if (supplierToUpdate == null) {
            System.out.println("The supplier was not found.");
            return;
        }

        System.out.println("Enter the updated supplier name:");
        String updatedSupplierName = sc.nextLine();

        System.out.println("Enter the updated supplier contact information:");
        int updatedSupplierContact = sc.nextInt();

        supplierToUpdate.setSupplierName(updatedSupplierName);
        supplierToUpdate.setSupplierContactInfo(updatedSupplierContact);

        System.out.println("The supplier has been updated successfully.");
    }

    @Override
    public void delete() {
        System.out.println("Enter the supplier ID to delete:");
        int supplierId = sc.nextInt();
        sc.nextLine();

        Supplier supplierToDelete = findSupplierById(supplierId);
        if (supplierToDelete == null) {
            System.out.println("The supplier was not found.");
            return;
        }

        supplyList.remove(supplierToDelete);
        System.out.println("The supplier has been deleted successfully.");
    }

    @Override
    public void view() {
        System.out.println("Enter the supplier ID to view:");
        int supplierId = sc.nextInt();
        sc.nextLine();

        Supplier supplierToView = findSupplierById(supplierId);
        if (supplierToView == null) {
            System.out.println("The supplier was not found.");
        } else {
            System.out.println(supplierToView);
        }
    }

    @Override
    public void viewAll() {
        if (supplyList == null || supplyList.isEmpty()) {
            System.out.println("The list is empty. There are no suppliers to view.");
            return;
        }

        for (Supplier supply : supplyList) {
            System.out.println(supply);
        }
    }

    public void saveSuppliers() {
        SerialisationSupplier.serialiseSuppliers(supplyList);
    }

    private Supplier findSupplierById(int supplierId) {
        for (Supplier supply : supplyList) {
            if (supply.getSupplierId() == supplierId) {
                return supply;
            }
        }
        return null;
    }
}
